package com.pathshala.english;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.prefs.BackingStoreException;

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

public class EnlishAlphabet extends JPanel implements Runnable{
	

	mainWIndowClass mWC;
	public EnlishAlphabet(mainWIndowClass mainWIndow) {
		Thread thread;
		mWC = mainWIndow;
		{
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}
			declaringMethod();
			
		}
		thread = new Thread(this);
		thread.start();
	}
	
	public void declaringMethod() {
		
		Font englishFont = new Font("Times New Roman", Font.BOLD, 90);
		englishWelcomeMessage = new JLabel(
				"Welcome to English Alphabet learning!");
		englishWelcomeMessage.setFont(new Font("Segoe Print", Font.BOLD, 50));
		add(englishWelcomeMessage);

		for (int i = 0; i < 26; i++) {
			int asci = 65 + i;
			final char c = (char) asci;
			englih[i] = new JButton("" + c);
			englih[i].setFont(englishFont);
			englih[i].addActionListener(buttonHandler);
			if(i<=5){
				englih[i].setBackground(Color.green);
				englih[i].setForeground(Color.MAGENTA);
				}
				else if (i<=10)
			{
					englih[i].setBackground(Color.RED);
					englih[i].setForeground(Color.CYAN);
			}
			else if (i<=15)
			{
				englih[i].setBackground(Color.ORANGE);
				englih[i].setForeground(Color.GREEN);
			}
			else if (i<=20)
			{
				englih[i].setBackground(Color.CYAN);
				englih[i].setForeground(Color.ORANGE);
			}
			else if (i<=26)
			{
				englih[i].setBackground(Color.BLUE);
				englih[i].setForeground(Color.RED);
			}
			add(englih[i]);
		}

		englishpoem = new JButton("English poem");
		englishpoem.setFont(new Font("Siyam Rupali", Font.BOLD, 20));
		englishpoem.addActionListener(buttonHandler);
		add(englishpoem);
		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/intial.jpg")));
		add(testResult);

	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == englishpoem)
			{
				new EnglishPeomClass();
				return;
			}
			String command = "null";
			for (int i = 0; i < 26; i++) {
				if (event.getSource() == englih[i]) {
					command = "English";
					characterNumber = 1 + i;
					break;
				}
			}
				EnglishAlphabetDetails alphabetDetails = new EnglishAlphabetDetails(
						characterNumber);
				alphabetDetails.ButtonCategory = "englishButton";
				alphabetDetails.CurrentAlphabet.setFont(new Font(
						"Times New Roman", Font.BOLD, 90));
				alphabetDetails.detailsOfCharacter.setFont(new Font(
						"Times New Roman", Font.BOLD, 30));
				alphabetDetails.CurrentAlphabet
						.setText(englih[characterNumber - 1].getText());
				System.out.println("-------" + characterNumber);
				alphabetDetails.alphabetDetailsDialog.setVisible(true);
		}
	}

	int x = 100, y = 140;

	protected void paintComponent(Graphics golap) {
		super.paintComponent(golap);
        testResult.setLocation(10, 0);
		englishWelcomeMessage.setLocation(200, 20);
		
		int x = 20;
		y = 120;
		for (int i = 0; i < 26; i++) {
			englih[i].setSize(200, 90);
			englih[i].setLocation(x, y);
			x += 220;
			if ((i + 1) % 6 == 0 && i > 0) {
				y += 110;
				x = 20;
			}
		}
		englishpoem.setLocation(x, y);
	}

	JButton englih[] = new JButton[26],englishpoem;
	JLabel englishWelcomeMessage,testResult;
	ButtonHandler buttonHandler = new ButtonHandler();
	public int characterNumber = 1;
	public void run() {
		// TODO Auto-generated method stub
		int flag = 1;
		while(true)
		{
			try {
				System.out.println("Change color...");
				if(flag == 1)
				{
					for (int i = 0; i < 26; i++) {
						englih[i].setForeground(Color.black);
					}					
				}
				else if(flag == 2)
				{
					for (int i = 0; i < 26; i++) {
						englih[i].setForeground(Color.red);
					}
				}
				else if(flag == 3)
				{
					for (int i = 0; i < 26; i++) {
						englih[i].setForeground(Color.blue);
					}
				}
				else if(flag == 4)
				{
					for (int i = 0; i < 26; i++) {
						englih[i].setForeground(Color.magenta);
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