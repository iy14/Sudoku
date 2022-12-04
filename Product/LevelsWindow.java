package Product;

import javax.swing.JFrame;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.Spring;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LevelsWindow extends JFrame {
	public static JFrame SudokuWindow = new JFrame();
	public static JFrame options = new JFrame();
	public static int [][] gameArray = new int [9][9];
	public LevelsWindow() {
		getContentPane().setBackground(Color.BLUE);
		getContentPane().setLayout(null);
		
		JLabel lblPleaseChooseA = new JLabel("Please Choose a Level");
		lblPleaseChooseA.setBounds(55, 5, 340, 38);
		lblPleaseChooseA.setBackground(Color.BLUE);
		lblPleaseChooseA.setFont(new Font("Lucida Grande", Font.PLAIN, 32));
		getContentPane().add(lblPleaseChooseA);
		
		JButton btnNewButton = new JButton("Easy");
		btnNewButton.setBounds(44, 126, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameArray = Product.MakeGameBoard.EasyBoard();
				SudokuWindow= new SudokuFrame();
				SudokuWindow.setBounds(100,100,450,400);
				SudokuWindow.setVisible(true);
				SudokuWindow.setLocationRelativeTo(null);
				
				options= new OptionsFrame();
				options.setBounds(150,150,150,300);
				options.setVisible(true);
				options.setLocation(250, 400);
				

			}
		});
		getContentPane().add(btnNewButton);
		
		
		JButton btnMedium = new JButton("Medium");
		btnMedium.setBounds(173, 126, 117, 29);
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameArray = Product.MakeGameBoard.MediumBoard();
				SudokuWindow= new SudokuFrame();
				SudokuWindow.setBounds(100,100,450,400);
				SudokuWindow.setVisible(true);
				SudokuWindow.setLocationRelativeTo(null);
				
				options = new OptionsFrame();
				options.setBounds(150,150,150,300);
				options.setVisible(true);
				options.setLocation(250, 400);
				
				
				
			}
		});
		getContentPane().add(btnMedium);
		
		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(316, 126, 117, 29);
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameArray = Product.MakeGameBoard.HardBoard();
				SudokuWindow= new SudokuFrame();
				SudokuWindow.setBounds(100,100,450,400);
				SudokuWindow.setVisible(true);
				SudokuWindow.setLocationRelativeTo(null);
				
				options = new OptionsFrame();
				options.setBounds(150,150,150,300);
				options.setVisible(true);
				options.setLocation(250, 400);
				
			}
		});
		getContentPane().add(btnHard);
	}
}
