
package fatec.poo.model;

import java.util.ArrayList;

public class Vendedor extends Pessoa{
    private double salarioBase;
    private double taxaComissao;
    private ArrayList<Vendedor> vendedores;

    public Vendedor(String cpf, String nome, double salarioBase) {
        super(cpf, nome);
        this.salarioBase = salarioBase;
        vendedores = new ArrayList<Vendedor>();
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = (taxaComissao/100);
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }
    
}
