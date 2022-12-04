 package Product;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class FinalWindow extends JFrame {
	public FinalWindow() {
		getContentPane().setLayout(null);
		
		JLabel lblWellDone = new JLabel("Well Done!");
		lblWellDone.setBounds(6, 6, 75, 16);
		getContentPane().add(lblWellDone);
		
		JButton btnSolveAnother = new JButton("Solve Another");
		btnSolveAnother.setBounds(77, 1, 117, 29);
		btnSolveAnother.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WelcomeWindow.SavedSudokuWindow.setVisible(false);
				WelcomeWindow.SavedSudokuWindow.dispose();
				WelcomeWindow.SavedOptions.setVisible(false);
				WelcomeWindow.SavedOptions.dispose();
				
				WelcomeWindow.levelswindow.setVisible(false);
				WelcomeWindow.levelswindow.dispose();
				WelcomeWindow.levelswindow.setVisible(false);
				WelcomeWindow.levelswindow.dispose();
				
				LevelsWindow.SudokuWindow.setVisible(false);
				LevelsWindow.SudokuWindow.dispose();
				LevelsWindow.options.setVisible(false);
				LevelsWindow.options.dispose();
			}
		});
		getContentPane().add(btnSolveAnother);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(194, 1, 117, 29);
		getContentPane().add(btnQuit);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
