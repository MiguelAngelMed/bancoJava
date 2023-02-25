public class CuentaDebito extends Cuenta {
    //0.03%
    //variable estatica para el rendimiento de la cuenta 
    //debe ser el mismo para cualquier cuenta de debito
    private static double rendimiento=0.0003;

    public CuentaDebito(String numCuenta,double saldo){
        super(numCuenta,saldo);
    }

    public void cobrarRendimiento(){
        this.setSaldo(this.getSaldo() + this.getSaldo()*rendimiento);
    }

    public void retirar(double retiro){
        if(retiro <= this.getSaldo()){
            this.setSaldo(this.getSaldo()-retiro);
            System.out.println("Usted a retirado $"+retiro);
            String descrip = "Retiro de la cuenta, monto: $"+retiro;
            this.getMovimientos().add(new Movimiento(descrip, "Retiro"));
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
                +"\nRendimiento: "+(rendimiento*100)+"%";
    }

}
