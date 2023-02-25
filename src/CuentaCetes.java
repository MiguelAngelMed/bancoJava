public class CuentaCetes extends Cuenta {
    private int plazoDias;

    public CuentaCetes(String numCuenta,double saldo,int plazoDias){
        super(numCuenta,saldo);
        this.plazoDias = plazoDias;
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
    
    

    public void depositar(double monto){
        this.setSaldo(this.getSaldo()+monto);
        
        String descrip = "Deposito a la cuenta, monto: $"+monto;
        this.getMovimientos().add(new Movimiento(descrip, "Deposito"));
    }

    public void cobrarRendimiento(){
        double tasa=0.0;
        if(plazoDias==28)
            tasa = 5.14;            
        else if(plazoDias==91)
            tasa = 5.52;
        else if(plazoDias==175)
            tasa = 6.00;
        else if(plazoDias==343)
            tasa = 6.54;

        double interesBruto = (this.getSaldo()*(tasa/100)*plazoDias)/360;
        double isr = ((0.97/100)*this.getSaldo()*plazoDias)/365;

        this.setSaldo(this.getSaldo() + interesBruto-isr);
        
    }

    public String toString(){
        return super.toString()
               +"\nPlazo a "+plazoDias+" dias";
    }
}
