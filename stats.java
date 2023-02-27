package trabalho1;

public class stats
{

	public static void main(String[] args)
	{
		char[] resultado = new char[100];
		char vitoria = 'V';
		char derrota = 'D';
		char abandono = 'A';
		int numJogo = 5;
		int[] jogadasTotal = new int[100];

		resultado[1] = vitoria;
		resultado[2] = abandono;
		resultado[3] = abandono;
		resultado[4] = derrota;
		resultado[5] = derrota;
		
		jogadasTotal[1] = 5;
		jogadasTotal[2] = 1;
		jogadasTotal[3] = 10;
		jogadasTotal[4] = 23;
		jogadasTotal[5] = 12;

		printStatsTotal(resultado,numJogo, jogadasTotal);
		System.out.println();
		printPerc(resultado, numJogo, jogadasTotal, vitoria, derrota, abandono);
		System.out.println();
		printMed(jogadasTotal, numJogo);

	}

	private static void printMed(int[] jogadasTotal, int numJogo)
	{
		double total = 0;
		double jogadasSoma = 0;
		
		for (int i = 1; i <= numJogo; i++)
		{
			total++;
			jogadasSoma = jogadasSoma + jogadasTotal[i];
			
		}
		
		double jogadasMed = jogadasSoma / total;
		
		System.out.println("Média de jogadas por partida: " + jogadasMed);
		
	}

	private static void printPerc(char[] resultado, int numJogo, int[] jogadasTotal, char vitoria, char derrota, char abandono)
	{
		double vitorias = 0;
		double abandonos = 0;
		double derrotas = 0;
		double total = 0;
		
		for (int i = 1; i <= numJogo; i++)
		{
			total++;
			
			if (resultado[i] == vitoria)
			{
				vitorias++;
			}
			
			else if (resultado[i] == derrota)
			{
				derrotas++;
			}
			
			else
			{
				abandonos++;
			}
		}
		
		System.out.println();
		
		double V_perc = (vitorias / total) * 100;
		double D_perc = (derrotas / total) * 100;
		double A_perc = (abandonos / total) * 100;
		
		System.out.println("Percentagem de vitórias: " + V_perc + "%");
		System.out.println("Percentagem de derrotas: " + D_perc + "%");
		System.out.println("Percentagem de abandonos: " + A_perc + "%");
		
	}

	private static void printStatsTotal(char[] resultado, int numJogo, int[] jogadasTotal)
	{
		System.out.print("Número do jogo:    ");
		for (int i = 1; i <= numJogo; i++)
		{
			System.out.print(i + "   ");
		}

		System.out.println();
		System.out.print("Resultado:         ");

		for (int i = 1; i <= numJogo; i++)
		{
			System.out.print(resultado[i] + "   ");
		}
		
		System.out.println();
		System.out.print("Jogadas:           ");
		
		for (int i = 1; i <= numJogo; i++)
		{
			if (jogadasTotal[i] < 10)
			{
				System.out.print(jogadasTotal[i] + "   ");
			}
			else
			{
				System.out.print(jogadasTotal[i] + "  ");
			}
		}
		
		System.out.println();
		System.out.println("\nLegenda: 'A' - Abandonado , 'V' - Vitória , 'D' - Derrota");
		

	}

}
