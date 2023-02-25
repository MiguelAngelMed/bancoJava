import javax.swing.*;
import java.awt.*; // Class Container
import java.awt.event.*;
import java.util.ArrayList;

public class InterfazCliente extends JFrame implements ActionListener{
    
    private int idCli=0;
    private static final int WIDTH = 550;
	private static final int HEIGHT = 300;
    
    private JLabel textIntroduzcaId, textSelecionarCuenta,textAcciones;
    private JTextField fieldIdCli;
    private JButton iniciarSesion, btnAccion, btnSeleccionar;
    private JComboBox comboCuentasCli, comboAcciones;

    public InterfazCliente(){
		setSize(WIDTH, HEIGHT);
        setLayout(null);

        textIntroduzcaId = new JLabel("Introduzca ID de cliente: ");
        textIntroduzcaId.setBounds(20, 30, 200, 30);
        textIntroduzcaId.setFont(new Font("Comic Sans MS", 0, 15));
        add(textIntroduzcaId);

        
		fieldIdCli = new JTextField();
        fieldIdCli.setBounds(220, 30, 70, 30);
        fieldIdCli.setFont(new Font("Comic Sans MS", 0, 15));
        add(fieldIdCli);
        
        iniciarSesion = new JButton("Iniciar Sesion");
        iniciarSesion.setBounds(295,30,200,30);
        iniciarSesion.setFont(new Font("Comic Sans MS", 0, 15));
        iniciarSesion.addActionListener(this);
        add(iniciarSesion);

        textSelecionarCuenta = new JLabel("Seleccione una de sus Cuentas");
        textSelecionarCuenta.setBounds(20, 62, 250, 30);
        textSelecionarCuenta.setFont(new Font("Comic Sans MS", 0, 15));
        add(textSelecionarCuenta);	
        
        comboCuentasCli = new JComboBox();
        comboCuentasCli.setBounds(20,94,200,30); 
        comboCuentasCli.setFont(new Font("Comic Sans MS", 0, 15)); 
        add(comboCuentasCli);

        btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setBounds(230,94,130,30);
        btnSeleccionar.setFont(new Font("Comic Sans MS", 0, 15)); 
        btnSeleccionar.addActionListener(this);
        add(btnSeleccionar);
          
        textAcciones = new JLabel("Seleccione que movimiento desea realizar");
        textAcciones.setBounds(20, 130, 400, 30);
        textAcciones.setFont(new Font("Comic Sans MS", 0, 15));
        add(textAcciones);
       
       
        comboAcciones = new JComboBox();
        comboAcciones.setBounds(20,162,220,30); 
        comboAcciones.setFont(new Font("Comic Sans MS", 0, 15)); 
        add(comboAcciones);

        btnAccion = new JButton("Iniciar");
        btnAccion.setBounds(250,162,100,30); 
        btnAccion.setFont(new Font("Comic Sans MS", 0, 15)); 
        btnAccion.addActionListener(this);
        add(btnAccion);

	}
	
    public void ponerItems(){
        comboAcciones.addItem("Retirar");
        comboAcciones.addItem("Depositar");
        comboAcciones.addItem("Consultar saldo");
    }

    
    

