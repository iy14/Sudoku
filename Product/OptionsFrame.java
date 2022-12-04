package Product;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


import javax.swing.JButton;
import javax.swing.JLabel;

public class OptionsFrame extends JFrame {
	public static String timeelapsed;
	public OptionsFrame() {
		super ("Options");
		getContentPane().setLayout(null);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(17, 46, 117, 29);
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Check.checker();
				if (Check.checker()==true)
				{
					JFrame z= new FinalWindow();
					z.setBounds(100,100,300,50);
					z.setVisible(true);
					z.setLocationRelativeTo(null);
				}
			}
		});
		getContentPane().add(btnCheck);
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.setBounds(17, 99, 117, 29);
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		getContentPane().add(btnQuit);
		
		JButton btnSaveForLater = new JButton("Save for Later");
		btnSaveForLater.setBounds(17, 18, 117, 29);
		btnSaveForLater.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						SaveForLater.Save();
					} catch (FileNotFoundException e1) {
						
						e1.printStackTrace();
					}
				
			}
		});
		getContentPane().add(btnSaveForLater);
		
		JButton btnNewButton = new JButton("New Game");
		btnNewButton.setBounds(17, 73, 117, 29);
		btnNewButton.addActionListener(new ActionListener() {
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
				
				
				
				JFrame NewLevelsWindow = new LevelsWindow();
				NewLevelsWindow.setBounds(100,100,450,300);
				NewLevelsWindow.setVisible(true);
				NewLevelsWindow.setLocationRelativeTo(null);
				
			}
		});
		getContentPane().add(btnNewButton);
		
		/*JLabel lblTimer = new JLabel("Timer:");
		lblTimer.setBounds(17, 31, 61, 16);
		getContentPane().add(lblTimer);
		
		while (Check.checker()=false)
		{timeelapsed=Stopwatch.Time();
		JLabel lblTime = new JLabel(timeelapsed);
		lblTime.setBounds(62, 31, 87, 16);
		getContentPane().add(lblTime);}*/
		
	
		
	
	}
}
