import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class App {
    public static Banco miBanco = new Banco("Angelopolis");
    public static void main(String[] args) throws Exception {
        
        InterfazInicial ventana1 = new InterfazInicial();

        /*
        //Creacion de un objeto banco
        Banco miBanco = new Banco("Angelopolis");

        //Creacion de objetos cliente utilizando el construcntor definido por mi
        Cliente angel = new Cliente("Angel", 19, "55-77-16-29-15", "Avenida Durazno", "angel@gmail.com");
        Cliente alex = new Cliente("Alexis", 20, "55-45-32-29-19", "Avenida Fresa", "alexis@gmail.com");
        Cliente isa = new Cliente("Isamar", 27, "55-57-16-19-16", "Avenida Sandia", "isamar@gmail.com");
        Cliente moni = new Cliente("Monica", 45, "55-68-54-69-66", "Avenida Frambuesa", "monica@gmail.com");

        //Agregacion de clases, Un banco tiene 0 o muchos clientes
        miBanco.agregarCliente(angel);
        miBanco.agregarCliente(alex);
        miBanco.agregarCliente(isa);
        miBanco.agregarCliente(moni);

        System.out.println("***Escenario agregación de clases***");
        miBanco.generarReporteClientes();
        
        System.out.println("\n***Escenario uso de static***");
        miBanco.consultarNumClientes();

     
        //uso de las diferentes cuentas que heredan de Cuenta
        System.out.println("\n***Uso de herencia de las clase Cuenta***");
        /****Polimorfismo UpCasting****/
        /*
        Cuenta cAhorros1 = new CuentaAhorros("ANG14", 550.00, 0.12);  
        //CuentaAhorros cAhorros1 = new CuentaAhorros("ANG14", 550.00, 0.12); 
        angel.agregarCuenta(cAhorros1);
        
        CuentaCetes cCetes1 = new CuentaCetes("C1ANG", 5000.00, 91);
        angel.agregarCuenta(cCetes1);

        CuentaCheques cCheques1 = new CuentaCheques("CHALX4", 2000.00, 1500.00);
        alex.agregarCuenta(cCheques1);
        
        CuentaDebito cDebito1 = new CuentaDebito("DEISA45", 7500.00);
        isa.agregarCuenta(cDebito1);
        
        CuentaCredito cCred1 = new CuentaCredito("CRE8915", 4000.00, 10000.00);
        moni.agregarCuenta(cCred1);

        /****SOBRECARGA DE METODOS ****/

        /*
        CuentaAhorros cAhorros2 = new CuentaAhorros("AHMNI4", 750.00, 0.2);
        moni.agregarCuenta(cAhorros2);
        CuentaCetes cCetes2 = new CuentaCetes("CETMNI17", 5000.00, 91);
        CuentaDebito cDebito2 = new CuentaDebito("DEMNI45", 15000.00);
        moni.agregarCuenta(cCetes2,cDebito2);
        
        

        System.out.println("\n***Ver cuentas de cada cliente***");

        angel.verCuentas();
        alex.verCuentas();
        isa.verCuentas();
        moni.verCuentas();

        /****Manejo cuentaAhorros ****/
        /*
        System.out.println("****Manejo cuentaAhorros ****");
        cAhorros1.depositar(500);
        System.out.println("Saldo cuenta cAhorros1: $"+String.format("%.2f", cAhorros1.consultarSaldo()));

        /////*Downcasting*////////
        /*
        CuentaAhorros aux = (CuentaAhorros) cAhorros1; 
        aux.cobrarIntereses();
        System.out.println("Saldo cuenta cAhorros1: $"+String.format("%.2f", cAhorros1.consultarSaldo()));
        aux.cobrarIntereses(5);
        System.out.println("Saldo cuenta cAhorros1: $"+String.format("%.2f", cAhorros1.consultarSaldo()));
        cAhorros1.verMovimientos();  

        /****Manejo cuentaCetes ****/

        /*
        System.out.println("****Manejo cuentaCetes ****");
        cCetes1.depositar(500);
        System.out.println("cCetes1: $"+String.format("%.2f", cCetes1.consultarSaldo()));
        cCetes1.cobrarRendimiento();        
        System.out.println("cCetes1: $"+String.format("%.2f", cCetes1.consultarSaldo()));
        cCetes1.transferir(cAhorros1, 100.00);
        cCetes1.verMovimientos();

        
        /****Manejo cuentaCheques ****/
        /*
        System.out.println("****Manejo cuentaCheques ****");
        cCheques1.retirar(600);
        System.out.println("cCheques1: \n"+cCheques1.toString());
        cCheques1.retirar(7000);

        /****Manejo cuentaCredito ****/
        /*
        System.out.println("****Manejo cuentaCredito ****");
        cCred1.pagarConCredito(1200.50);
        cCred1.retirar(2000.00);
        cCred1.pagarDeuda(100.00);
        System.out.println("\n"+cCred1.toString());
        cCred1.verMovimientos();


        /****Manejo cuentaDebito ****/
        /*
        System.out.println("****Manejo cuentaDebito ****");
        cDebito1.cobrarRendimiento();
        cDebito1.depositar(1400.00);
        cDebito1.transferir(cCred1, 700);
        cDebito1.verMovimientos();
        System.out.println(cDebito1.toString());
        */




        
    }
}
