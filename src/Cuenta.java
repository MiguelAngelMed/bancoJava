import java.util.ArrayList;

abstract class Cuenta {
    
    private String numCuenta;
    private double saldo;
    //Agregacion de clases 
    private ArrayList<Movimiento> movimientos;
   
    abstract public void retirar(double retiro);
    abstract public void transferir(Cuenta cTransferir,double monto);
    

    //constructor uno
    public Cuenta(){
        numCuenta ="";
        saldo=0.0;
        movimientos = new ArrayList<>();
    }

    //constructor dos 
    public Cuenta(String numCuenta,double saldo){
        this.numCuenta = numCuenta;
        this.saldo = saldo;
        movimientos = new ArrayList<>();
    }

    public double consultarSaldo(){
        return saldo;
    }

    public double getSaldo(){
        return saldo;
    } 

    public void setSaldo(double monto){
        saldo = monto;
    }

    public ArrayList<Movimiento> getMovimientos(){
        return movimientos;
    }
    /*
    public void retirar(double retiro){
        if(retiro<=saldo){
            saldo = saldo-retiro;
            System.out.println("Usted a retirado $"+retiro);
            String descrip = "Retiro de la cuenta, monto: $"+retiro;
            movimientos.add(new Movimiento(descrip, "Retiro"));
        }
    }
    */
    public void depositar(double monto){
        saldo+=monto;
        String descrip = "Deposito a la cuenta, monto: $"+monto;
        movimientos.add(new Movimiento(descrip, "Deposito"));
    }


    public String getNumCuenta(){
        return numCuenta;
    }

    public void verMovimientos(){

        int i=1;
        System.out.println("**Lista de movimiento de la cuenta**");
        for(Movimiento aux: movimientos){
            System.out.println("MOV_"+i);
            i++;
            System.out.println(aux.toString()+"\n");
        }

    }

    public String toString(){
        return "NumCuenta: "+numCuenta
               +"\nSaldo: $"+saldo;
    }

    
}
