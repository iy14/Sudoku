package Product;

import java.awt.Color;

import javax.swing.JFrame;

public class Check {
	//public static boolean finished = false;
	
	public static boolean checker()
	{
		int correct = 0;
		for(int r=0; r<9; r++)
        {
            for(int c=0; c<9; c++)
            {
            	String number = SudokuFrame.cell[r][c].getText();
            if (number.length()==0)
            {
            	SudokuFrame.cell[r][c].setBackground(Color.white);
            	correct = -1;
            }
            
            else 
            {
            	if (SudokuFrame.cell[r][c].isEditable()==false)
            	{SudokuFrame.cell[r][c].setBackground(Color.gray);}
            	else
                {
                	int value = Integer.parseInt(SudokuFrame.cell[r][c].getText()); //converts values back from strings to integers to be checked against the fullsudoku.
                	if (value == MakeGameBoard.fullSudoku[r][c])
                	{	
                		SudokuFrame.cell[r][c].setBackground(Color.green);
                	}
                	else
                	{
                		SudokuFrame.cell[r][c].setBackground(Color.red);
                		correct = -1;
                	}
                }
            }
            
            
            }
        }
		
		if (correct==0)
		{
			//finished = true;
			return true;
		
		}
		
		else
		return false;
		
	}
	

}
