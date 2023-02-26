package trabalho1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class tabuleiro_com_interacao
{
	// 	PROBLEMAS: 
	//	-CONTAGEM DE NAVIOS AFUNDADOS;
	//	-CRIAÇÃO DE NAVIOS NÃO É SEQUENCIAL, É COMPLETAMENTE ALEATÓRIA (NÃO APARECEM GARANTIDAMENTE UM DE CADA TIPO)
	//	
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int N = 15;
		int M = 30;
		char water = '.';
		char ship = 'S';
		char hit = 'X';
		char miss = 'o';
		int navios = 1;
		int navios_colocados = 0;
		int max_shot = 10;
		boolean val_jogo = true;
		int vitorias = 0;
		int derrotas = 0;
		int jogadas = 0;

		while (val_jogo)
		{
			char[][] tabuleiro = criarTabuleiro(N, M, water, navios_colocados, navios, ship);
		
			printTabuleiro(tabuleiro, water, ship, N, M);
		
			for (int i = 0; i < max_shot; i++)
			{
				int[] coordenadasJogador = inserirCoordenadas(N, M, scan);
				jogadas++;
				char resultadoShot = avaliarShot(coordenadasJogador, tabuleiro, ship, water, hit, miss);
		
				int numS = contarS(tabuleiro, ship, N, M);
		
				tabuleiro = atualizarTabuleiro(tabuleiro, coordenadasJogador, resultadoShot);
				printTabuleiro(tabuleiro, water, ship, N, M);
		
				if (resultadoShot == hit)	// Conta também tiros em navios já afundados
				{
					numS--;
		
					if (numS == 0)
					{
						System.out.println("Ganhou o jogo!");
						vitorias++;
		
						val_jogo = iniciarNovoJogo(val_jogo, scan);
						i = max_shot;
		
					}
				}
		
				else if (jogadas == max_shot - 1)
				{
					System.out.println("Perdeu o jogo");
					derrotas++;
		
					val_jogo = iniciarNovoJogo(val_jogo, scan);
					i = max_shot;
		
				}
			}
		}
		
		System.out.print("Menu Principal");

	}

	private static boolean iniciarNovoJogo(boolean val_jogo, Scanner scan)
	{
		boolean val_escolha = true;
		int i = 0;

		while (val_escolha)
		{
			System.out.println("Insira [1] para jogar novamente e [2] para voltar ao menu principal.");
			i = scan.nextInt();

			if (i == 1)
			{
				val_escolha = false;
				val_jogo = true;
			}

			else if (i == 2)
			{
				val_escolha = false;
				val_jogo = false;
			}
			
			else
			{
				System.out.println("Valor inválido");
				val_escolha = true;
			}
		}
		return val_jogo;
	}

	private static int contarS(char[][] tabuleiro, char ship, int N, int M)
	{
		int numS = 0;

		for (int row = 0; row < N; row++)
		{
			for (int col = 0; col < M; col++)
			{
				if (tabuleiro[row][col] == ship)
				{
					numS++;
				}
			}
		}

		return numS;
	}

	private static char[][] atualizarTabuleiro(char[][] tabuleiro, int[] coordenadasJogador, char resultadoShot)
	{
		int row = coordenadasJogador[0];
		int col = coordenadasJogador[1];
		tabuleiro[row][col] = resultadoShot;
		return tabuleiro;
	}

	private static char avaliarShot(int[] coordenadasJogador, char[][] tabuleiro, char ship, char water, char hit,
			char miss)
	{
		int row = coordenadasJogador[0];
		int col = coordenadasJogador[1];
		char alvo = tabuleiro[row][col];

		String message;

		if (alvo == ship)
		{
			message = "Acertou!";
			alvo = hit;
		}

		else if (alvo == water)
		{
			message = "Água!";
			alvo = miss;
		}

		else
		{
			message = "Já atingido";
		}

		System.out.println(message);
		System.out.println();
		return alvo;

	}

	private static int[] inserirCoordenadas(int N, int M, Scanner scan)
	{
		int row = 0;
		int col = 0;
		boolean val_linha = true;
		boolean val_col = true;

		while (val_linha)
		{
			System.out.print("Linha: ");

			if (scan.hasNextInt())
			{
				row = scan.nextInt();

				if (row <= N && row >= 1)
				{
					val_linha = false;
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

		System.out.println();

		while (val_col)
		{
			System.out.print("Coluna: ");

			if (scan.hasNextInt())
			{
				col = scan.nextInt();

				if (col <= M && col >= 1)
				{
					val_col = false;
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

		return new int[] { row - 1, col - 1 };

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
					navios_colocados++;
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
					navios_colocados++;
				}
			}

			else if (tipo_navio == 4)
			{
				char possivel_local1 = tabuleiro[local[0]][local[1]];
				char possivel_local2 = tabuleiro[local[0]][(local[1] + 1)];
				char possivel_local3 = tabuleiro[local[0]][(local[1] + 2)];
				char possivel_local4 = tabuleiro[local[0]][(local[1] + 3)];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
						&& possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[local[0]][(local[1] + 1)] = ship;
					tabuleiro[local[0]][(local[1] + 2)] = ship;
					tabuleiro[local[0]][(local[1] + 3)] = ship;
					navios_colocados++;
				}
			}

			else if (tipo_navio == 5)
			{
				char possivel_local1 = tabuleiro[local[0]][local[1]];
				char possivel_local2 = tabuleiro[(local[0] + 1)][local[1]];
				char possivel_local3 = tabuleiro[(local[0] + 2)][local[1]];
				char possivel_local4 = tabuleiro[(local[0] + 3)][local[1]];

				if (possivel_local1 == water && possivel_local2 == water && possivel_local3 == water
						&& possivel_local4 == water)
				{
					tabuleiro[local[0]][local[1]] = ship;
					tabuleiro[(local[0] + 1)][local[1]] = ship;
					tabuleiro[(local[0] + 2)][local[1]] = ship;
					tabuleiro[(local[0] + 3)][local[1]] = ship;
					navios_colocados++;
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
