package Product;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeWindow extends JFrame {
	public static JFrame levelswindow = new JFrame();
	public static JFrame SavedSudokuWindow = new JFrame();
	public static JFrame SavedOptions = new JFrame();
	public static boolean UsingSavedSudoku =false;
	//private JPanel contentPane;
	public WelcomeWindow() {
		
		
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Your Sudoku Game");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 23));
		lblNewLabel.setBounds(38, 6, 381, 56);
		getContentPane().add(lblNewLabel);
		
		JButton btnPlay = new JButton("Play!");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				levelswindow= new LevelsWindow();
				levelswindow.setBounds(100,100,450,300);
				levelswindow.setVisible(true);
				levelswindow.setLocationRelativeTo(null);
				
			}
		});
		
		btnPlay.setBounds(231, 74, 117, 29);
		getContentPane().add(btnPlay);
		

		JButton btnOpenSavedSudoku = new JButton("Open Saved Sudoku");
		btnOpenSavedSudoku.setBounds(81, 74, 143, 56);
		btnOpenSavedSudoku.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsingSavedSudoku =true;
				
				SavedSudokuWindow= new SudokuFrame();
				SavedSudokuWindow.setBounds(100,100,450,400);
				SavedSudokuWindow.setVisible(true);
				SavedSudokuWindow.setLocationRelativeTo(null);
				
				SavedOptions= new OptionsFrame();
				SavedOptions.setBounds(150,150,150,300);
				SavedOptions.setVisible(true);
				SavedOptions.setLocation(250, 400);
			}
		});
		getContentPane().add(btnOpenSavedSudoku);
	
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(231, 101, 117, 29);
		getContentPane().add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	public static void main(String [] args){
		WelcomeWindow frame = new WelcomeWindow();
		frame.setBounds(100,100,450,300);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
}

