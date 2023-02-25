public class CuentaCheques extends Cuenta{

    private double montoSobreGiro;

    public CuentaCheques(String numCuenta,double saldo,double sobreGiro){
        super(numCuenta,saldo);
        montoSobreGiro = sobreGiro;
    }

    public double consultarSobregiro(){
        return montoSobreGiro;
    }

    public void retirar(double monto){
        if(monto>(montoSobreGiro+this.getSaldo())){
            System.out.println("Lo sentimos la transaccion fue cancelada.");
            System.out.println("El monto requerido: $"+monto+
            " supera su saldo mas su sobregiro establecido");
        }
        else{
            if(this.getSaldo()>=monto)
               this.setSaldo(this.getSaldo()-monto);
            else{
               montoSobreGiro-=monto;
               System.out.println("\nHa emitido un cheque con saldo de su sobregiro");
               this.getMovimientos().add(new Movimiento("emitir cheque con sobregiro", "retiro"));
            }
        }
            
    }
   

    public void transferir(Cuenta cTransferir,double monto){
        if(monto>(montoSobreGiro+this.getSaldo())){
            System.out.println("Lo sentimos la transaccion fue cancelada.");
            System.out.println("El monto requerido: $"+monto+
            " supera su saldo mas su sobregiro establecido");
        }
        else if(monto<=this.getSaldo()){
            cTransferir.depositar(monto);
            this.setSaldo(this.getSaldo()-monto);
            System.out.println("Transferencia realizada con exito");
            String descrip = "Transferencia a la cuenta "+
                              cTransferir.getNumCuenta()+", Monto: $"+monto;

            this.getMovimientos().add(new Movimiento(descrip, "Transferencia"));
        }
        else if(monto<=montoSobreGiro){
            cTransferir.depositar(monto);
            montoSobreGiro -= monto;
            System.out.println("Transferencia realizada con exito");
            String descrip = "Transferencia a la cuenta "+
                              cTransferir.getNumCuenta()+", Monto: $"+monto;

            this.getMovimientos().add(new Movimiento(descrip, "Transferencia"));

        }
        else{
            System.out.println("Su saldo es insuficiente para realizar la transferencia");
        }

    }


    public String toString() {
        return super.toString()
               +"\nMonto sobregiro: $"+montoSobreGiro;
    }
}
