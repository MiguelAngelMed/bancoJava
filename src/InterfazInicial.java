import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*; // Class Container
import java.awt.event.*;


public class InterfazInicial extends JFrame implements ActionListener{
    
    
    private static final int WIDTH = 500;
	private static final int HEIGHT = 200;
    

    private JLabel titulo;
    private JButton botonAdministrador;
    private JButton botonCliente;
    
    
    
    

    public InterfazInicial( ){
		
		
        setLayout(null);
        titulo = new JLabel("Bienvenido al sistema del banco "+App.miBanco.getNombre());
        titulo.setBounds(50, 30, 450, 30);
        titulo.setFont(new Font("Comic Sans MS", 0, 20));
        titulo.setForeground(new Color(102, 103, 251)); //color es de java.awt
        add(titulo);

       
        botonAdministrador = new JButton("Administrador");
        botonAdministrador.setBounds(80,90,150,30);
        botonAdministrador.addActionListener(this);
        add(botonAdministrador);

        botonCliente = new JButton("Cliente");
        botonCliente.setBounds(280,90,150,30);
        botonCliente.addActionListener(this);
        add(botonCliente);
        

        setTitle("Banco "+App.miBanco.getNombre());
        setSize(WIDTH, HEIGHT);
		setVisible(true);
        setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == botonAdministrador){
            InterfazAdministradorBanco admiInter = new InterfazAdministradorBanco();
            admiInter.setTitle("Administrador Banco");
            
            admiInter.setVisible(true);
            admiInter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            admiInter.setResizable(false);
        }
        else if(e.getSource() == botonCliente){
            InterfazCliente clientesInter = new InterfazCliente();
            clientesInter.setTitle("Administrador Banco");
            
            clientesInter.setVisible(true);
            clientesInter.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            clientesInter.setResizable(false);
        }

        
        
    }
}
