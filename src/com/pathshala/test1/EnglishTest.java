package com.pathshala.test1;

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
import javax.swing.colorchooser.ColorChooserComponentFactory;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.omg.CORBA.Principal;

import com.pathshala.bangla.BanglaAlphabetDetails;
import com.pathshala.englishpoem.EnglishPeomClass;
import com.pathshala.main.mainWIndowClass;

public class EnglishTest extends JPanel implements Runnable{
  JButton test;
	mainWIndowClass mWC;
	Thread thread1;
	public EnglishTest() {
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
		englishWelcomeMessage.setFocusTraversalKeysEnabled(true);
		englishWelcomeMessage.setForeground(Color.GREEN);
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
				System.out.println("Test starting...");
				try{
					ranNum = new Random();
					counter += 5;
					if(counter > 26) counter = counter % 26;
					characterTestNumber = counter;
					System.out.println("Test for sound: " +characterTestNumber);
					 URL urlClick = BanglaAlphabetDetails.class.getResource("/test1 (" + characterTestNumber + ").wav");
					 click = Applet.newAudioClip(urlClick);
					 click.play();
					 
					 thread = new Thread(EnglishTest.this);
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
		englishWelcomeMessage = new JLabel("English Test");
		englishWelcomeMessage.setFont(new Font("Siyam Rupali", Font.BOLD, 50));
		englishWelcomeMessage.setLocation(500, 100);
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
		mainWindowFrame.setTitle("English Test");
		mainWindowFrame.setSize(1370, 760);
		mainWindowFrame.add(this);
		mainWindowFrame.setModal(true);
		mainWindowFrame.setLocationRelativeTo(null);
		mainWindowFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		mainWindowFrame.setVisible(true);
	}
	
	public void setBanglaCharacter() {
		banglaButton[0].setText("D");
		banglaButton[1].setText("C");
		banglaButton[2].setText("B");
		banglaButton[3].setText("A");
		banglaButton[4].setText("H");
		banglaButton[5].setText("G");
		banglaButton[6].setText("F");
		banglaButton[7].setText("E");
		banglaButton[8].setText("L");
		banglaButton[9].setText("K");
		banglaButton[10].setText("J");
		banglaButton[11].setText("I");
		banglaButton[12].setText("P");
		banglaButton[13].setText("O");
		banglaButton[14].setText("N");
		banglaButton[15].setText("M");
		banglaButton[16].setText("Z");
		banglaButton[17].setText("Y");
		banglaButton[18].setText("W");
		banglaButton[19].setText("X");
		banglaButton[20].setText("U");
		banglaButton[21].setText("Q");
		banglaButton[22].setText("R");
		banglaButton[23].setText("S");
		banglaButton[24].setText("T");
		banglaButton[25].setText("V");
		

	}

	JButton banglaButton[] = new JButton[50];
	JLabel englishWelcomeMessage, testResult,testResult1, remainingTimeStatus;
	ButtonHandler buttonHandler = new ButtonHandler();
	public int characterNumber = 1;

	public JDialog mainWindowFrame;
	public static void main(String[] args) {
		new EnglishTest();
	}

	Boolean timeFlag = true;
	
	@Override
	public void run() {
		timeFlag = true;
		int flag = 1;
		
	
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

