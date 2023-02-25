package trabalho1;

import java.util.Arrays;
import java.util.Random;

public class tabuleiro_navios_simples
{

	public static void main(String[] args)
	{
		int N = 15;
		int M = 30;
		char water = '.';
		char ship = 'S';
		int navios = 4;
		int navios_colocados = 0;
		
		char[][] tabuleiro = criarTabuleiro(N,M,water,navios_colocados,navios,ship);
		
		printTabuleiro(tabuleiro,water,ship,N,M);
		
	}		
	

	private static void printTabuleiro(char[][] tabuleiro, char water, char ship, int N, int M)
	{
		System.out.print("    ");
		
		for (int i = 0; i < M; i++)
		{
			
			if (i<9)
			{
				System.out.print(i + 1 + "  ");
			}
			else
			{
				System.out.print(i +1 + " ");
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
//				if (posicao == ship)
//				{
//					System.out.print(water + " ");
//				}
//				else
//				{
					System.out.print(posicao + "  ");
//				}
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
		
			int[] local = gerarCoordenadas1(N,M);
			char possivel_local = tabuleiro[local[0]][local[1]];
			
			if (possivel_local == water)
			{
				tabuleiro[local[0]][local[1]] = ship;
				navios_colocados++;
			}

		}
		
		return tabuleiro;
	}

	private static int[] gerarCoordenadas1(int N, int M)
	{
		int[] coordenadas_navio = new int[2];

		coordenadas_navio[0] = new Random().nextInt(N);
		coordenadas_navio[1] = new Random().nextInt(M);
		
		return coordenadas_navio;
	}
}
