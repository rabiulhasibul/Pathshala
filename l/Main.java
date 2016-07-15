import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.pathshala.englishpoem.EnglishPeomClass;

public class Main extends JPanel {
	JFrame mainFrame;

	JMenu menu, poem;
	JMenuBar menuBar;
	JMenuItem bangla, english, banglaPoem, englishPoem;
	JButton gotoMathButton;
	JButton banglaButton[] = new JButton[50], englih[] = new JButton[26];
	JButton mathButton[] = new JButton[10];
	JLabel englishWelcomeMessage;
	// AlphabetDetails alphabetDetails = new AlphabetDetails();
	ButtonHandler buttonHandler = new ButtonHandler();
	Main mainClass;
	public int characterNumber = 1;

	public Main() {
		mainClass = this;
		{
			try {
				UIManager.setLookAndFeel(UIManager
						.getSystemLookAndFeelClassName());
			} catch (Exception ex) {
			}

			menu = new JMenu("Select Language");
			menuBar = new JMenuBar();
			menuBar.add(menu);
			add(menuBar);

			bangla = new JMenuItem("Bangla");
			english = new JMenuItem("English");
			menu.add(bangla);
			menu.add(english);
			
			poem = new JMenu("Poem");
			menu.addSeparator();
			menu.add(poem);
			
			banglaPoem = new JMenuItem("Bangla Poem");
			poem.add(banglaPoem);
			englishPoem = new JMenuItem("English Poem");
			poem.add(englishPoem);

			gotoMathButton = new JButton("Mathematical Alphabet");
			gotoMathButton.setFont(new Font("", Font.PLAIN, 20));
			gotoMathButton.addActionListener(buttonHandler);

			add(gotoMathButton);

			bangla.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					SetvisibilityEnglish(false);
					SetvisibilityBangla(true);
					setvisibilityMath(false);
					gotoMathButton.setVisible(false);
				}
			});
			english.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					SetvisibilityEnglish(true);
					SetvisibilityBangla(false);
					setvisibilityMath(false);
					gotoMathButton.setVisible(true);
				}
			});
			
			banglaPoem.addActionListener( new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					//new EnglishPeomClass();
				}
			});

			declaringMethod();
			SetvisibilityEnglish(true);
			setvisibilityMath(false);
			SetvisibilityBangla(false);
		}

		mainFrame = new JFrame("This is Robiul");
		mainFrame.setSize(1350, 720);
		mainFrame.add(this);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
	}

	public void declaringMethod() {
		Font englishFont = new Font("Times New Roman", Font.BOLD, 90);
		englishWelcomeMessage = new JLabel(
				"Welcome to English Alphabet learning!");
		englishWelcomeMessage.setFont(new Font("Segoe Print", Font.BOLD, 50));
		add(englishWelcomeMessage);

		for (int i = 0; i < 26; i++) {
			int asci = 65 + i;
			final char c = (char) asci;
			englih[i] = new JButton("" + c);
			englih[i].setFont(englishFont);
			englih[i].addActionListener(buttonHandler);
			add(englih[i]);
		}

		Font banglaFont = new Font("SolaimanLipi", Font.BOLD, 90);

		for (int i = 0; i < 50; i++) {
			banglaButton[i] = new JButton("" + i);
			banglaButton[i].setFont(banglaFont);
			banglaButton[i].addActionListener(buttonHandler);
			add(banglaButton[i]);
		}
		setBanglaCharacter();

		// Math aplhabet declaring
		for (int i = 0; i < 10; i++) {
			char c = (char) (48 + i);
			mathButton[i] = new JButton(c + "");
			mathButton[i].setFont(new Font("Times New Roman", Font.BOLD, 85));
			mathButton[i].addActionListener(buttonHandler);
			add(mathButton[i]);
		}

		int x = '1';
		System.out.println(x);

	}
	
	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {

			if(event.getSource() == gotoMathButton)
			{
				SetvisibilityEnglish(false);
				SetvisibilityBangla(false);
				setvisibilityMath(true);
				gotoMathButton.setVisible(false);				
				return;
			}
			
			String command = "null";
			for (int i = 0; i < 26; i++) {
				if (event.getSource() == englih[i]) {
					command = "English";
					// alphabetDetails.CurrentAlphabet.setText(englih[i].getText());
					characterNumber = 1 + i;
					// alphabetDetails.setImage(characterNumber);
					break;
				}
				if(i < 10 )
					if(event.getSource() == mathButton[i])
					{
						command = "Math";
						characterNumber = 1 + i;
						break;
					}
			}
			if (command.equals("English")) {
				AlphabetDetails alphabetDetails = new AlphabetDetails(
						characterNumber);
				alphabetDetails.ButtonCategory = "englishButton";
				alphabetDetails.CurrentAlphabet.setFont(new Font(
						"Times New Roman", Font.BOLD, 90));
				alphabetDetails.detailsOfCharacter.setFont(new Font(
						"Times New Roman", Font.BOLD, 30));
				alphabetDetails.CurrentAlphabet
						.setText(englih[characterNumber - 1].getText());
				System.out.println("-------" + characterNumber);
				alphabetDetails.alphabetDetailsDialog.setVisible(true);
			} 
			else if(command.equals("Math"))
			{
				int x = Integer.parseInt(mathButton[characterNumber-1].getText());
				
				AlphabetDetails alphabetDetails = new AlphabetDetails(
						x + 77);
				alphabetDetails.ButtonCategory = "mathButton";
				alphabetDetails.CurrentAlphabet.setFont(new Font(
						"Times New Roman", Font.BOLD, 90));
				alphabetDetails.detailsOfCharacter.setFont(new Font(
						"Times New Roman", Font.BOLD, 30));
				alphabetDetails.CurrentAlphabet
						.setText(mathButton[characterNumber - 1].getText());
				System.out.println("-------" + characterNumber);
				alphabetDetails.alphabetDetailsDialog.setVisible(true);
			}
			else {
				for (int i = 0; i < 50; i++) {
					if (event.getSource() == banglaButton[i]) {
						// command = "Bangla";
						// alphabetDetails.CurrentAlphabet.setText(englih[i].getText());
						characterNumber = i + 1;
						// alphabetDetails.setImage(characterNumber);
					}
				}
				AlphabetDetails alphabetDetails = new AlphabetDetails(
						characterNumber + 26);
				alphabetDetails.ButtonCategory = "banglaButton";
				alphabetDetails.CurrentAlphabet
						.setText(banglaButton[characterNumber - 1].getText());
				alphabetDetails.CurrentAlphabet.setFont(new Font(
						"SolaimanLipi", Font.BOLD, 90));
				alphabetDetails.detailsOfCharacter.setFont(new Font(
						"SolaimanLipi", Font.BOLD, 30));
				System.out.println("-------" + characterNumber);
				alphabetDetails.alphabetDetailsDialog.setVisible(true);
			}
		}
	}

	public void SetvisibilityEnglish(Boolean flag) {

		if (flag == true) {
			for (int i = 0; i < 26; i++)
				englih[i].setVisible(true);
		} else
			for (int i = 0; i < 26; i++)
				englih[i].setVisible(false);
	}

	public void SetvisibilityBangla(Boolean flag) {
		if (flag == true) {
			for (int i = 0; i < 50; i++)
				banglaButton[i].setVisible(true);
		} else
			for (int i = 0; i < 50; i++)
				banglaButton[i].setVisible(false);
	}
	
	public void setvisibilityMath(Boolean flag)
	{
		if(flag == true)
		{
			for(int i=0; i<10; i++)
				mathButton[i].setVisible(true);
		}
		else for(int i=0; i<10; i++)
			mathButton[i].setVisible(false);
	}

	int x = 100, y = 140;

	protected void paintComponent(Graphics golap) {
		super.paintComponent(golap);

		menuBar.setLocation(0, 0);
		menuBar.setSize(getWidth(), 20);

		englishWelcomeMessage.setLocation(200, 20);
		
		gotoMathButton.setSize(250, 40);
		gotoMathButton.setLocation(getWidth()-270, getHeight()-50);
		
		int x = 20;
		y = 120;
		for (int i = 0; i < 26; i++) {
			englih[i].setSize(200, 90);
			englih[i].setLocation(x, y);
			x += 220;
			if ((i + 1) % 6 == 0 && i > 0) {
				y += 110;
				x = 20;
			}
		}
		
		x = 20;
		y = 120;
		for (int i = 0; i < 10; i++) {
			mathButton[i].setSize(200, 90);
			mathButton[i].setLocation(x, y);
			x += 220;
			if ((i + 1) % 6 == 0 && i > 0) {
				y += 110;
				x = 20;
			}
		}
		
		x = 30;
		y = 110;
		for (int i = 0; i < 50; i++) {
			banglaButton[i].setSize(115, 90);
			banglaButton[i].setLocation(x, y);
			x += 145;
			if ((i + 1) % 9 == 0 && i > 0) {
				y += 95;
				x = 30;
			}
		}
		
		

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

	public static void main(String[] args) {
		new Main();
	}
}