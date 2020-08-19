package entities;

import java.util.Date;

public class Contratos {

	private double valorPorHora;
	private Integer horas;
	private Date data;

	public Contratos() {

	}
	
	public Contratos(double valor, int duracao, Date dataContrato) {
		this.valorPorHora = valor;
		this.horas = duracao;
		this.data = dataContrato;
	}

	public double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public Integer getHoras() {
		return horas;
	}

	public void setHoras(Integer horas) {
		this.horas = horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public double valorTotal() {
		return valorPorHora * horas;
	}

}
