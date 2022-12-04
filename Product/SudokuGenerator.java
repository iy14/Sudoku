package Product;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;

public class SudokuGenerator {
	
	public static int[][] MakeSudoku(int cellnumber, int[][] SudokuArray ) {
        if (cellnumber > 80) 		// there are 81 cells in the sudoku board (0-80). so if the counter, 'cellnumber' exceeds 80,
           {return SudokuArray;} 	// we have reached the last cell and the array can be returned.
        
        List<Integer> ANs = new ArrayList<Integer>(); //an arraylist of numbers which stores the possible values for each cell.
        
        for (int x = 1; x <10; x++) 	// populating the arraylist with numbers 1 through 9.
        	{
        	ANs.add(x);
        	}
        
        Collections.shuffle(ANs); 	//shuffling the arraylist so that the selected value for each cell is random. 
        							
        int row = cellnumber / 9;	// finding the row and column values from the cellnumber.
        int col = cellnumber % 9;	// this is cited in Criterion C. 

        	while (0<ANs.size()) 	
        	{
            int value = ValidValue(SudokuArray, col, row, ANs); //getting the random value for the current cell using the ValidValue method below.
            if (value == -1)									//if the ValidValue method return -1, 
            { 
            	return null;									//null is returned and no value is stored in this cell.
            }
            else
            {
            SudokuArray[row][col] = value;						// otherwise a valid value is returned and stored in that cell.
            }
            
            int[][] newSudokuArray = MakeSudoku(cellnumber + 1, SudokuArray); 	//the value for the next cell is received by 
            																	//recursively calling the same method with an increase in the cell number.
            																	//this value is stored in a 2D array simply since the method can only return 
            																	//a 2D array type.
            
            if (newSudokuArray != null)	//if the a valid value is found for the next cell,
                {return newSudokuArray;} // that valid is returned and stored in the SudokuArray.
           
            else
            {SudokuArray[row][col] = 0;} //otherwise that cell is set to zero and we keep looking for a valid number (while loop).
            
        	}

        return null; 
    }

	private static int ValidValue(int[][] SudokuArray, int col, int row, List<Integer> ANs) //finds a valid value for the cell and returns it.
	{
		while (ANs.size() > 0) 
		{
            int value = ANs.get(0); //since the arraylist is shuffled in the MakeSudoku method, this index will always hold a random value.
            ANs.remove(0); //this value is removed from the list to indicate it isn't valid for that cell anymore.
            if (CheckRow(SudokuArray, row, value)==true && 		//if this value is valid for that cell in terms of the other numbers already in that row,
            	CheckColumn(SudokuArray, col, value)==true && 	//column, or 3x3 box, the method returns true.
            	CheckBox(SudokuArray, col, row, value)==true)
                {return value;}
        }
		
        return -1;												//otherwise it returns -1.
        
	}

	private static boolean CheckBox(int[][] SudokuArray, int col, int row, int value) 	//checks what numbers already exist in that box 
																						//and if the chosen value is a duplicate the method
																						//returns false. Otherwise it returns true.
	{
			
        int r = (row / 3) * 3 ;
      	int c = (col / 3) * 3 ;

        for (int y = r; y < r + 3; y++) 
        {
            for (int x = c; x < c + 3; x++) 
            {
                if (SudokuArray[y][x] == value)
                    return false;
            }
        }
        return true;
	}

	private static boolean CheckColumn(int[][] SudokuArray, int col, int value) //checks what numbers already exist in that column
																				//and if the chosen value is a duplicate the method
																				//returns false. Otherwise it returns true.
	{
		 for (int row = 0; row < 9; row++) {
	            if (SudokuArray[row][col] == value)
	                return false;
	        }
	        return true;
	}

	private static boolean CheckRow(int[][] SudokuArray, int row, int value) //checks what numbers already exist in that row
																			//and if the chosen value is a duplicate the method
																			//returns false. Otherwise it returns true.
	{
		for (int col = 0; col < 9; col++) {
            if (SudokuArray[row][col] == value)
                return false;
        }
        return true;
	}

}
