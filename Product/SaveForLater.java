package Product;
import java.io.FileNotFoundException;


import java.io.PrintWriter;

public class SaveForLater {
	
	public static void Save() throws FileNotFoundException
	{
		
			
			PrintWriter Printout = new PrintWriter("SavedSudoku.txt");
			for (int r = 0; r<9; r++)
			{
				for (int c=0; c<9; c++)
				{
					String value = SudokuFrame.cell[r][c].getText();
					if (value.length()==0)
					{
						Printout.print("0 ");
					}
					else
					{
						if (SudokuFrame.cell[r][c].isEditable()==false)
						{Printout.print(value+" ");}
						else
						{
						Printout.print("-1"+value+" ");
						}
					}
				}
			}

			Printout.close();
	}

}
