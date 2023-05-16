
package fatec.poo.model;

import java.util.ArrayList;

public class Cliente extends Pessoa{
    private double limiteCred;
    private double limiteDisp;
    private ArrayList<Pedido> pedidos; //multiplicidade 1..*

    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteCred = limiteCred;
        limiteDisp = limiteCred;
        this.pedidos = new ArrayList<Pedido>();
    }      

    public double getLimiteCred() {
        return limiteCred;
    }

    public double getLimiteDisp() {
        return limiteDisp;
    }

    public void setLimiteCred(double limiteCred) {
        this.limiteCred = limiteCred;
        limiteDisp = limiteCred;
        
    }
}
