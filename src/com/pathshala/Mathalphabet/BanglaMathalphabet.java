package com.pathshala.Mathalphabet;

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

public class BanglaMathalphabet extends JPanel implements Runnable{
    Thread thread;
	mainWIndowClass mWC;
	public BanglaMathalphabet(mainWIndowClass mWC) {
		this.mWC = mWC;
		{
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}

		}
		
		declaringMethod();
		thread = new Thread(this);
		thread.start();
	}
	
	/*public void setFrameVisible(boolean flag)
	{
		mainFrame.setVisible(flag);
	}*/
	
	protected void paintComponent(Graphics golap) {
		super.paintComponent(golap);

		int Bx=650, By=60, Px=50, Py=350;
		Banglanamota.setSize(Bx, By);
		Banglanamota.setLocation(Px, Py);
		testResult.setLocation(10, 0);
		englishWelcomeMessage.setLocation(200, 20);

		int x = 20;
		int y = 120;
		for (int i = 0; i < 10; i++) {
			banglaButton[i].setSize(200, 90);
			banglaButton[i].setLocation(x, y);
			x += 220;
			if ((i + 1) % 6 == 0 && i > 0) {
				y += 110;
				x = 20;
			}
		}
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
//			if(event.getSource() == backButton)
//			{
//				setFrameVisible(false);
//				mWC.mainWindowFrame.setVisible(true);
//				return;
//			}
			if(event.getSource() == Banglanamota)
			{
				//BanglaMathalphabet.setFramVisible(false);
				//setFrameVisible(false);
				System.out.println("open bangla namota");
				namota.setFrameVisible(true);
				return;
			}
			
			characterNumber = 75;
				for (int i = 0; i <10 ; i++) {
					if (event.getSource() == banglaButton[i]) {
						// command = "Bangla";
						// alphabetDetails.CurrentAlphabet.setText(englih[i].getText());
						characterNumber = i + 1;
						// alphabetDetails.setImage(characterNumber);
					}
				}
				BanglaMathalphabetDetails alphabetDetails = new BanglaMathalphabetDetails(
						characterNumber + 76);
				alphabetDetails.ButtonCategory = "banglaButton";
				alphabetDetails.CurrentAlphabet
						.setText(banglaButton[characterNumber - 1].getText());
				alphabetDetails.CurrentAlphabet.setFont(new Font(
						"Siyam Rupali", Font.BOLD, 90));
				alphabetDetails.detailsOfCharacter.setFont(new Font(
						"Siyam Rupali", Font.BOLD, 30));
				System.out.println("-------" + characterNumber);
				alphabetDetails.alphabetDetailsDialog.setVisible(true);
			
		}
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new BanglaAlphabet();
//	}
	
	public void declaringMethod() {
		
		 Font englishFont1 = new Font("Siyam Rupali", Font.BOLD, 60);
		 Banglanamota =new JButton("বাংলা নামতা");
		 Banglanamota.setFont(englishFont1);
		 Banglanamota.addActionListener(buttonHandler);
		 Banglanamota.setBackground(Color.GREEN);
		 Banglanamota.setForeground(Color.MAGENTA);
		 add(Banglanamota);
		
			englishWelcomeMessage = new JLabel(
					"গণিত  শিক্ষা");
			englishWelcomeMessage.setFont(new Font("Siyam Rupali", Font.BOLD, 50));
			add(englishWelcomeMessage);
		
		Font banglaFont = new Font("Siyam Rupali", Font.BOLD, 90);

		for (int i = 0; i < 10; i++) {
			banglaButton[i] = new JButton("" + i);
			banglaButton[i].setFont(banglaFont);
			banglaButton[i].addActionListener(buttonHandler);
			if(i<=1){
				banglaButton[i].setBackground(Color.green);
				banglaButton[i].setForeground(Color.MAGENTA);
				}
				else if (i<=3)
			{
					banglaButton[i].setBackground(Color.RED);
					banglaButton[i].setForeground(Color.CYAN);
			}
			else if (i<=5)
			{
				banglaButton[i].setBackground(Color.ORANGE);
				banglaButton[i].setForeground(Color.GREEN);
			}
			else if (i<=7)
			{
				banglaButton[i].setBackground(Color.CYAN);
				banglaButton[i].setForeground(Color.ORANGE);
			}
			else if (i<=9)
			{
				banglaButton[i].setBackground(Color.BLUE);
				banglaButton[i].setForeground(Color.RED);
			}
			add(banglaButton[i]);
		}
		setBanglaCharacter();
		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/ing.jpg")));
		add(testResult);

	}
	
	public void setBanglaCharacter() {
		banglaButton[0].setText("১");
		banglaButton[1].setText("২");
		banglaButton[2].setText("৩");
		banglaButton[3].setText("৪");
		banglaButton[4].setText("৫");
		banglaButton[5].setText("৬");
		banglaButton[6].setText("৭");
		banglaButton[7].setText("৮");
		banglaButton[8].setText("৯");
		banglaButton[9].setText("১০");
	}

	JButton Banglanamota;
	JButton banglaButton[] = new JButton[50];
	JLabel englishWelcomeMessage,testResult;
	// AlphabetDetails alphabetDetails = new AlphabetDetails();
	ButtonHandler buttonHandler = new ButtonHandler();
	BanglaNamota namota =new BanglaNamota(this);
	BanglaMathalphabet mainClass;
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
					for (int i = 0; i < 10; i++) {
						banglaButton[i].setForeground(Color.black);
					}					
				}
				else if(flag == 2)
				{
					for (int i = 0; i < 10; i++) {
						banglaButton[i].setForeground(Color.red);
					}
				}
				else if(flag == 3)
				{
					for (int i = 0; i <10; i++) {
						banglaButton[i].setForeground(Color.blue);
					}
				}
				else if(flag == 4)
				{
					for (int i = 0; i < 10; i++) {
						banglaButton[i].setForeground(Color.magenta);
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
