import java.util.ArrayList;

public class Banco {
    //Encapsulamiento
    private String nombreBan;
    private ArrayList<Cliente> listaClientes;

    public Banco(String nombre){
        nombreBan = nombre;
        listaClientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente e){
        listaClientes.add(e);
        System.out.println("El cliente se ha registrado en el sistema");
    }

    public void consultarNumClientes(){
        //Uso de un metodo estatico de la clase cliente
        System.out.println("El banco tiene "+Cliente.getNumClientes()+" listaClientes");
    }

    public String generarReporteClientes(){
        String lClientes="";       
        for(Cliente aux: listaClientes){
            lClientes = lClientes+aux.toString()+"\n"; 
        }
        
        return "\nBanco "+nombreBan+
               "\n***CLIENTES BANCO***"
               +lClientes;
        
    }

    public ArrayList<Cliente> getCliente(){
        return listaClientes;
    }
    public String getNombre(){
         return nombreBan;
    }
}
