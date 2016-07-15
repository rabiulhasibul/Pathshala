package com.pathshala.test1;
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


public class EnglishTestDetails extends JPanel
{
	public JDialog alphabetDetailsDialog;
	public String character;
	public JLabel CurrentAlphabet, image, detailsOfCharacter;
	public int characterNumber=1; 
	String details[] = new String[85];
	JButton soun;
	
	public String ButtonCategory = "";
	
	public EnglishTestDetails()
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
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		CurrentAlphabet.setLocation(200, 20);
		image.setLocation(13, 120);
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
				 URL urlClick = EnglishTestDetails.class.getResource("/" +characterNumber + ".wav");
				 click = Applet.newAudioClip(urlClick);
				 click.play();
				}catch(Exception e){
					System.out.println("The .wav file not found");
				}
				System.out.println("Command from: " + characterNumber);
			}
		}
		
	}
	
	public EnglishTestDetails(int n) {
		// TODO Auto-generated constructor stub
		this.characterNumber = n;
		details[0] = "A for Apple ";
		details[1] = "B for Ball";
		details[2] = "C for Cat ";
		details[3] = "D for Dog ";
		details[4] = "E for Egg ";
		details[5] = "F for Flower";details[6] = "G for Gorgilla";
		details[7] = "  H for Hen";details[8] = " I for Innovation";details[9] = "   J for Jar";details[10] = " k for Kite ";details[11] = "  L for Lion";details[12] = "  M for Moon";
		details[13]= " N  for Nut ";details[14] = " O  for OX";details[15] = "  P for Peageon";details[16] = "  Q for Queen ";details[17] = "  R for Rat";details[18] = "  S for Sun";
		details[19] = " T for Tree";details[20] = " U for Umbrella";details[21] = " V for Vegetable";details[22] = "  W for Water";details[23] = " X for  X-ray";details[24] = " Y for  Yak ";
		details[25] = " Z for  Zebra ";
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
	    
		alphabetDetailsDialog = new JDialog();
		alphabetDetailsDialog.setTitle("Alphabet Details");
		alphabetDetailsDialog.setSize(385, 500);
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

	ButtonHandler buttonHandler = new ButtonHandler();
}
