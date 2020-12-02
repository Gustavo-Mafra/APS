package application;

import javax.swing.JOptionPane;

public class Programm {

	public static void main(String[] args) {
		boolean populado = false;
		String ent;
		int x; 
		int primos = 0; 
		int somaImpar = 0; 
		int fatMenor = 0;
		int vetor[] = new int[20];

		do {
			ent = JOptionPane.showInputDialog("\n\tMenu\n\t1.Popular\n" + "\t2.Mostrar\n" + "\t3.Inverter\n"
					+ "\t4.Ordenar Crescente\n" + "\t5.Contar Primos\n" + "\t6.Somatório Ímpares\n" + "\t7.Detonar\n"
					+ "\t8.Fatorial do Menor\n" + "\t9.Vazar");
			x = Integer.parseInt(ent);

			switch (x) {
			case 1:
				populado = carregar(vetor);
				break;

			case 2:
				if (populado == true) {
					mostrar(vetor);
				} else {
					System.out.println("Coleção está vazia!");
				}
				break;

			case 3:
				if (populado == true) {
					inverter(vetor);
				} else {
					System.out.println("Coleção está vazia!");
				}
				break;

			case 4:
				if (populado == true) {
					ordenarBolha(vetor);
				} else {
					System.out.println("Coleção está vazia!");
				}
				break;

			case 5:
				if (populado == true) {
					primos = contarPrimos(vetor);
				} else {
					System.out.println("Coleção está vazia!");
				}
				break;

			case 6:
				if (populado == true) {
					somaImpar = somarImpares(vetor);
				} else {
					System.out.println("Coleção está vazia!");
				}
				break;

			case 7:
				if (populado == true) {
					populado = detonar(vetor);
				} else {
					System.out.println("Coleção está vazia!");
				}
				break;

			case 8:
				if (populado == true) {
					fatMenor = menor(vetor);
				} else {
					System.out.println("Coleção está vazia!");
				}
				break;

			}

		} while (x != 9);

	}

	public static boolean carregar(int colecao[]) {
		String ent;
		for (int i = 0; i < colecao.length; i++) {
			ent = JOptionPane.showInputDialog("Insira um número:");
			colecao[i] = Integer.parseInt(ent);
		}
		return true;
	}

	public static void mostrar(int colecao[]) {

		System.out.println("Coleção: ");
		for (int i = 0; i < colecao.length; i++) {
			System.out.print(colecao[i] + " ");
		}
		System.out.println();
	}

	public static boolean inverter(int colecao[]) {
		for (int i = 0; i < colecao.length / 2; i++) {
			int aux = colecao[i];
			colecao[i] = colecao[19 - i];
			colecao[19 - i] = aux;
		}
		return true;
	}

	public static boolean ordenarBolha(int colecao[]) {
		for (int i = 1; i < 20; i++) {
			for (int j = 0; j < i; j++) {
				if (colecao[i] < colecao[j]) {
					int aux = colecao[i];
					colecao[i] = colecao[j];
					colecao[j] = aux;
				}
			}
		}
		return true;
	}

	public static int contarPrimos(int colecao[]) {
		int primos = 0;
		for (int i = 0; i < colecao.length; i++) {
			if (colecao[i] == 2) {
				primos++;
			} else if (colecao[i] != 0 && colecao[i] != 1) {
				for (int cont = colecao[i] - 1; cont > 1; cont--) {
					if (colecao[i] % cont != 0) {
						if (cont == 2) {
							primos++;
						}
					} else {
						cont = 1;
					}
				}
			}
		}
		return primos;
	}

	public static int somarImpares(int colecao[]) {

		int soma = 0;
		for (int i = 0; i < colecao.length; i++) {
			if (colecao[i] % 2 == 1) {
				soma += colecao[i];
			}
		}
		return soma;
	}

	public static boolean detonar(int colecao[]) {
		for (int i = 0; i < colecao.length; i++) {
			colecao[i] = 0;
		}
		return false;
	}

	public static int menor(int colecao[]) {

		int menor = 0;
		for (int i = 0; i < colecao.length; i++) {
			if (i == 0) {
				menor = colecao[i];
			} else if (colecao[i] < menor) {
				menor = colecao[i];
			}
		}
		int fatorial = menor;
		for (int i = menor - 1; i > 1; i--) {
			fatorial *= i;
		}
		return fatorial;
	}
}
