package Product;

import java.io.FileNotFoundException;

import java.util.Scanner;
import java.io.File;

public class OpenSavedSudoku {
	
	public static String [][] SavedSudokuArray = new String[9][9];
	
	public static String [][] SavedSudoku()  throws FileNotFoundException 
	{
		
		File SavedSudokuFile = new File ("SavedSudoku.txt");
		Scanner in = new Scanner(SavedSudokuFile);
		
		
			for (int r=0; r<9; r++)
			{
				for(int c=0; c<9; c++)
				{
					
					String value = in.next();
					SavedSudokuArray[r][c]=value;
				}
			
			}
		
		
		in.close();
		
		
		return SavedSudokuArray;
		
	}

}
