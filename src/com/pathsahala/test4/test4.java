package com.pathsahala.test4;

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

public class test4 extends JPanel implements Runnable{
  JButton test;
	mainWIndowClass mWC;
	public test4() {
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
           test.setLocation(1200,500);

		englishWelcomeMessage.setLocation(200, 20);
		testResult.setLocation(getWidth()-500, getHeight()-300);

		remainingTimeStatus.setLocation(1200, 620);
		
		int x = 30;
		int y = 90;
		for (int i = 0; i < 52; i++) {
			banglaButton[i].setSize(120, 95);
			banglaButton[i].setLocation(x, y);
			x += 145;
			if ((i + 1) % 9 == 0 && i > 0) {
				y += 100;
				x = 35;
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
					//ranNum = new Random();
					counter += 5;
					if(counter > 26) counter = counter % 26;
					characterTestNumber = counter;
					System.out.println("Test for sound: " +characterTestNumber);
					 URL urlClick = BanglaAlphabetDetails.class.getResource("/test1 (" + characterTestNumber + ").wav");
					 click = Applet.newAudioClip(urlClick);
					 click.play();
					 
					 thread = new Thread(test4.this);
					 thread.start();					 
					}catch(Exception e){
						System.out.println("The .wav file not found");
					}
				return;
			}
			
			if(timeFlag == false) return;
			
			//characterNumber = 27;
			
			
		}
	}

	public void declaringMethod() {
		test = new JButton("Start Test");
		test.addActionListener(buttonHandler);
		//add(test);
		
		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/a" + 2 + ".jpg")));
		testResult.setFont(new Font("Times New Roman", Font.BOLD, 55));
		testResult.setForeground(Color.RED);
		//testResult.setVisible(false);
		
		
		remainingTimeStatus = new JLabel();
		remainingTimeStatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
		add(remainingTimeStatus);
		
		Font englishFont = new Font("Siyam Rupali", Font.BOLD, 90);
		englishWelcomeMessage = new JLabel("English Test");
		englishWelcomeMessage.setFont(new Font("Siyam Rupali", Font.BOLD, 50));
		englishWelcomeMessage.setLocation(500, 100);
		add(englishWelcomeMessage);

		
		Font banglaFont = new Font("Siyam Rupali", Font.BOLD, 70);
		ranNum = new Random();
		
		
		for (int i = 0; i < 52; i++) {
			int asci = 65 + characterNumber;
			counter += 1;
			if(counter > 52) counter = counter %52;
			characterTestNumber = counter;
			
			asci = ranNum.nextInt(122);
			if(asci < 65) asci += 65;
			
			
			if (asci==91){
				asci=asci+6;
			}
			else if (asci==92){
				asci=asci+6;
			}else if (asci==93){
				asci=asci+6;
			}else if (asci==94){
				asci=asci+6;
			}else if (asci==95){
				asci=asci+6;
			}else if (asci==96){
				asci=asci+6;
			}
			System.out.println("random number: " + asci);
			final char c = (char) asci;
			banglaButton[i] = new JButton("" + c);
			banglaButton[i].setFont(englishFont);
			//banglaButton[i] = new JButton("" + i);
		//	banglaButton[i].setFont(banglaFont);
			banglaButton[i].addActionListener(buttonHandler);
			add(banglaButton[i]);
		}
		//setBanglaCharacter();
		add(testResult);
	}
	public void frameDeclaration() {
		mainWindowFrame = new JDialog();
		mainWindowFrame.setTitle("English window");
		mainWindowFrame.setSize(1370, 760);
		mainWindowFrame.add(this);
		mainWindowFrame.setModal(true);
		mainWindowFrame.setLocationRelativeTo(null);
		mainWindowFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		mainWindowFrame.setVisible(true);
	}
	


	JButton banglaButton[] = new JButton[52];
	JLabel englishWelcomeMessage, testResult, remainingTimeStatus;
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

