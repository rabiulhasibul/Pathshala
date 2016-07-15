package com.pathshala.bangla;

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

public class BanglaAlphabet extends JPanel implements Runnable{

	mainWIndowClass mWC;
	Thread thread;
	public BanglaAlphabet(mainWIndowClass mWC) {
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

	protected void paintComponent(Graphics golap) {
		super.paintComponent(golap);


		englishWelcomeMessage.setLocation(200, 20);

		int x = 30;
		int y = 90;
		for (int i = 0; i < 50; i++) {
			banglaButton[i].setSize(115, 90);
			banglaButton[i].setLocation(x, y);
			x += 145;
			if ((i + 1) % 9 == 0 && i > 0) {
				y += 95;
				x = 30;
			}
		}
		testResult.setLocation(10, 0);
		banglaPoem.setSize(220, 90);
		banglaPoem.setLocation(x, y);
	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == banglaPoem)
			{
				new BanglapoemClass();
				return;
			}
			
			characterNumber = 27;
				for (int i = 0; i < 50; i++) {
					if (event.getSource() == banglaButton[i]) {
						characterNumber = i + 1;
					}
				}
				BanglaAlphabetDetails alphabetDetails = new BanglaAlphabetDetails(
						characterNumber + 26);
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

	public void declaringMethod() {
		
		Font englishFont = new Font("Siyam Rupali", Font.BOLD, 90);
		englishWelcomeMessage = new JLabel(
				"বাংলা  বর্ণমালা  শিক্ষা");
		englishWelcomeMessage.setFont(new Font("Siyam Rupali", Font.BOLD, 50));
		add(englishWelcomeMessage);
	
		
		Font banglaFont = new Font("Siyam Rupali", Font.BOLD, 70);

		banglaPoem = new JButton("বাংলা কবিতা");
		banglaPoem.setFont(new Font("Siyam Rupali", Font.BOLD, 20));
		banglaPoem.addActionListener(buttonHandler);
		add(banglaPoem);
		
		for (int i = 0; i < 50; i++) {
			banglaButton[i] = new JButton("" + i);
			banglaButton[i].setFont(banglaFont);
				if(i<=10){
				banglaButton[i].setBackground(Color.green);
				banglaButton[i].setForeground(Color.MAGENTA);
				}
				else if (i<=20)
			{
					banglaButton[i].setBackground(Color.RED);
					banglaButton[i].setForeground(Color.CYAN);
			}
			else if (i<=30)
			{
				banglaButton[i].setBackground(Color.ORANGE);
				banglaButton[i].setForeground(Color.GREEN);
			}
			else if (i<=40)
			{
				banglaButton[i].setBackground(Color.CYAN);
				banglaButton[i].setForeground(Color.ORANGE);
			}
			else if (i<=49)
			{
				banglaButton[i].setBackground(Color.BLUE);
				banglaButton[i].setForeground(Color.RED);
			}
			banglaButton[i].addActionListener(buttonHandler);
			add(banglaButton[i]);
		}
		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/intial.jpg")));
		add(testResult);
		setBanglaCharacter();

	}
	
	public void setBanglaCharacter() {
		banglaButton[0].setText("অ");
		banglaButton[1].setText("আ");
		banglaButton[2].setText("ই");
		banglaButton[3].setText("ঈ");
		banglaButton[4].setText("উ");
		banglaButton[5].setText("ঊ");
		banglaButton[6].setText("ঋ");
		banglaButton[7].setText("এ");
		banglaButton[8].setText("ঐ");
		banglaButton[9].setText("ও");
		banglaButton[10].setText("ঔ");
		banglaButton[11].setText("ক");
		banglaButton[12].setText("খ");
		banglaButton[13].setText("গ");
		banglaButton[14].setText("ঘ");
		banglaButton[15].setText("ঙ");
		banglaButton[16].setText("চ");
		banglaButton[17].setText("ছ");
		banglaButton[18].setText("জ");
		banglaButton[19].setText("ঝ");
		banglaButton[20].setText("ঞ");
		banglaButton[21].setText("ট");
		banglaButton[22].setText("ঠ");
		banglaButton[23].setText("ড");
		banglaButton[24].setText("ঢ");
		banglaButton[25].setText("ণ");
		banglaButton[26].setText("ত");
		banglaButton[27].setText("থ");
		banglaButton[28].setText("দ");
		banglaButton[29].setText("ধ");
		banglaButton[30].setText("ন");
		banglaButton[31].setText("প");
		banglaButton[32].setText("ফ");
		banglaButton[33].setText("ব");
		banglaButton[34].setText("ভ");
		banglaButton[35].setText("ম");
		banglaButton[36].setText("য");
		banglaButton[37].setText("র");
		banglaButton[38].setText("ল");
		banglaButton[39].setText("শ");
		banglaButton[40].setText("ষ");
		banglaButton[41].setText("স");
		banglaButton[42].setText("হ");
		banglaButton[43].setText("ড়");
		banglaButton[44].setText("ঢ়");
		banglaButton[45].setText("য়");
		banglaButton[46].setText("ৎ");
		banglaButton[46].setText("ং");
     	banglaButton[48].setText(":");
		banglaButton[49].setText("ঁ");

	}

	JButton banglaButton[] = new JButton[50], banglaPoem;
	JLabel englishWelcomeMessage,testResult,testResult1;
	ButtonHandler buttonHandler = new ButtonHandler();
	public int characterNumber = 1;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		int flag = 1;
		while(true)
		{
			try {
				System.out.println("Change color...");
				if(flag == 1)
				{
					for (int i = 0; i < 50; i++) {
						banglaButton[i].setForeground(Color.black);
					}					
				}
				else if(flag == 2)
				{
					for (int i = 0; i < 50; i++) {
						banglaButton[i].setForeground(Color.red);
					}
				}
				else if(flag == 3)
				{
					for (int i = 0; i < 50; i++) {
						banglaButton[i].setForeground(Color.blue);
					}
				}
				else if(flag == 4)
				{
					for (int i = 0; i < 50; i++) {
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
