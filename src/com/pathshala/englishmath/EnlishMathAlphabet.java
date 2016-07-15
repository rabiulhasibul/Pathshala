package com.pathshala.englishmath;

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

import com.pathshala.englishpoem.EnglishPeomClass;
import com.pathshala.main.mainWIndowClass;

public class EnlishMathAlphabet extends JPanel implements Runnable{
	
     Thread thread;
	mainWIndowClass mWC;
	public EnlishMathAlphabet(mainWIndowClass mWC) {
		this.mWC = mWC;
		{
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}

			declaringMethod();
			thread =new Thread(this);
			thread.start();
		}
	}
	
	public void declaringMethod() {
		
		Font englishFont = new Font("Times New Roman", Font.BOLD, 90);
		englishWelcomeMessage = new JLabel(
				"Welcome to English Alphabet learning!");
		englishWelcomeMessage.setFont(new Font("Segoe Print", Font.BOLD, 50));
		add(englishWelcomeMessage);

		for (int i = 0; i < 10; i++) {
			mathButton[i] = new JButton((i+1) + "");
			System.out.println("current characater: " + i);
			mathButton[i].setFont(new Font("Times New Roman", Font.BOLD, 85));
			mathButton[i].addActionListener(buttonHandler);
			if(i<=2){
				mathButton[i].setBackground(Color.green);
				mathButton[i].setForeground(Color.MAGENTA);
				}
				else if (i<=4)
			{
					mathButton[i].setBackground(Color.RED);
					mathButton[i].setForeground(Color.CYAN);
			}
			else if (i<=6)
			{
				mathButton[i].setBackground(Color.ORANGE);
				mathButton[i].setForeground(Color.GREEN);
			}
			else if (i<=8)
			{
				mathButton[i].setBackground(Color.CYAN);
				mathButton[i].setForeground(Color.ORANGE);
			}
			else if (i<=10)
			{
				mathButton[i].setBackground(Color.BLUE);
				mathButton[i].setForeground(Color.RED);
			}
			add(mathButton[i]);
		}

		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/intial.jpg")));
		add(testResult);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			String command = "null";
			for (int i = 0; i < 10; i++) {
				if(event.getSource() == mathButton[i])
				{
					command = "Math";
					characterNumber = 1 + i;
					break;
				}
			}
			
				int x = Integer.parseInt(mathButton[characterNumber-1].getText());
				
				EnglishMathAlphabetDetails alphabetDetails = new EnglishMathAlphabetDetails(
						x + 86);
				alphabetDetails.ButtonCategory = "mathButton";
				alphabetDetails.CurrentAlphabet.setFont(new Font(
						"Times New Roman", Font.BOLD, 90));
				alphabetDetails.detailsOfCharacter.setFont(new Font(
						"Times New Roman", Font.BOLD, 30));
				alphabetDetails.CurrentAlphabet
						.setText(mathButton[characterNumber - 1].getText());
				System.out.println("-------" + characterNumber);
				alphabetDetails.alphabetDetailsDialog.setVisible(true);
		}
	}


	int x = 100, y = 140;

	protected void paintComponent(Graphics golap) {
		super.paintComponent(golap);

		englishWelcomeMessage.setLocation(200, 20);
		testResult.setLocation(10, 0);
		int x = 20;
		int y = 120;
		for (int i = 0; i < 10; i++) {
			mathButton[i].setSize(200, 90);
			mathButton[i].setLocation(x, y);
			x += 220;
			if ((i + 1) % 6 == 0 && i > 0) {
				y += 110;
				x = 20;
			}
		}

	}

	JButton mathButton[] = new JButton[10];
	JLabel englishWelcomeMessage,testResult;
	ButtonHandler buttonHandler = new ButtonHandler();
	public int characterNumber = 1;public void run() {
		// TODO Auto-generated method stub
		int flag = 1;
		while(true)
		{
			try {
				System.out.println("Change color...");
				if(flag == 1)
				{
					for (int i = 0; i < 10; i++) {
						mathButton[i].setForeground(Color.black);
					}					
				}
				else if(flag == 2)
				{
					for (int i = 0; i < 10; i++) {
						mathButton[i].setForeground(Color.red);
					}
				}
				else if(flag == 3)
				{
					for (int i = 0; i <10; i++) {
						mathButton[i].setForeground(Color.blue);
					}
				}
				else if(flag == 4)
				{
					for (int i = 0; i < 10; i++) {
						mathButton[i].setForeground(Color.magenta);
					}
				}
				flag++;
				flag = flag % 5;
				
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}