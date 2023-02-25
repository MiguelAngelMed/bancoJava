public class Persona {
    
    protected String nombre;
    protected int edad;
    protected String tel;
    protected String direccion;
    protected String correo;


    public Persona(String nombre, int edad,String tel,String direccion,String correo){
        this.tel = tel;
        this.edad = edad;
        this.direccion = direccion;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String toString(){
        return "\nNombre: "+nombre
              +"\nEdad: "+edad
              +"\nCorreo: "+correo
              +"\nTelefono: "+tel
              +"\nDireccion: "+direccion;

    }
    

}
