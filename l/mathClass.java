package com.robiul.pathshala;

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
import javax.swing.JPanel;
import javax.swing.UIManager;


public class mathClass extends JPanel {

	public JDialog alphabetDetailsDialog;
	public JLabel CurrentAlphabet, image, detailsOfCharacter;
	public int characterNumber=1; 
	String details[] = new String[34];
	JButton soun;
	
	public mathClass()
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
				 URL urlClick = mathClass.class.getResource(characterNumber + ".wav");
				 click = Applet.newAudioClip(urlClick);
				 click.play();
				}catch(Exception e){
					System.out.println("The .wav file not found");
				}
				System.out.println("Command from: " + characterNumber);
			}
		}
		
	}
	
	public mathClass(int n) {
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
		details[26] = "অ তে অজগর ";
		details[27] = "আ তে আম ";
		details[28] = "ই  তে  ইদুর";
		details[29] = "ঈ তে ঈগল";
		details[30] = "উ তে ঋতু";
		details[31] = "ঊ  তে উট";
		details[32] = "ঋ তে ঊষা";
		details[32] = "এ তে ঊষা";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		details[33] = "ঐ তে ";
		
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
	    
		soun=new JButton("Hear Soud");
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
		image = new JLabel( new ImageIcon(getClass().getResource("a" + characterNumber + ".jpg")) );
		System.out.println(imno);
		add(image);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new mathClass();
	}

	ButtonHandler buttonHandler = new ButtonHandler();
}

