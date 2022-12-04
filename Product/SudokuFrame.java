package Product;

import java.awt.Color;

import java.awt.GridLayout;
import java.io.FileNotFoundException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class SudokuFrame extends JFrame {
	public static String SavedSudoku [][] = new String [9][9];
	private static final long serialVersionUID = 0;
    public static JTextField cell[][]= new JTextField[9][9] ; //2d array of type Jtextfields
    private JPanel panel[][]= new JPanel [3][3]; //2d array of type Jpanels
    private JPanel ButtonPanel = new JPanel();
    
    public SudokuFrame(){
    	super ("Your Sudoku");
        setLayout(new GridLayout(3,3,2,2));
        
        for(int i=0; i<3; i++){
            for(int u=0; u<3; u++){
                panel[i][u]=new JPanel(new GridLayout(3,3)); //populates each spot in the 2d panel array with a 3x3 JPanel.
            }													// in total 9 3x3 panels are added.
        }
        
        if (WelcomeWindow.UsingSavedSudoku==true) //if the option to open a saved sudoku is chosen. the cells in the SudokuFrame
        {										  //are populated using the savedSudoku array which is populated with values from
        	try {								  //a text file where the last sudoku was saved using the OpenSavedSudoku function.
        		SavedSudoku = OpenSavedSudoku.SavedSudoku();
        		
        		} catch (FileNotFoundException e) {
			
        			e.printStackTrace();
        		}
        	for(int r=0; r<9; r++) //copies the gamearray into the 2d array of Jtextfields.
    		{
    			for(int c=0; c<9; c++)
    			{
    				cell[r][c]=new JTextField();
    				if (Integer.valueOf(SavedSudoku[r][c]) == 0) 
    				{
    					cell[r][c].setText("");
    					cell[r][c].setEditable( true ); //makes empty Jtextfields editable.
    				}
        	
    				else if (Integer.valueOf(SavedSudoku[r][c])>0)
    				{
    					cell[r][c].setText(SavedSudoku[r][c]); 
    					cell[r][c].setEditable( false );	//makes already solved Jtextfields uneditable.
    					cell[r][c].setBackground(Color.gray); 
    				}
    				
    				else if (Integer.valueOf(SavedSudoku[r][c])<0)
    				{
    					int value = Math.abs(Integer.valueOf(SavedSudoku[r][c]))-10;
    					cell[r][c].setText(String.valueOf(value));
    					cell[r][c].setEditable( true );
    				}
    			}
    		}
        
        }
        
        else
        {
        for(int r=0; r<9; r++) //copies the gamearray into the 2d array of Jtextfields.
        {
            for(int c=0; c<9; c++)
            {
            	cell[r][c]=new JTextField();
            	if (LevelsWindow.gameArray[r][c] == 0) 
            	{
            	cell[r][c].setText("");
            	cell[r][c].setEditable( true ); //makes empty Jtextfields editable.
            	}
            	
            	else
            	{
            	cell[r][c].setText(String.valueOf(LevelsWindow.gameArray[r][c])); //takes the string value of the index as 
            																	  //only strings can be stored in textfields.
            	cell[r][c].setEditable( false );	//makes already solved Jtextfields uneditable.
            	cell[r][c].setBackground(Color.gray); 
            	}
            }
        }
        }


        for(int x=0; x<3; x++) //iterates through the 2d array of type Jpanel.
        {
            for(int y=0; y<3; y++)
            {    
                for(int r=0; r<3; r++ ) //iterates through the internal 3x3 panels in each index of the panel array. 
                {
                    for(int c=0; c<3; c++)
                    {
                        panel[x][y].add(cell[r+x*3][c+y*3]); //adds textfields to each panel. 
                        									 //In total 9 textfields added to each internal panel.
                    }
                }
            add(panel[x][y]); //adds the current panel to the GridLayout.
            }
        }
       
        
    }
}
