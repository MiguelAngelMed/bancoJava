import javax.swing.*;
import java.awt.*; // Class Container
import java.awt.event.*;

public class InterfazAdministradorBanco extends JFrame implements ActionListener{
    
    
    private static final int WIDTH = 500;
	private static final int HEIGHT = 700;
    
    private JLabel textAgregarCli;
    private JLabel textNombre,textEdad,textTel,textDirec, textcorreo; 
    private JLabel textIdCli, textTipoCuenta,textAgregarCuenta;
    
    private JTextField fieldNombre, fieldEdad, fieldTel,fieldDirec,fieldCorreo;
    private JTextField fieldIdCli;
    private JButton btnAgregarCliente,btnCapturarDatos,btnGenerarReporte;
    private JComboBox comboCuentas;
    private JTextArea textReporte;
    private JScrollPane scrollpane1;


    public InterfazAdministradorBanco(){
		setSize(WIDTH, HEIGHT);
        setLayout(null);
        
        textAgregarCli = new JLabel("Agregar cliente");
        textAgregarCli.setBounds(20, 20, 450, 30);
        textAgregarCli.setFont(new Font("Comic Sans MS", 0, 15));
        textAgregarCli.setForeground(new Color(102, 103, 251)); //color es de java.awt
        add(textAgregarCli);



        textNombre = new JLabel("Nombre: ");
        textNombre.setBounds(20, 65, 80, 30);
        textNombre.setFont(new Font("Comic Sans MS", 0, 15));
        add(textNombre);

		fieldNombre = new JTextField();
        fieldNombre.setBounds(100, 65, 150, 30);
        fieldNombre.setFont(new Font("Comic Sans MS", 0, 15));
        add(fieldNombre);

        textEdad = new JLabel("Edad: ");
        textEdad.setBounds(20, 97, 80, 30);
        textEdad.setFont(new Font("Comic Sans MS", 0, 15));
        add(textEdad);

		fieldEdad = new JTextField();
        fieldEdad.setBounds(100, 97, 150, 30);
        fieldEdad.setFont(new Font("Comic Sans MS", 0, 15));
        add(fieldEdad);

        textTel = new JLabel("Telefono: ");
        textTel.setBounds(20, 129, 80, 30);
        textTel.setFont(new Font("Comic Sans MS", 0, 15));
        add(textTel);

		fieldTel = new JTextField();
        fieldTel.setBounds(100, 129, 150, 30);
        fieldTel.setFont(new Font("Comic Sans MS", 0, 15));
        add(fieldTel);

        textDirec = new JLabel("Direccion: ");
        textDirec.setBounds(20, 161, 80, 30);
        textDirec.setFont(new Font("Comic Sans MS", 0, 15));
        add(textDirec);

		fieldDirec = new JTextField();
        fieldDirec.setBounds(100, 161, 150, 30);
        fieldDirec.setFont(new Font("Comic Sans MS", 0, 15));
        add(fieldDirec);



        textcorreo = new JLabel("Correo: ");
        textcorreo.setBounds(20, 193, 80, 30);
        textcorreo.setFont(new Font("Comic Sans MS", 0, 15));
        add(textcorreo);

		fieldCorreo = new JTextField();
        fieldCorreo.setBounds(100, 193, 150, 30);
        fieldCorreo.setFont(new Font("Comic Sans MS", 0, 15));
        add(fieldCorreo);

        btnAgregarCliente = new JButton("Agregar");
        btnAgregarCliente.setBounds(100, 226, 130, 30);
        btnAgregarCliente.setFont(new Font("Comic Sans MS", 0, 15));
        btnAgregarCliente.addActionListener(this);
        add(btnAgregarCliente);

       
        textAgregarCuenta = new JLabel("Agregar cuenta cliente");
        textAgregarCuenta.setBounds(20, 300, 450, 30);
        textAgregarCuenta.setFont(new Font("Comic Sans MS", 0, 15));
        textAgregarCuenta.setForeground(new Color(102, 103, 251)); //color es de java.awt
        add(textAgregarCuenta);


        textIdCli = new JLabel("ID cliente: ");
        textIdCli.setBounds(20, 332, 80, 30);
        textIdCli.setFont(new Font("Comic Sans MS", 0, 15));
        add(textIdCli);

        fieldIdCli = new JTextField();
        fieldIdCli.setBounds(100, 332, 150, 30);
        fieldIdCli.setFont(new Font("Comic Sans MS", 0, 15));
        add(fieldIdCli);

        textTipoCuenta = new JLabel("Tipo de cuenta: ");
        textTipoCuenta.setBounds(20, 364, 110, 30);
        textTipoCuenta.setFont(new Font("Comic Sans MS", 0, 15));
        add(textTipoCuenta);
        
        comboCuentas = new JComboBox();
        comboCuentas.setBounds(130,364,200,30); 
        comboCuentas.setFont(new Font("Comic Sans MS", 0, 15));
        
        comboCuentas.addItem("Cuenta de Ahorros");
        comboCuentas.addItem("Cuenta de CETES");
        comboCuentas.addItem("Cuenta de Cheques");
        comboCuentas.addItem("Cuenta de Credito");
        comboCuentas.addItem("Cuenta de Debito"); 
        add(comboCuentas);


        btnCapturarDatos = new JButton("Capturar Datos");
        btnCapturarDatos.setBounds(100, 400, 150, 30);
        btnCapturarDatos.setFont(new Font("Comic Sans MS", 0, 15));
        btnCapturarDatos.addActionListener(this);
        add(btnCapturarDatos);



        btnGenerarReporte = new JButton("Generar reporte clientes");
        btnGenerarReporte.setBounds(70, 450, 220, 40);
        btnGenerarReporte.setFont(new Font("Comic Sans MS", 0, 16));
        btnGenerarReporte.addActionListener(this);
        add(btnGenerarReporte);

        textReporte = new JTextArea();
        textReporte.setLineWrap(true);
        textReporte.setFont(new Font("Comic Sans MS", 0, 15));
        scrollpane1 = new JScrollPane(textReporte);
        scrollpane1.setBounds(10, 500, 470, 150);
        add(scrollpane1);

        //titulo = new JLabel("Bienvenido al sistema del banco "+InterfazInicial.miBanco.getNombre());
        
		
        
	}
	
