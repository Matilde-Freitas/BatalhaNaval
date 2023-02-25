package trabalho1;

import java.util.Scanner;

public class menu_sem_metodos
{

	public static void main(String[] args)
	{
		boolean val_menu = true;
		Scanner scan = new Scanner(System.in);
		int N;
		int M;
		int navios;
		int shot;
		boolean val_N = true;
		boolean val_M = true;
		boolean val_navios = true;
		boolean val_shot = true;

		while (val_menu)
		{

			System.out.println("\nInsira [1] para jogar uma nova partida."
					+ "\nInsira [2] para ver o histórico de partidas." + "\nInsira [3] para sair.");
			int menu = scan.nextInt();

			if (menu == 3)
			{
				System.out.println("GAME OVER");
				val_menu = false;
			}

			else if (menu == 2)
			{
				System.out.println("Stats:");
				val_menu = true;
			}

			else if (menu == 1)
			{
				System.out.println("GAME START");
				System.out.println("\nDefina as dimensões do tabuleiro.");
				System.out.print("\nNúmero de linhas (entre 15 e 30): ");

				while (val_N)
				{
					if (scan.hasNextInt())
					{
						N = scan.nextInt();
						scan.nextLine();

						if (N > 14 && N < 31)
						{
							val_N = false;
						}

						else
						{
							System.out.println("Dimensões fora dos limites");
							System.out.print("\nNúmero de linhas (entre 15 e 30): ");
						}
					}

					else
					{
						scan.nextLine();
						System.out.println("Formato inválido");
						scan.nextLine();
						System.out.print("\nNúmero de linhas (entre 15 e 30): ");
					}

				}

				System.out.print("\nNúmero de colunas (entre 15 e 30): ");

				while (val_M)
				{
					if (scan.hasNextInt())
					{
						M = scan.nextInt();
						scan.nextLine();

						if (M > 14 && M < 31)
						{
							val_M = false;
						}

						else
						{
							System.out.println("Dimensões fora dos limites");
							System.out.print("\nNúmero de colunas (entre 15 e 30): ");
						}
					}

					else
					{
						scan.nextLine();
						System.out.println("Formato inválido");
						scan.nextLine();
						System.out.print("\nNúmero de colunas (entre 15 e 30): ");
					}

				}

				System.out.print("\nNúmero de navios a colocar: ");

				while (val_navios)
				{

					if (scan.hasNextInt())
					{
						navios = scan.nextInt();
						val_navios = false;
					}

					else
					{
						System.out.println("Formato inválido");
						scan.nextLine();
						System.out.print("\nNúmero de navios a colocar: ");
					}
				}

				System.out.print("\nNúmero máximo de disparos: ");

				while (val_shot)
				{

					if (scan.hasNextInt())
					{
						shot = scan.nextInt();
						val_shot = false;
					}

					else
					{
						scan.nextLine();
						System.out.println("Formato inválido");
						scan.nextLine();
						System.out.print("\nNúmero máximo de disparos: ");
					}
				}

				val_menu = true;
			}

			else
			{
				System.out.println("Erro: Não insiriu um número correto");
				val_menu = true;
			}

		}

		scan.close();

	}

}
