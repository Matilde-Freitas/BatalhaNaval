package trabalho1;

import java.util.Scanner;

public class menu_com_metodos_v2
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		boolean val_menu = true;
		boolean val_N = true;
		boolean val_M = true;
		boolean val_navios = true;
		boolean val_shot = true;

		while (val_menu)
		{

			System.out.println("\nInsira [1] para jogar uma nova partida."
					+ "\nInsira [2] para ver o histórico de partidas." + "\nInsira [3] para sair.");
			int menu = scan.nextInt();
			scan.nextLine();

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
				System.out.println("Defina as dimensões do tabuleiro.");

				int N = check_N(val_N, scan);
				System.out.println();
				int M = check_M(val_M, scan);
				System.out.println();
				int navios = check_navios(val_navios, scan);
				System.out.println();
				int max_shot = check_shot(val_shot, scan);
				System.out.println();

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

	private static int check_N(boolean val_N, Scanner scan)
	{
		int N = 0;

		while (val_N)
		{
			System.out.print("Número de linhas (entre 15 e 30): ");

			if (scan.hasNextInt())
			{
				N = scan.nextInt();

				if (N > 14 && N < 31)
				{
					val_N = false;
				}

				else
				{
					System.out.println("Dimensões fora dos limites");
					System.out.println();
					scan.nextLine();
				}
			}

			else
			{
				System.out.println("Formato inválido");
				System.out.println();
				scan.nextLine();
			}

		}
		return N;
	}

	private static int check_M(boolean val_M, Scanner scan)
	{
		int M = 0;

		while (val_M)
		{
			System.out.print("Número de colunas (entre 15 e 30): ");

			if (scan.hasNextInt())
			{
				M = scan.nextInt();

				if (M > 14 && M < 31)
				{
					val_M = false;
				}

				else
				{
					System.out.println("Dimensões fora dos limites");
					System.out.println();
					scan.nextLine();
				}
			}

			else
			{
				System.out.println("Formato inválido");
				System.out.println();
				scan.nextLine();
			}

		}
		return M;

	}

	private static int check_navios(boolean val_navios, Scanner scan)
	{
		int navios = 0;

		while (val_navios)
		{
			System.out.print("Número de navios a colocar (3 ou mais): ");

			if (scan.hasNextInt())
			{
				navios = scan.nextInt();

				if (navios >= 3)
				{
					val_navios = false;
				}

				else
				{
					System.out.println("Número insuficiente de navios");
					System.out.println();
					scan.nextLine();
				}
			}

			else
			{
				System.out.println("Formato inválido");
				System.out.println();
				scan.nextLine();

			}
		}

		return navios;
	}

	private static int check_shot(boolean val_shot, Scanner scan)
	{
		int max_shot = 0;
		while (val_shot)
		{
			System.out.print("Número máximo de disparos: ");

			if (scan.hasNextInt())
			{
				max_shot = scan.nextInt();
				val_shot = false;
			}

			else
			{
				System.out.println("Formato inválido");
				System.out.println();
				scan.nextLine();
			}
		}
		return max_shot;
	}
}