package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;

public class Lista {

    public static void main(String[] args) {

//	estudoLista();
//	listaFuncionario();
//	estudoMatriz();
	exercicioFixacaoMatriz();
    }

    public static void estudoLista() {
	List<String> list = new ArrayList<>();
	list.add("Maria");
	list.add("Alex");
	list.add("Bob");
	list.add("Anna");
	list.add(2, "Marco");
	System.out.println(list.size());
	for (String x : list) {
	    System.out.println(x);
	}
	System.out.println("---------------------");
	list.removeIf(x -> x.charAt(0) == 'M');
	for (String x : list) {
	    System.out.println(x);
	}
	System.out.println("---------------------");
	System.out.println("Index of Bob: " + list.indexOf("Bob"));
	System.out.println("Index of Marco: " + list.indexOf("Marco"));
	System.out.println("---------------------");
	List<String> result = list.stream().filter(x -> x.charAt(0) == 'A').collect(Collectors.toList());
	for (String x : result) {
	    System.out.println(x);
	}
	System.out.println("---------------------");
	String name = list.stream().filter(x -> x.charAt(0) == 'J').findFirst().orElse(null);
	System.out.println(name);
    }

    public static void listaFuncionario() {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);

	System.out.print("Quantos funcionários serão registrados? ");
	Integer n = sc.nextInt();
	sc.nextLine();
	Integer inc = 1;

	List<Funcionario> funcionario = new ArrayList<>();

	do {
	    System.out.println();
	    System.out.println("Funcionario #" + inc + ": ");

	    System.out.print("Id: ");
	    Integer id = sc.nextInt();

	    while (hasId(funcionario, id)) {
		System.out.print("Id ja cadastrado. Tente novamente: ");
		id = sc.nextInt();
	    }

	    sc.nextLine();
	    System.out.print("Nome: ");
	    String nome = sc.nextLine();
	    System.out.print("Salario: ");
	    Double salario = sc.nextDouble();
	    funcionario.add(new Funcionario(id, nome, salario));
	    inc++;
	} while (inc <= n);

	updateSalario(funcionario);

	System.out.println("");
	System.out.println("Lista de Funcionarios:");
	for (Funcionario obj : funcionario) {
	    System.out.println(obj);
	}
	sc.close();
    }

    public static boolean hasId(List<Funcionario> funcionario, int id) {
	Funcionario colaborador = funcionario.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	return colaborador != null;
    }

    public static void updateSalario(List<Funcionario> funcionario) {
	Locale.setDefault(Locale.US);
	Scanner sc = new Scanner(System.in);
	System.out.println();
	System.out.print("Digite o Id do funcionario que tera aumento de salario: ");
	int id = sc.nextInt();
	Funcionario colaborador = funcionario.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
	if (colaborador == null) {
	    System.out.println("This id does not exist!");
	} else {
	    System.out.print("Informe o percentual: ");
	    double percentual = sc.nextDouble();
	    colaborador.correcaoSalario(percentual);
	}
	sc.close();
    }

    public static void estudoMatriz() {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();

	int[][] matriz = new int[n][n];
	int linha;
	int coluna;
	for (linha = 0; linha < matriz.length; linha++) {
	    for (coluna = 0; coluna < matriz[linha].length; coluna++) {
		matriz[linha][coluna] = sc.nextInt();
	    }
	}
	System.out.println();
	System.out.println("Diagonal principal: ");
	for (linha = 0; linha < matriz.length; linha++) {
	    System.out.println(matriz[linha][linha] + " ");
	}

	int cont = 0;
	System.out.println();
	for (linha = 0; linha < matriz.length; linha++) {
	    for (coluna = 0; coluna < matriz[linha].length; coluna++) {
		if (matriz[linha][coluna] < 0) {
		    cont++;
		}
	    }
	}
	System.out.print("Numeros Negativos = " + cont);

	sc.close();
    }

    public static void exercicioFixacaoMatriz() {

	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	int n = sc.nextInt();

	int[][] matriz = new int[m][n];

	int linha;
	int coluna;

	for (linha = 0; linha < matriz.length; linha++) {
	    for (coluna = 0; coluna < matriz[linha].length; coluna++) {
		matriz[linha][coluna] = sc.nextInt();
	    }
	}

	int x = sc.nextInt();
	for (linha = 0; linha < matriz.length; linha++) {
	    for (coluna = 0; coluna < matriz[linha].length; coluna++) {
		if (matriz[linha][coluna] == x) {
		    System.out.printf("Posicao %d , %d%n", linha, coluna);
		    if ((coluna - 1) >= 0) {
			System.out.printf("Esquerda %d%n", matriz[linha][coluna-1]);
		    }
		    if ((coluna + 1) < matriz[linha].length) {
			System.out.printf("Direita %d%n", matriz[linha][coluna+1]);
		    }
		    if ((linha - 1) >= 0) {
			System.out.printf("Acima %d%n", matriz[linha-1][coluna]);
		    }
		    if ((linha + 1) < matriz.length) {
			System.out.printf("Abaixo %d%n", matriz[linha+1][coluna]);
		    }
		}
	    }
	}

	sc.close();
    }

}
