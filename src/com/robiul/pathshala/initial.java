package com.robiul.pathshala;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.pathshala.banglapoem.BanglapoemClass;
import com.pathshala.englishpoem.EnglishPeomClass;
import com.pathshala.main.mainWIndowClass;

public class initial extends JPanel {

	mainWIndowClass mWC;
	public initial(mainWIndowClass mWC) {
		this.mWC = mWC;
		{
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}
		}
		
		declaringMethod();
	}

	protected void paintComponent(Graphics golap) {
		super.paintComponent(golap);


		englishWelcomeMessage.setLocation(200, 20);

	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
		
			
		}
	}

	public void declaringMethod() {
		
		Font englishFont = new Font("Siyam Rupali", Font.BOLD, 90);
		englishWelcomeMessage = new JLabel(
				"  বর্ণমালা  শিক্ষা");
		englishWelcomeMessage.setFont(new Font("Siyam Rupali", Font.BOLD, 50));
		add(englishWelcomeMessage);

		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/initaia.jpg")));
		testResult.setFont(new Font("Times New Roman", Font.BOLD, 55));
		testResult.setForeground(Color.RED);
		//testResult.setVisible(false);
		add(testResult);
		Font banglaFont = new Font("Siyam Rupali", Font.BOLD, 70);

	

		int x = '1';
		System.out.println("This is bangla alphabet declaring method" + x);

	}
	
	public void setBanglaCharacter() {
		
	}

	JButton banglaButton[] = new JButton[50], banglaPoem;
	JLabel englishWelcomeMessage,testResult;
	ButtonHandler buttonHandler = new ButtonHandler();
	public int characterNumber = 1;
}
