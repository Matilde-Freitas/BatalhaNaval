package trabalho1;

import java.util.Scanner;

public class menu_com_metodos_v2
{
	// PROBLEMA: Corre bem até ao num de colunas. Código igual ao num de linhas mas lê corretamente
	
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

			System.out.println("Insira [1] para jogar uma nova partida."
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
				System.out.print("\nGAME START");
				System.out.print("\nDefina as dimensões do tabuleiro.");
				System.out.print("\nNúmero de linhas (entre 15 e 30): ");

				int N = check_N(val_N);

				System.out.print("\nNúmero de colunas (entre 15 e 30): ");

				int M = check_M(val_M);

				System.out.print("\nNúmero de navios a colocar: ");

				int navios = check_navios(val_navios);

				System.out.print("\nNúmero máximo de disparos: ");

				int max_shot = check_shot(val_shot);

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

	private static int check_N(boolean val_N)
	{
		Scanner scan = new Scanner(System.in);
		int N = 0;

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
					System.out.print("\nDimensões fora dos limites");
					System.out.print("\nNúmero de linhas (entre 15 e 30): ");
				}
			}

			else
			{
				//scan.nextLine();
				System.out.print("\nFormato inválido");
				//scan.nextLine();
				System.out.print("\nNúmero de linhas (entre 15 e 30): ");
			}

		}
		scan.close();
		return N;
	}

	private static int check_M(boolean val_M)
	{
		Scanner scan = new Scanner(System.in);
		int M = 0;

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
					System.out.print("\nDimensões fora dos limites");
					System.out.print("\nNúmero de colunas (entre 15 e 30): ");
				}
			}

			else
			{
				//scan.nextLine();
				System.out.print("\nFormato inválido");
				//scan.nextLine();
				System.out.print("\nNúmero de colunas (entre 15 e 30): ");
			}

		}

		scan.close();
		return M;

	}

	private static int check_navios(boolean val_navios)
	{
		Scanner scan = new Scanner(System.in);
		int navios = 0;

		while (val_navios)
		{

			if (scan.hasNextInt())
			{
				navios = scan.nextInt();
				val_navios = false;
			}

			else
			{
				System.out.print("\nFormato inválido");
				//scan.nextLine();
				System.out.print("\nNúmero de navios a colocar: ");
			}
		}

		scan.close();
		return navios;
	}

	private static int check_shot(boolean val_shot)
	{
		Scanner scan = new Scanner(System.in);
		int max_shot = 0;
		while (val_shot)
		{

			if (scan.hasNextInt())
			{
				max_shot = scan.nextInt();
				val_shot = false;
			}

			else
			{
				//scan.nextLine();
				System.out.print("\nFormato inválido");
				//scan.nextLine();
				System.out.print("\nNúmero máximo de disparos: ");
			}
		}
		scan.close();
		return max_shot;
	}
}