	public void actionPerformed(ActionEvent e){
		String cuentaAccion;
        Cuenta aux=null;

        if(e.getSource() == iniciarSesion){
            try {
                idCli = Integer.parseInt(fieldIdCli.getText());
                
                ArrayList<Cuenta> arrCuentasAux =  App.miBanco.getCliente().get(idCli-1).getCuentas();
                comboCuentasCli.removeAllItems();
                for(Cuenta aux1: arrCuentasAux){
                    comboCuentasCli.addItem(aux1.getNumCuenta());
                }
                   
            } catch (Exception ex1) {
                JFrame frameAler = new JFrame();
                JOptionPane.showMessageDialog(frameAler, "A introducido el ID de forma incorrecta"+
                                                         "\n o no existe el id");
            }
        }
        else if(e.getSource() == btnAccion){
            double monto=0;
            try {
                ArrayList<Cuenta> arrCuentasAux =  App.miBanco.getCliente().get(idCli-1).getCuentas();
                cuentaAccion = comboCuentasCli.getSelectedItem().toString();
                
                for(Cuenta aux1: arrCuentasAux){
                    if(aux1.getNumCuenta().equals(cuentaAccion)){
                       aux = aux1;
                       break;
                    }
                }
    
                
                if(aux instanceof CuentaAhorros){
                    /*** DownCasting****/
                    CuentaAhorros cAho = (CuentaAhorros) aux;
                    if(comboAcciones.getSelectedItem().toString().equals("Depositar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a depositar")); 
                        cAho.depositar(monto);

                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Retirar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a retirar")); 
                        cAho.retirar(monto);
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Consultar saldo")){
                        JFrame consultaSaldo = new JFrame();
                        JOptionPane.showMessageDialog(consultaSaldo, "Su saldo es $"+cAho.getSaldo());
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Cobrar intereses")){
                        cAho.cobrarIntereses();
                        JFrame cobrar = new JFrame();
                        JOptionPane.showMessageDialog(cobrar, "Se han cobrado los intereses");
                    }
                }
                else if(aux instanceof CuentaCetes){
                    CuentaCetes cCetes = (CuentaCetes) aux;
                    if(comboAcciones.getSelectedItem().toString().equals("Depositar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a depositar")); 
                        cCetes.depositar(monto);

                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Retirar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a retirar")); 
                        cCetes.retirar(monto);
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Consultar saldo")){
                        JFrame consultaSaldo = new JFrame();
                        JOptionPane.showMessageDialog(consultaSaldo, "Su saldo es $"+cCetes.getSaldo());
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Cobrar rendimiento")){
                        cCetes.cobrarRendimiento();;
                        JFrame cobrar = new JFrame();
                        JOptionPane.showMessageDialog(cobrar, "Se ha cobrado el rendimiento");
                    }


                }
                else if(aux instanceof CuentaCheques){
                    CuentaCheques cChe = (CuentaCheques) aux;
                    if(comboAcciones.getSelectedItem().toString().equals("Depositar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a depositar")); 
                        cChe.depositar(monto);

                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Retirar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a retirar")); 
                        cChe.retirar(monto);
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Consultar saldo")){
                        JFrame consultaSaldo = new JFrame();
                        JOptionPane.showMessageDialog(consultaSaldo, "Su saldo es $"+cChe.getSaldo());
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Consultar sobregiro")){
                        
                        JFrame consultaSobreGiro = new JFrame();
                        JOptionPane.showMessageDialog(consultaSobreGiro, "Su sobregiro es $"+cChe.consultarSobregiro());
                    }

                    
                }
                else if(aux instanceof CuentaCredito){
                    CuentaCredito cCred = (CuentaCredito) aux;
                    if(comboAcciones.getSelectedItem().toString().equals("Depositar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a depositar")); 
                        cCred.depositar(monto);

                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Retirar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a retirar")); 
                        cCred.retirar(monto);
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Consultar saldo")){
                        JFrame consultaSaldo = new JFrame();
                        JOptionPane.showMessageDialog(consultaSaldo, "Su saldo es $"+cCred.getSaldo());
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Pagar deuda")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto del abono")); 
                        cCred.pagarDeuda(monto);
                    }
                    
                }
                else if(aux instanceof CuentaDebito){
                    CuentaDebito cDeb = (CuentaDebito) aux;
                    if(comboAcciones.getSelectedItem().toString().equals("Depositar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a depositar")); 
                        cDeb.depositar(monto);

                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Retirar")){
                        monto = Double.parseDouble(JOptionPane.showInputDialog("Introduce el monto a retirar")); 
                        cDeb.retirar(monto);
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Consultar saldo")){
                        JFrame consultaSaldo = new JFrame();
                        JOptionPane.showMessageDialog(consultaSaldo, "Su saldo es $"+cDeb.getSaldo());
                    }
                    else if(comboAcciones.getSelectedItem().toString().equals("Cobrar rendimiento")){
                        cDeb.cobrarRendimiento();
                        JFrame cobrar = new JFrame();
                        JOptionPane.showMessageDialog(cobrar, "Se ha cobrado el rendimiento");
                    }
                    
                }
                
            } catch (Exception ex3) {
                JFrame frameAler = new JFrame();
                JOptionPane.showMessageDialog(frameAler, "ERROR :(");
            }
            
            
        }
		else if(e.getSource() == btnSeleccionar){
        String cuentaSelec;
        Cuenta auxCombo=null;
            try{
                cuentaSelec = comboCuentasCli.getSelectedItem().toString();
                ArrayList<Cuenta> arrCuentasAux =  App.miBanco.getCliente().get(idCli-1).getCuentas();
                
                
                for(Cuenta aux1: arrCuentasAux){
                    if(aux1.getNumCuenta() == cuentaSelec){
                       auxCombo = aux1;
                       break;
                    }
                }

                if(auxCombo instanceof CuentaAhorros){
                    comboAcciones.removeAllItems();
                    ponerItems();
                    comboAcciones.addItem("Cobrar intereses");
                }
                else if(auxCombo instanceof CuentaCetes){
                    comboAcciones.removeAllItems();
                    ponerItems();
                    comboAcciones.addItem("Cobrar rendimiento");
                }
                else if(auxCombo instanceof CuentaCheques){
                    comboAcciones.removeAllItems();
                    ponerItems();
                    comboAcciones.addItem("Consultar sobregiro");
                }
                else if(auxCombo instanceof CuentaCredito){
                    comboAcciones.removeAllItems();
                    ponerItems();
                    comboAcciones.addItem("Pagar deuda");
                }
                else if(auxCombo instanceof CuentaDebito){
                    comboAcciones.removeAllItems();
                    ponerItems();
                    comboAcciones.addItem("Cobrar rendimiento");
                }
            
            }catch(Exception ex2){
                JFrame frameAler = new JFrame();
                JOptionPane.showMessageDialog(frameAler, "ERROR :(");
            }
        }
	}
	

   
}

