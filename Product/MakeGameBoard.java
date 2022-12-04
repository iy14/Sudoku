package Product;

import java.util.ArrayList;

import java.util.Random;

public class MakeGameBoard {
	
	private static int [][] gameArray = new int[9][9];
	public static int [][] fullSudoku = new int [9][9];
	
	public static int [][] EasyBoard() //generates a relatively easy board. Desired number of cells left unsolved is approx 20.
	{
		int array[][]  = new int[9][9];
		fullSudoku = SudokuGenerator.MakeSudoku(0, array); //fully solved sudoku board is generated
		
		Random generator = new Random();
		
		for (int r=0; r<9; r++)
		{
			for (int c=0; c<9; c++)
			{
				int number = generator.nextInt(4); //generates a random number from 0-4
				if (number==1) //the probability of that number equaling 1 is 0.25
				{
					gameArray[r][c]=0; //if this is the case, this index in the gamearray is changed to 0, which will later make it 'unsolved'
				}
				else
				{
					gameArray[r][c]=fullSudoku[r][c]; //otherwise this index in the game array is given the value of the fullsudoku array, meaning it will be solved. 
				}
			}
		}
		return gameArray; //should generate a board with approx 20 unsolved cells since 20/81 approx equals 0.25.
		
	}
	
	public static int [][] MediumBoard() //generates a relatively intermediate board. Desired number of cells left unsolved is approx 27.
	{
		int array[][]  = new int[9][9];
		fullSudoku = SudokuGenerator.MakeSudoku(0, array); //fully solved sudoku board is generated
		
		Random generator = new Random();
		
		for (int r=0; r<9; r++)
		{
			for (int c=0; c<9; c++)
			{
				int number = generator.nextInt(3);
				if (number==1) //the probability of that number equaling 1 is 0.33
				{
					gameArray[r][c]=0;
				}
				else
				{
					gameArray[r][c]=fullSudoku[r][c];
				}
			}
		}
		return gameArray; //should generate a board with approx 27 unsolved cells since 27/81 = 0.33.
		
	}
	
	public static int [][] HardBoard() //generates a relatively hard board. Desired number of cells left unsolved is approx 40.
	{
		int array[][]  = new int[9][9];
		fullSudoku = SudokuGenerator.MakeSudoku(0, array); //fully solved sudoku board is generated
		
		Random generator = new Random();
		
		for (int r=0; r<9; r++)
		{
			for (int c=0; c<9; c++)
			{
				int number = generator.nextInt(2);
				if (number==1) //the probability of that number equaling 1 is 0.5
				{
					gameArray[r][c]=0;
				}
				else
				{
					gameArray[r][c]=fullSudoku[r][c];
				}
			}
		}
		return gameArray; //should generate a board with approx 40 unsolved cells since 40/81 approx equals 0.5.
		
	}

}
