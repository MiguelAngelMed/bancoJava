import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

//Clase para registrar los movimientos que realizan las cuentas de
//los clientes
public class Movimiento {
    
    private LocalDateTime fecha;
    private String descripcion;
    private String tipoDeMovimiento;
    private String fechita;
    private String hora; 

    public Movimiento(String descripcion, String tipo){
        this.descripcion = descripcion;
        tipoDeMovimiento = tipo;
        fecha = LocalDateTime.now(); 
        fechita = fecha.format(DateTimeFormatter.ISO_LOCAL_DATE);
        hora = fecha.format(DateTimeFormatter.ISO_LOCAL_TIME);
    }

    public String toString(){
        return "Fecha: "+fechita+" "+hora
              +"\nDescripcion: "+descripcion
              +"\nTipoDeMovimiento: "+tipoDeMovimiento;
    }
}
