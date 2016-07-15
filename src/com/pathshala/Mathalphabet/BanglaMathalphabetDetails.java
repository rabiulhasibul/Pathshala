package com.pathshala.Mathalphabet;
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


public class BanglaMathalphabetDetails extends JPanel implements Runnable
{
	public JDialog alphabetDetailsDialog;
	public String character;
	public JLabel CurrentAlphabet, image, detailsOfCharacter, image1, image2,image3;
	public int characterNumber=1; 
	String details[] = new String[86];
	JButton soun;
	
	public String ButtonCategory = "";
	
	public BanglaMathalphabetDetails()
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
		
		alphabetDetailsDialog.setVisible(true);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);	
		image3.setLocation(0, 0);
		image.setLocation(70,120);
		image1.setLocation(70, 120);
		image2.setLocation(70, 120);
		CurrentAlphabet.setLocation(200, 20);
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
				 URL urlClick = BanglaMathalphabetDetails.class.getResource("/" +characterNumber + ".wav");
				 click = Applet.newAudioClip(urlClick);
				 click.play();
				}catch(Exception e){
					System.out.println("The .wav file not found");
				}
				System.out.println("Command from: " + characterNumber);
			}
		}
		
	}
	
	public BanglaMathalphabetDetails(int n) {
		// TODO Auto-generated constructor stub
		this.characterNumber = n;
		details[76] = "এক ";
		details[77] = "দুই";
		details[78] = "তিন ";
		details[79] = "চার ";
		details[80] = "পাঁচ ";
		details[81] = "ছয়";details[82] = "সাত";
		details[83] = " আট";details[84] = "নয়";details[85] = " দশ";
	
		
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
			if(characterNumber<80){
			image3 = new JLabel( new ImageIcon(getClass().getResource("/bac.jpg")) );
			System.out.println("image added for dialog");
			add(image3);}
			else if(characterNumber<=86)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f1.jpg")) );
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
		alphabetDetailsDialog.setVisible(false);
	}
	
	public void setImage(int imno)
	{
		try
		{
			image = new JLabel( new ImageIcon(getClass().getResource("/a" + characterNumber + ".jpg")) );
			System.out.println(imno);
			add(image);

			image1 = new JLabel( new ImageIcon(getClass().getResource("/b" + characterNumber + ".jpg")) );
			image1.setVisible(false);
			add(image1);
			
			image2 = new JLabel( new ImageIcon(getClass().getResource("/c" + characterNumber + ".jpg")) );
			image2.setVisible(false);
			add(image2);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Image not found for character number: " + characterNumber);
		}
	}
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new AlphabetDetails();
//	}
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

	ButtonHandler buttonHandler = new ButtonHandler();
}
