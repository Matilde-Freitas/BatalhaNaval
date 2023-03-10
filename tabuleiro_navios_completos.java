package trabalho1;

import java.util.Arrays;
import java.util.Random;

public class tabuleiro_navios_completos
{

	public static void main(String[] args)
	{
		int N = 15;
		int M = 30;
		char water = '.';
		char ship = 'S';
		int navios = 10;
		int navios_colocados = 0;

		char[][] tabuleiro = criarTabuleiro(N, M, water, navios_colocados, navios, ship);

		printTabuleiro(tabuleiro, water, ship, N, M);

	}

	private static void printTabuleiro(char[][] tabuleiro, char water, char ship, int N, int M)
	{
		System.out.print("    ");

		for (int i = 0; i < M; i++)
		{

			if (i < 9)
			{
				System.out.print(i + 1 + "  ");
			}
			else
			{
				System.out.print(i + 1 + " ");
			}
		}
		
		System.out.println();

		for (int row = 0; row < N; row++)
		{
			if (row < 9)
			{
				System.out.print(row + 1 + "   ");
			}

			else
			{
				System.out.print(row + 1 + "  ");
			}

			for (int col = 0; col < M; col++)
			{
				char posicao = tabuleiro[row][col];
				// if (posicao == ship)
				// {
				// System.out.print(water + " ");
				// }
				// else
				// {
				System.out.print(posicao + "  ");
				// }
			}
			
			System.out.println();
		}
	}

	private static char[][] criarTabuleiro(int N, int M, char water, int navios_colocados, int navios, char ship)
	{
		char[][] tabuleiro = new char[N][M];

		for (char[] row : tabuleiro)
		{
			Arrays.fill(row, water);
		}

		while (navios_colocados < navios)
		{
			int tipo_navio = new Random().nextInt(5);
			int[] local;
			// 1) S 2) SS (horl) 3) SS (ver) 4) SSSS (hor) 5) SSSS (ver)
			
			local = gerarCoordenadas(tipo_navio, N, M);

			if (tipo_navio == 1)
			{
				char possivel_local = tabuleiro[local[0]][local[1]];

				if (possivel_local == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 2)
			{
				char possivel_local1 = tabuleiro[local[0]][local[1]];
				char possivel_local2 = tabuleiro[local[0]][(local[1] + 1)];

				if (possivel_local1 == water && possivel_local2 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[local[0]][(local[1] + 1)] = ship;
				}
			}
			
			else if (tipo_navio == 3)
			{
				char possivel_local1 = tabuleiro[local[0]][local[1]];
				char possivel_local2 = tabuleiro[(local[0] + 1)][local[1]];

				if (possivel_local1 == water && possivel_local2 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[(local[0] + 1)][local[1]] = ship;
				}
			}
			
			else if (tipo_navio == 4)
			{
				char possivel_local1 = tabuleiro[local[0]][local[1]];
				char possivel_local2 = tabuleiro[local[0]][(local[1] + 1)];
				char possivel_local3 = tabuleiro[local[0]][(local[1] + 2)];
				char possivel_local4 = tabuleiro[local[0]][(local[1] + 3)];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water && possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[local[0]][(local[1] + 1)] = ship;
					tabuleiro[local[0]][(local[1] + 2)] = ship;
					tabuleiro[local[0]][(local[1] + 3)] = ship;
				}
			}
			
			else if (tipo_navio == 5)
			{
				char possivel_local1 = tabuleiro[local[0]][local[1]];
				char possivel_local2 = tabuleiro[(local[0] + 1)][local[1]];
				char possivel_local3 = tabuleiro[(local[0] + 2)][local[1]];
				char possivel_local4 = tabuleiro[(local[0] + 3)][local[1]];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water && possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[(local[0] + 1)][local[1]] = ship;
					tabuleiro[(local[0] + 2)][local[1]] = ship;
					tabuleiro[(local[0] + 3)][local[1]] = ship;
				}
			}

		}

		return tabuleiro;
	}

	private static int[] gerarCoordenadas(int tipo_navio, int N, int M)
	{
		// 1) S 2) SS (horl) 3) SS (ver) 4) SSSS (hor) 5) SSSS (ver)

		int[] coordenadas_navio = new int[2];
		int c1 = 0;
		int c2 = 0;

		if (tipo_navio == 1)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M);

		}

		else if (tipo_navio == 2)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M - 1);

			if (c2 < 0)
			{
				c2 = 0;
			}

		}

		else if (tipo_navio == 3)
		{
			c1 = new Random().nextInt(N - 1);
			c2 = new Random().nextInt(M);

			if (c1 < 0)
			{
				c1 = 0;
			}

		}

		else if (tipo_navio == 4)
		{
			c1 = new Random().nextInt(N);
			c2 = new Random().nextInt(M - 3);

			if (c2 < 0)
			{
				c2 = 0;
			}

		}

		else if (tipo_navio == 5)
		{
			c1 = new Random().nextInt(N - 3);
			c2 = new Random().nextInt(M);

			if (c1 < 0)
			{
				c1 = 0;
			}
		}

		coordenadas_navio[0] = c1;
		coordenadas_navio[1] = c2;

		return coordenadas_navio;
	}
}
