package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contratos;
import entities.Departament;
import entities.Funcionario;
import entities.enums.Level;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Entre com os dados do funcionario: ");
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("Level: ");
		String level = sc.nextLine();
		System.out.print("Salario Base: ");
		double salario = sc.nextDouble();
		
		Funcionario func = new Funcionario(nome, Level.valueOf(level), salario, new Departament(nomeDepartamento));
		
		System.out.print("Quantos contratos esse funcionario tem ?");
		int n = sc.nextInt();
		
		for (int i=1; i<=n; i++) {
			System.out.println("Insira o contrarto #" + i + " : ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valor = sc.nextDouble();
			System.out.print("Duração (Horas): ");
			int duracao = sc.nextInt();
			
			Contratos contrato = new Contratos(valor, duracao, dataContrato);
			func.addContracts(contrato);
		}
		
		System.out.println();
		System.out.print("Entre com o mes e o ano para calcular o salario (MM/yyyy): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Nome: " + func.getName());
		System.out.println("Departamento: " + func.getDepartamento().getName());
		System.out.println("Salario de " + monthAndYear + ": " + String.format("%.2f", func.salarioFinal(year, month)));
		
		
		sc.close();
	}

}
