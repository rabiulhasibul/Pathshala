package com.pathshala.bangla;
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


public class BanglaAlphabetDetails extends JPanel implements Runnable
{
	public JDialog alphabetDetailsDialog;
	public String character;
	public JLabel CurrentAlphabet, image, detailsOfCharacter, image1,image2,image3;
	public int characterNumber=1; 
	String details[] = new String[85];
	JButton soun;
	
	public String ButtonCategory = "";
	
//	public BanglaAlphabetDetails()
//	{
//		try
//		{
//			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//		}
//		catch(Exception e){}
//		
//		System.out.println("This is called");
//		detailsOfCharacter = new JLabel(details[characterNumber-1]);
//		detailsOfCharacter.setFont(new Font("Time New Roman", Font.PLAIN, 30));
//	
//		CurrentAlphabet = new JLabel("A");
//		CurrentAlphabet.setFont(new Font("", Font.BOLD, 50));
//		add(CurrentAlphabet);
//		
//		add(detailsOfCharacter);
//		setImage(1);
//		//add(soun);
//		
//		try{
//			/*image3 = new JLabel( new ImageIcon(getClass().getResource("/back.jpg")) );
//			System.out.println("image added for dialog");
//			add(image3);*/
//			}
//			catch(Exception e){System.out.println("Background inmage for character details frmage is not available.");}
//		
//		alphabetDetailsDialog = new JDialog();
//		alphabetDetailsDialog.setTitle("");
//		alphabetDetailsDialog.setSize(500, 500);
//		alphabetDetailsDialog.setLocationRelativeTo(null);
//		alphabetDetailsDialog.setModal(true);
//		alphabetDetailsDialog.add(this);
//		alphabetDetailsDialog.setDefaultCloseOperation(alphabetDetailsDialog.DISPOSE_ON_CLOSE);
//		
//		alphabetDetailsDialog.setVisible(true);	
//		
//		
//	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		CurrentAlphabet.setLocation(200, 20);
		image3.setLocation(0, 0);
		image.setLocation(70,120);
		image1.setLocation(70, 120);
		image2.setLocation(70, 120);
		
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
				 URL urlClick = BanglaAlphabetDetails.class.getResource("/" +characterNumber + ".wav");
				 click = Applet.newAudioClip(urlClick);
				 click.play();
				}catch(Exception e){
					System.out.println("The .wav file not found");
				}
				System.out.println("Command from: " + characterNumber);
			}
		}
		
	}
	
	public BanglaAlphabetDetails(int n) {
		// TODO Auto-generated constructor stub
		this.characterNumber = n;
		
		details[26] = "অ তে অজু ";
		details[27] = "আ তে আযান ";
		details[28] = "ই  তে  ইট";
		details[29] = "ঈ তে ঈদ";
		details[30] = "উ তে উড়োজাহাজ";
		details[31] = "ঊ  তে  উধধাকাশ";
		details[32] = "ঋ তে ঋতু";
		details[33] = "এ তে  এক আল্লাহ্‌";
		details[34] = "ঐ তে  ঐ যে গলাপ ";
		details[35] = "ও তে  ওজন";
		details[36] = "ঔ তে ঔষধ";
		details[37] = "ক তে কাবা";
		details[38] = "খ  তে খেয়া নৌকা";
		details[39] = "গ তে  গাড়ি";
		details[40] = "ঘ তে  ঘড়ি";
		details[41] = "ঙ তে  নাঙল";
		details[42] = "চ তে  চেয়ার";
		details[43] = "ছ তে  ছাতা ";
		details[44] = "জ  তে জাহাজ";
		details[45] = "ঝ তে ঝরনা";
		details[46] = "ঞ তে মিঞাভাই";
		details[47] = "ট তে টাকা";
		details[48] = "ঠ  তে ঠেলাগাড়ি";
		details[49] = "ড তে ডাব";
		details[50] = "ঢ তে ঢং ঢং ";
		details[51] = "ণ  তে  আরুণ";
		details[52] = "ত তে  তুষার";
		details[53] = "থ তে থলি";
		details[54] = "দ তে  দেয়াশলাই";
		details[55] = "ধ তে ধান";
		details[56] = "ন তে নদী";
		details[57] = "প তে পাখা";
		details[58] = "ফ তে ফুল";
		details[59] = "ব তে বন";
		details[60] = "ভ তে  ভেড়া";
		details[61] = "ম তে মদিনা";
		details[62] = "য তে যানবাহন ";
		details[63] = "র তে রেলগাড়ি";
		details[64] = "ল তে লাউ";
		details[65] = "শ তে শাপলা";
		details[66] = "ষ তে  বৃষ্টি";
		details[67] = "স তে সাবান";
		details[68] = "হ তে হাত";
		details[69] = "ড় তে  আছাড়";
		details[70] = "ঢ় তে আষাঢ়";
		details[71] = "য় তে পেয়ালা";
		details[72] = "ৎ তে মড়াৎ";
		details[73] = "ং তে রং ";
		details[74] = "ঃ  তে দুঃখ";
		details[75] = "ঁ তে চাঁদ";
		
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
		soun.setIcon(new ImageIcon(getClass().getResource("/initaia.jpg")));
		add(soun);
		Thread thread = new Thread(this);
		thread.start();
		
		try{
			if(characterNumber<36){
			image3 = new JLabel( new ImageIcon(getClass().getResource("/bac.jpg")) );
			System.out.println("image added for dialog");
			add(image3);}
			else if(characterNumber<46)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f1.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			else if(characterNumber<56)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f2.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			else if(characterNumber<66)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f3.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			else if(characterNumber<=76)
			{
				image3 = new JLabel( new ImageIcon(getClass().getResource("/f5.jpg")) );
				System.out.println("image added for dialog");
				add(image3);
			}
			}
			catch(Exception e){System.out.println("Background inmage for character details frmage is not available.");}
		
		try{
			System.out.println("Sound playing...");
			 URL urlClick = BanglaAlphabetDetails.class.getResource("/" +characterNumber + ".wav");
			 click = Applet.newAudioClip(urlClick);
			 click.play();
			}catch(Exception e){
				System.out.println("The .wav file not found");
			}
			System.out.println("Command from: " + characterNumber);
		
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

	ButtonHandler buttonHandler = new ButtonHandler();
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
			Thread.sleep(2000);
			}catch(Exception e){}
		}
	}
}
