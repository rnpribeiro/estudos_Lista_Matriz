package entities;

import java.util.Locale;

public class Funcionario {
    
    private Integer id;
    private String nome;
    private Double salario;
    public Funcionario(Integer id, String nome, Double salario) {
	this.id = id;
	this.nome = nome;
	this.salario = salario;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Double getSalario() {
        return salario;
    }
    
    public void setSalario(Double salario) {
        this.salario = salario;
    }
    
    public void correcaoSalario(double prct) {
        this.salario *= (1 + (prct / 100));  	
    }
    

    @Override
    public String toString() {
	return id + ", " + nome + ", " + String.format(Locale.US, "%.2f", salario);
    }

}
