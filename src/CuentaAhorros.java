public class CuentaAhorros extends Cuenta {
    private double tasaInteres;
    
    public CuentaAhorros(String numCuenta,double saldo,double tasaInteres){
        //uso de super para invocar al contructor de la clase cuenta
        super(numCuenta,saldo); 
        this.tasaInteres = tasaInteres;
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

    

    public void cobrarIntereses(){
        double saldo = this.getSaldo();
        this.setSaldo(saldo+(saldo*tasaInteres));
    }
 
    //Sobrecarga de metodos
    public void cobrarIntereses(int numMeses){
        for(int i=0; i<numMeses;i++){
            double saldo = this.getSaldo();
            this.setSaldo(saldo+(saldo*tasaInteres));
        }
        
    }

    //Redefinicion de metodos
    public String toString(){
        return super.toString()
                +"\nTasa de interes: "+tasaInteres;
    }

    
}
