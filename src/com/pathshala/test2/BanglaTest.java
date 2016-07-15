package com.pathshala.test2;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.pathshala.bangla.BanglaAlphabetDetails;
import com.pathshala.englishpoem.EnglishPeomClass;
import com.pathshala.main.mainWIndowClass;

public class BanglaTest extends JPanel implements Runnable{
  JButton test;
	mainWIndowClass mWC;
	public BanglaTest() {
		this.mWC = mWC;
		{
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}
		}
		declaringMethod();
		frameDeclaration();
	}

	protected void paintComponent(Graphics golap) {
		super.paintComponent(golap);
           test.setSize(200,100);
           test.setLocation(350,500);

		englishWelcomeMessage.setLocation(200, 20);
		testResult.setLocation(getWidth()-500, getHeight()-300);
         testResult1.setLocation(10, 0);
		remainingTimeStatus.setLocation(350, 450);
		
		int x = 30;
		int y = 90;
		for (int i = 0; i < 26; i++) {
			banglaButton[i].setSize(115, 90);
			banglaButton[i].setLocation(x, y);
			x += 145;
			if ((i + 1) % 9 == 0 && i > 0) {
				y += 95;
				x = 30;
			}
		}
	}
	
	boolean charecterTest = false;
	int characterTestNumber = 0, counter = 5;
	Thread thread;
	AudioClip click;
	Random ranNum = new Random();
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			
			if(event.getSource() == test)
			{
			
				try{
					ranNum = new Random();
					counter += 5;
					if(counter > 26) counter = counter % 26;
					characterTestNumber = counter;
					System.out.println("Test for sound: " +characterTestNumber);
					 URL urlClick = BanglaAlphabetDetails.class.getResource("/tas (" + characterTestNumber + ").wav");
					 click = Applet.newAudioClip(urlClick);
					 click.play();
					 
					 thread = new Thread(BanglaTest.this);
					 thread.start();					 
					}catch(Exception e){
						System.out.println("The .wav file not found");
					}
				return;
			}
			
			if(timeFlag == false) return;
			
			characterNumber = 27;
				for (int i = 0; i < 26; i++) {
					if (event.getSource() == banglaButton[i]) {
						characterNumber = i + 1;
						if((characterNumber == characterTestNumber))
						{
							
							testResult.setIcon(new ImageIcon(getClass().getResource("/tick2.png")));
							testResult.setForeground(Color.GREEN);
							testResult.setVisible(true);
							timeFlag = false;
						}
						else 
						{
							
							testResult.setIcon(new ImageIcon(getClass().getResource("/wrong1.png")));
							testResult.setForeground(Color.RED);
							testResult.setVisible(true);
							timeFlag = false;
						}
						System.out.println("Clicked: " + (i+1));
					}
				}
			
		}
	}

	public void declaringMethod() {
		test = new JButton("Start Test");
		test.addActionListener(buttonHandler);
		add(test);
		
		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/a" + 2 + ".jpg")));
		testResult.setFont(new Font("Times New Roman", Font.BOLD, 55));
		testResult.setForeground(Color.RED);
		//testResult.setVisible(false);
		add(testResult);
		
		remainingTimeStatus = new JLabel();
		remainingTimeStatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(remainingTimeStatus);
		
		Font englishFont = new Font("Siyam Rupali", Font.BOLD, 90);
		englishWelcomeMessage = new JLabel("বাংলা টেস্ট");
		englishWelcomeMessage.setFont(new Font("Siyam Rupali", Font.BOLD, 50));
		englishWelcomeMessage.setLocation(1000, 100);
		add(englishWelcomeMessage);

		
		Font banglaFont = new Font("Siyam Rupali", Font.BOLD, 70);

		for (int i = 0; i < 26; i++) {
			banglaButton[i] = new JButton("" + i);
			banglaButton[i].setFont(banglaFont);
			banglaButton[i].addActionListener(buttonHandler);
			add(banglaButton[i]);
		}

		testResult1 = new JLabel();
		testResult1.setIcon(new ImageIcon(getClass().getResource("/frame1.jpg")));
		add(testResult1);
		setBanglaCharacter();
	}
	public void frameDeclaration() {
		mainWindowFrame = new JDialog();
		mainWindowFrame.setTitle("বাংলা টেস্ট");
		mainWindowFrame.setSize(1370, 760);
		mainWindowFrame.add(this);
		mainWindowFrame.setModal(true);
		mainWindowFrame.setLocationRelativeTo(null);
		mainWindowFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		mainWindowFrame.setVisible(true);
	}
	
	public void setBanglaCharacter() {
		banglaButton[0].setText("উ");
		banglaButton[1].setText("গ");
		banglaButton[2].setText("ঠ");
		banglaButton[3].setText("প");
		banglaButton[4].setText("ষ");
		banglaButton[5].setText("ঈ");
		banglaButton[6].setText("খ");
		banglaButton[7].setText("ট");
		banglaButton[8].setText("ন");
		banglaButton[9].setText("ঁ");
		banglaButton[10].setText("ই");
		banglaButton[11].setText("ক");
		banglaButton[12].setText("ঞ");
		banglaButton[13].setText("ধ");
		banglaButton[14].setText("ল");
		banglaButton[15].setText("আ");
		banglaButton[16].setText("ঔ");
		banglaButton[17].setText("ঃ");
		banglaButton[18].setText("দ");
		banglaButton[19].setText("র");
		banglaButton[20].setText("ঊ");
		banglaButton[21].setText("ঋ");
		banglaButton[22].setText("ঙ");
		banglaButton[23].setText("ঢ");
		banglaButton[24].setText("ব");
		banglaButton[25].setText("হ");

		

	}

	JButton banglaButton[] = new JButton[50];
	JLabel englishWelcomeMessage, testResult,testResult1, remainingTimeStatus;
	ButtonHandler buttonHandler = new ButtonHandler();
	public int characterNumber = 1;

	public JDialog mainWindowFrame;
	

	Boolean timeFlag = true;
	
	@Override
	public void run() {
		timeFlag = true;
		for(int i=5; i>0; i--)
		{
			try{
				//timeFlag = true;
				remainingTimeStatus.setForeground(Color.GREEN);
				remainingTimeStatus.setText("Time remaining..." + i);
				Thread.sleep(1000);
			}catch(Exception e){}
		}
		remainingTimeStatus.setText("Time is up");
		remainingTimeStatus.setForeground(Color.RED);
		timeFlag = false;
	}
}
