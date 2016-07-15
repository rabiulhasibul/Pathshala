package com.pathshala.english;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.pathshala.bangla.BanglaAlphabetDetails;


public class EnglishAlphabetDetails extends JPanel implements Runnable
{
	public JDialog alphabetDetailsDialog;
	public String character;
	public JLabel CurrentAlphabet, image, detailsOfCharacter, image1, image2,image3;
	public int characterNumber=1; 
	String details[] = new String[85];
	JButton soun;
	
	public String ButtonCategory = "";
	
	public EnglishAlphabetDetails()
	{
		try
		{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e){}
		
		detailsOfCharacter = new JLabel(details[characterNumber-1]);
		detailsOfCharacter.setFont(new Font("Time New Roman", Font.PLAIN, 30));
		detailsOfCharacter.setText("A for Apple");
		
		CurrentAlphabet = new JLabel("A");
		CurrentAlphabet.setFont(new Font("", Font.BOLD, 50));
		add(CurrentAlphabet);
		
		add(detailsOfCharacter);
		
		setImage(1);
	    
		add(soun);
		alphabetDetailsDialog = new JDialog();
		alphabetDetailsDialog.setTitle("Alphabet Details");
		alphabetDetailsDialog.setSize(500, 500);
		alphabetDetailsDialog.setLocationRelativeTo(null);
		alphabetDetailsDialog.setModal(true);
		alphabetDetailsDialog.add(this);
		alphabetDetailsDialog.setDefaultCloseOperation(alphabetDetailsDialog.DISPOSE_ON_CLOSE);
		
	}
	
	Graphics g;
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		this.g = g;
		
		CurrentAlphabet.setLocation(200, 20);
		image3.setLocation(0, 0);
		image.setLocation(70,120);
		image1.setLocation(70, 120);
		image2.setLocation(70, 120);
		
		//setImageControl();
		detailsOfCharacter.setLocation(120, 360);
		soun.setSize(100, 50);
		soun.setLocation(getWidth()-100, getHeight()-60);
	}
	
	AudioClip click;
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == soun)
			{
				try{
				click.stop();
				 URL urlClick = EnglishAlphabetDetails.class.getResource("/" +characterNumber + ".wav");
				 click = Applet.newAudioClip(urlClick);
				 click.play();
				}catch(Exception e){
					System.out.println("The .wav file not found");
				}
				System.out.println("Command from: " + characterNumber);
			}
		}
		
	}
	
	public EnglishAlphabetDetails(int n) {
		// TODO Auto-generated constructor stub
		this.characterNumber = n;
		details[0] = "A for Apple ";
		details[1] = "B for Book";
		details[2] = "C for Cap ";
		details[3] = "D for Doll ";
		details[4] = "E for Egg ";
		details[5] = "F for Flower";
		details[6] = "G for Gift";
		details[7] = "  H for Hand";
		details[8] = " I for Ink";
		details[9] = "   J for Jug";
		details[10] = " k for Kite ";
		details[11] = "  L for Leg";
		details[12] = "  M for Map";
		details[13]= " N  for Nut ";
		details[14] = " O  for Orange";
		details[15] = "  P for Pumpkin";
		details[16] = "  Q for Quran ";
		details[17] = "  R for Rose";
		details[18] = "  S for Sun";
		details[19] = " T for Tree";
		details[20] = " U for Umbrella";
		details[21] = " V for Violin";
		details[22] = "  W for Watch";
		details[23] = " X for  Xylophone";
		details[24] = " Y for  Yellow ";
		details[25] = " Z for  Zero ";
		int i=5;
		setImage(characterNumber);

	
		
		detailsOfCharacter = new JLabel(details[characterNumber-1]);
		System.out.println(characterNumber);
		//detailsOfCharacter.setFont(new Font("SolaimanLipi", Font.PLAIN, 30));
	   
		detailsOfCharacter.setLocation(100, 100);
		//detailsOfCharacter.setFont(new Font(" ",Font.BOLD,30));
		CurrentAlphabet = new JLabel("A");
		CurrentAlphabet.setFont(new Font("", Font.BOLD, 50));
		add(CurrentAlphabet);
		
		
	    
		add(detailsOfCharacter);
	    
		soun=new JButton("Hear Sound");
		soun.addActionListener(buttonHandler);
		add(soun);
		
		Thread thread = new Thread(this);
		thread.start();
		try{
			if(characterNumber<5){
			image3 = new JLabel( new ImageIcon(getClass().getResource("/bac.jpg")) );
			System.out.println("image added for dialog");
			add(image3);}
			else if(characterNumber<11)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f1.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			else if(characterNumber<17)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f2.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			else if(characterNumber<22)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f3.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			else if(characterNumber<=26)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f5.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			try{
				System.out.println("Sound playing...");
				 URL urlClick = BanglaAlphabetDetails.class.getResource("/" +characterNumber + ".wav");
				 click = Applet.newAudioClip(urlClick);
				 click.play();
				}catch(Exception e){
					System.out.println("The .wav file not found");
				}
			}
			catch(Exception e){System.out.println("Background inmage for character details frmage is not available.");}
		alphabetDetailsDialog = new JDialog();
		alphabetDetailsDialog.setTitle("Alphabet Details");
		alphabetDetailsDialog.setSize(500, 500);
		alphabetDetailsDialog.setLocationRelativeTo(null);
		alphabetDetailsDialog.setModal(true);
		alphabetDetailsDialog.add(this);
		alphabetDetailsDialog.setDefaultCloseOperation(alphabetDetailsDialog.DISPOSE_ON_CLOSE);
	}

	public void setImage(int imno)
	{
		try
		{
			image = new JLabel( new ImageIcon(getClass().getResource("/a" + characterNumber + ".jpg")) );
			System.out.println(imno);
			//setVisible(false);
			add(image);
			
			image1 = new JLabel( new ImageIcon(getClass().getResource("/b" + characterNumber + ".jpg")) );
			image1.setVisible(false);
			add(image1);
			
			image2 = new JLabel( new ImageIcon(getClass().getResource("/c" + characterNumber + ".jpg")) );
			image2.setVisible(false);
			add(image2);
			
			setImageControl(1);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Image not found for character number: " + characterNumber);
		}
	}
	
	public void setImageControl(int imno)
	{
		if(imno == 1) 
		{
			image.setVisible(true);
			image1.setVisible(false);
			image2.setVisible(false);
		}
		else if(imno == 2) 
		{
			image.setVisible(false);
			image1.setVisible(true);
			image2.setVisible(false);
		}
		else 
		{
			image.setVisible(false);
			image1.setVisible(false);
			image2.setVisible(true);
		}
		System.out.println(imno + " is visible now");
		repaint();
	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new AlphabetDetails();
//	}

	ButtonHandler buttonHandler = new ButtonHandler();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int a[] = {1, 39, 4}, i=1;
		while(true)
		{
			setImageControl(i);
			//repaint();
			i++;
			i = i % 4;
			if(i == 0) i++;
			System.out.println("thread running : " + i);
			try{
			Thread.sleep(1000);
			}catch(Exception e){}
		}
	}
}
