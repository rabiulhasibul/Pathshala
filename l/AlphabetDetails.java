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


public class AlphabetDetails extends JPanel
{
	public JDialog alphabetDetailsDialog;
	public String character;
	public JLabel CurrentAlphabet, image, detailsOfCharacter;
	public int characterNumber=1; 
	String details[] = new String[85];
	JButton soun;
	Main mainClass;
	
	public String ButtonCategory = "";
	
	public AlphabetDetails()
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
				 URL urlClick = AlphabetDetails.class.getResource(characterNumber + ".wav");
				 click = Applet.newAudioClip(urlClick);
				 click.play();
				}catch(Exception e){
					System.out.println("The .wav file not found");
				}
				System.out.println("Command from: " + characterNumber);
			}
		}
		
	}
	
	public AlphabetDetails(int n) {
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
		details[33] = "এ তে একতারা";
		details[34] = "ঐ তে ঐরাবত";
		details[35] = "ও তে  ওল";
		details[36] = "ঔ তে ঔষধ";
		details[37] = "ক তে কলম";
		details[38] = "খ  ত  খরগোশ";
		details[39] = "গ তে গরু";
		details[40] = "ঘ তে ঘোড়া";
		details[41] = "ঙ তে ব্যাঙ";
		details[42] = "চ তে চাঁদ";
		details[43] = "ছ তে ছাতা ";
		details[44] = "জ  তে জাহাজ";
		details[45] = "ঝ তে ঝিনুক";
		details[46] = "ঞ তে মিঞাভাই";
		details[47] = "ট তে টিয়া";
		details[48] = "ঠ  তে ঠেলাগাড়ি";
		details[49] = "ড তে ডাব";
		details[50] = "ঢ তে ঢোল";
		details[51] = "ণ তে হরিণ";
		details[52] = "ত তে তাল";
		details[53] = "থ তে থালা";
		details[53] = "দ তে দাঁত";
		details[54] = "ধ তে ধান ";
		details[55] = "ন তে নৌকা ";
		details[56] = "প তে পাখি";
		details[57] = "ফ তে ফুল";
		details[58] = "ব তে বাঘ";
		details[59] = "ভ তে  ভূত";
		details[60] = "ম তে মাছ";
		details[61] = "য তে যানবাহন ";
		details[62] = "র তে রংধুনু";
		details[63] = "ল তে লাটিম";
		details[64] = "শ তে শুঁকুন";
		details[65] = "ষ তে ষাঁড়";
		details[66] = "স তে সাপ";
		details[67] = "হ তে হরিণ";
		details[68] = "ড় তে পাহাড়";
		details[69] = "ঢ় তে আষাঢ়";
		details[70] = "য় তে আয়";
		details[71] = "ৎ তে মৎস্য";
		details[72] = "ং তে মাংস";
		details[73] = "ঃ তে দুঃখ";
		details[74] = "ঁতে চাঁদ";
		
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
			image = new JLabel( new ImageIcon(getClass().getResource("a" + characterNumber + ".jpg")) );
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