    public void itemStateChanged(ItemEvent ev){
        comboCuentas.getSelectedItem();
    }

	public void actionPerformed(ActionEvent e){
	    if(e.getSource() == btnAgregarCliente){
            String nombre, telefono,direccion, correo;
            int edad;
            try{
                nombre = fieldNombre.getText();
                telefono = fieldTel.getText();
                direccion = fieldDirec.getText();
                correo = fieldCorreo.getText();
                edad = Integer.parseInt(fieldEdad.getText());
                App.miBanco.agregarCliente(new Cliente(nombre, edad, telefono, direccion, correo));
                
                JFrame frameRealizo = new JFrame();
                JOptionPane.showMessageDialog(frameRealizo, "El cliente se ha agregado");
  
                fieldNombre.setText("");
                fieldTel.setText("");
                fieldDirec.setText("");
                fieldCorreo.setText("");
                fieldEdad.setText("");
            
            }catch(Exception ex){
                JFrame frameAlerta = new JFrame();
                JOptionPane.showMessageDialog(frameAlerta, "Intoduce la edad con numeros, ej: 23");
            }
        }
        else if(e.getSource() == btnGenerarReporte){
            textReporte.setText("");
            textReporte.setText(App.miBanco.generarReporteClientes()); 
            
        }
        else if(e.getSource() == btnCapturarDatos){
            int idCli;
            String tipoCuenta;

            try {
                tipoCuenta = comboCuentas.getSelectedItem().toString();
                idCli = Integer.parseInt(fieldIdCli.getText());

                
                
                if(tipoCuenta.equals("Cuenta de Ahorros")){
                    String numCuenta;
                    double saldo,tasaInt;

                    try {
                        numCuenta = JOptionPane.showInputDialog("Introduce el numero de cuenta: ");
                        saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el saldo inicial"));
                        tasaInt = Double.parseDouble(JOptionPane.showInputDialog("Introduce la tasa de interes"));

                        /***Upcasting**/
                        App.miBanco.getCliente().get(idCli-1).agregarCuenta(new CuentaAhorros(numCuenta,saldo,tasaInt));
                        fieldIdCli.setText("");
                    } catch (Exception ex1) {
                        JFrame frameAler = new JFrame();
                        JOptionPane.showMessageDialog(frameAler, "Has introducido los datos de forma erronea o el cliente no existe");
                    }
                   
                }
                else if(tipoCuenta.equals("Cuenta de Cheques")){
                    String numCuenta;
                    double saldo,sobreGiro;

                    try {
                        numCuenta = JOptionPane.showInputDialog("Introduce el numero de cuenta: ");
                        saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el saldo inicial"));
                        sobreGiro = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto de sobregiro"));

                        /***Upcasting**/
                        App.miBanco.getCliente().get(idCli-1).agregarCuenta(new CuentaCheques(numCuenta,saldo,sobreGiro));
                        fieldIdCli.setText("");
                    } catch (Exception ex1) {
                        JFrame frameAler = new JFrame();
                        JOptionPane.showMessageDialog(frameAler, "Has introducido los datos de forma erronea o el cliente no existe");
                    }
                }
                else if(tipoCuenta.equals("Cuenta de CETES")){
                    String numCuenta;
                    double saldo;
                    int diasPlazo=0;

                    try {
                        numCuenta = JOptionPane.showInputDialog("Introduce el numero de cuenta: ");
                        saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el saldo inicial"));
                        diasPlazo = Integer.parseInt(JOptionPane.showInputDialog("Introduce el plazo"));

                        /***Upcasting**/
                        App.miBanco.getCliente().get(idCli-1).agregarCuenta( new CuentaCetes(numCuenta,saldo,diasPlazo));
                        fieldIdCli.setText("");
                    } catch (Exception ex1) {
                        JFrame frameAler = new JFrame();
                        JOptionPane.showMessageDialog(frameAler, "Has introducido los datos de forma erronea o el cliente no existe");
                    }
                    
                }
                else if(tipoCuenta.equals("Cuenta de Credito")){
                    String numCuenta;
                    double saldo, credito;

                    try {
                        numCuenta = JOptionPane.showInputDialog("Introduce el numero de cuenta: ");
                        saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el saldo inicial"));
                        credito = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto del credito disponible "));

                        /***Upcasting**/
                        App.miBanco.getCliente().get(idCli-1).agregarCuenta( new CuentaCredito(numCuenta,saldo,credito));
                        fieldIdCli.setText("");
                    } catch (Exception ex1) {
                        JFrame frameAler = new JFrame();
                        JOptionPane.showMessageDialog(frameAler, "Has introducido los datos de forma erronea o el cliente no existe");
                    }
                }
                else if(tipoCuenta.equals("Cuenta de Debito")){
                    String numCuenta;
                    double saldo;

                    try {
                        numCuenta = JOptionPane.showInputDialog("Introduce el numero de cuenta: ");
                        saldo = Double.parseDouble(JOptionPane.showInputDialog("Introduce el saldo inicial"));
                        

                        /***Upcasting**/
                        App.miBanco.getCliente().get(idCli-1).agregarCuenta( new CuentaDebito(numCuenta,saldo));
                        fieldIdCli.setText("");
                    } catch (Exception ex1) {
                        JFrame frameAler = new JFrame();
                        JOptionPane.showMessageDialog(frameAler, "Has introducido los datos de forma erronea o el cliente no existe");
                    }
                }
                
            } catch (Exception ex) {
                JFrame frameAlerta = new JFrame();
                JOptionPane.showMessageDialog(frameAlerta, "Intoduce id con numeros:)");
            }

        }
        
		
	}
	

   
}
