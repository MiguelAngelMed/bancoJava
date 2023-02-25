
public class CuentaCredito extends Cuenta{
    private double creditoDisponible;
    private double deuda;
    private double tasaInteres;

    public CuentaCredito(String numCuenta,double saldo,double creditoDisponible){
        super(numCuenta,saldo);
        this.creditoDisponible = creditoDisponible;
        deuda=0;
        tasaInteres=0.15;
    }


    public void pagarConCredito(double monto){
        if(creditoDisponible>=monto){
            deuda += monto+monto*tasaInteres;
            creditoDisponible-=monto;
            System.out.println("\nUsted ha pagado con su credito $"+monto);
            this.getMovimientos().add(new Movimiento("Pago con tarjeta de credito de $"+monto, "pago Credito"));
        }
        else{
            System.out.println("\nSu transaccion fue cancelada, credito insuficiente");
        }
    }

    public void pagarDeuda(double abono){
        deuda-=abono;
        System.out.println("\nUsted ha abonado a su deuda $"+abono);
        this.getMovimientos().add(new Movimiento("Abono tarjeta de credito de $"+abono, "abono Credito"));
    }

    //Redefinicion del metodo retirar dela clase cuenta
    public void retirar(double monto){
        if((this.getSaldo()+creditoDisponible)<=monto){
            System.out.println("Lo sentimos la transaccion fue cancelada.");
            System.out.println("El monto requerido: $"+monto+
            " supera su saldo mas su credito disponible");
        }
        else{
            if(this.getSaldo()>=monto)
               this.setSaldo(this.getSaldo()-monto);
            else 
               creditoDisponible-=monto;        
        }

    }

    public void transferir(Cuenta cTransferir,double monto){
        if(monto<=this.getSaldo()){
            cTransferir.depositar(monto);
            this.setSaldo(this.getSaldo()-monto);
            System.out.println("Transferencia realizada con exito");
            String descrip = "Transferencia a la cuenta "+
                              cTransferir.getNumCuenta()+", Monto: $"+monto;

            this.getMovimientos().add(new Movimiento(descrip, "Transferencia"));
        }
        else{
            System.out.println("Su saldo es insuficiente para realizar la transferencia");
        }

    }
    
    public String toString(){
        return super.toString()
              +"\nCredito disponible: $"+creditoDisponible
              +"\nDeuda actual $"+deuda
              +"\nTasa de interes: "+tasaInteres;
    }


}
