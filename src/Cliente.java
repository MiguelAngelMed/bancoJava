import java.util.ArrayList;

public class Cliente extends Persona{
    
    private String idCliente;
    //Agregación de clases 
    private ArrayList<Cuenta> cuentasCli;
    //Variable static
    private static int numClientes=0;
    private int numCuentas;

    //Constructores
    public Cliente(String nombre, int edad,String tel,String direccion,String correo){
        super(nombre, edad, tel, direccion, correo);
        numCuentas=0;
        numClientes++;
        idCliente = numClientes+"_CL";
        cuentasCli = new ArrayList<>();
    }

    //Redefinicion del metodo toString() de la clase Persona
    public String toString(){
        return "\nID: "+idCliente
              +"\nNumCuentas: "+numCuentas
              +super.toString(); 
              //uso de super para acceder al medodo toString de la clas padre
    }

    //Sobrecarga de metodos, agregarCuenta()
    public void agregarCuenta(Cuenta c){
        cuentasCli.add(c);
        numCuentas++;
        System.out.println("Cuenta agregada");
    }
    
    public void agregarCuenta(Cuenta c1,Cuenta c2){
        cuentasCli.add(c1);
        cuentasCli.add(c2);
        numCuentas+=2;
    }

    public void eliminarCuenta(int i){
        cuentasCli.remove(i);
        System.out.println("La cuenta se ha eliminado");
    }

    public void verCuentas(){
        System.out.println("\n****CUENTAS "+nombre+"****");

        for(Cuenta aux: cuentasCli){
            if(aux instanceof CuentaAhorros){
                System.out.println("\nTipo cuenta: Cuenta de ahorros");
                System.out.println(aux.toString()+"\n");
            }
            else if(aux instanceof CuentaCetes){
                System.out.println("\nTipo cuenta: Cuenta de CETES");
                System.out.println(aux.toString()+"\n");
            }
            else if(aux instanceof CuentaCheques){
                System.out.println("\nTipo cuenta: Cuenta de Cheques");
                System.out.println(aux.toString()+"\n");
            }
            else if(aux instanceof CuentaCredito){
                System.out.println("\nTipo cuenta: Cuenta de Credito");
                System.out.println(aux.toString()+"\n");
            }
            else if(aux instanceof CuentaDebito){
                System.out.println("\nTipo cuenta: Cuenta de debito");
                System.out.println(aux.toString()+"\n");
            }
            
        }
    }

    //Metodo estatico de la clase cliente
    public static int getNumClientes(){
        return numClientes;
    }
 
    public ArrayList<Cuenta> getCuentas(){
        return cuentasCli;
    }


}