package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.Level;

public class Funcionario {

	private String name;
	private Level level;
	private double salarioBase;

	private Departament departamento;
	private List<Contratos> contratos = new ArrayList<>();

	public Funcionario() {

	}

	public Funcionario(String nome, Level valueOf, double salario, Departament departamento2) {
		this.name = nome;
		this.level = valueOf;
		this.salarioBase = salario;
		this.departamento = departamento2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departament getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departament departamento) {
		this.departamento = departamento;
	}

	public List<Contratos> getContratos() {
		return contratos;
	}

	public void addContracts (Contratos contrato) {
		contratos.add(contrato);
	}
	
	public void removeContracts (Contratos contrato) {
		contratos.remove(contrato);
	}
	
	public double salarioFinal(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for (Contratos c : contratos) {
			cal.setTime(c.getData());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (ano == c_year && mes == c_month) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}
	
}
