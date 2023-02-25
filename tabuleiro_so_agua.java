package trabalho1;


public class tabuleiro_so_agua
{

	public static void main(String[] args)
	{
		int N = 15;
		int M = 30;
		
		char water = '.';
		
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
				System.out.print(water + "  ");
			}
			System.out.println();
		}
	}

}
