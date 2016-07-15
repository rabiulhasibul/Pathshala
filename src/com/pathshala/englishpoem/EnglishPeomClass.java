package com.pathshala.englishpoem;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

import com.pathshala.main.mainWIndowClass;

public class EnglishPeomClass extends JPanel{

	Font banglaFont;
	mainWIndowClass mWC;
	public EnglishPeomClass() {
		this.mWC = mWC;

		banglaFont = new Font("Siyam Rupali", Font.PLAIN, 17);
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}
		
		labelDeclaration();
		frameDeclaration();
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		poemTextArea.setSize(0, 0);
		poemTextArea.setLocation(0, 0);
		scrollPane.setSize(300, 400);
		scrollPane.setLocation(95, 55);
		testResult.setLocation(0, 0);
		recitPoemButton.setSize(105, 50);
		recitPoemButton.setLocation(395,440);
		englishPoemList.setLocation(400, 10);
	}

	public void labelDeclaration()
	{
		String poemList[] = {"In The Name Of Allah", "Allah is Great", "Allah is One", "We Thank you Allah", "PROPHET"}; 
		englishPoemList = new JComboBox(poemList);
		englishPoemList.setFont(banglaFont);
		englishPoemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String fileName = "EnglishPoem/InTheNameOfAllah.txt";
				if(englishPoemList.getSelectedItem().equals("In The Name Of Allah"))
				{
					fileName = "EnglishPoem/InTheNameOfAllah.txt";
					//poemTextArea.setText();
				}
				else if(englishPoemList.getSelectedItem().equals("PROPHET"))
				{
					fileName = "EnglishPoem/Prophet.txt";
				}
				try {
					Scanner fileScanner = new Scanner(new File(fileName));
					String s = "";
					while(fileScanner.hasNext())
					{
						s += fileScanner.nextLine() + "\n";
					}
					poemTextArea.setText(s);
				} catch (FileNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Sorry the file for " + englishPoemList.getSelectedItem() + " is missing." );
				}
			}
		});
		add(englishPoemList);
		
		poemTextArea = new JTextArea("This area will contain the poem.");
		//poemTextArea.setFont(new Font("Serif", Font.PLAIN, 15));
		poemTextArea.setFont(banglaFont);
		poemTextArea.setBackground(this.getBackground().PINK);
		poemTextArea.setEditable(false);
	
		
		scrollPane = new JScrollPane(poemTextArea);
		add(scrollPane);
		
		recitPoemButton = new JButton("Recit The Poem");
		recitPoemButton.addActionListener(new ActionListener() {
			AudioClip click;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//
				try{
					 URL urlClick = EnglishPeomClass.class.getResource("/" + "1.wav");
					 click = Applet.newAudioClip(urlClick);
					 click.play();
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "The .wav file not found");
					}
			}
		});
		add(recitPoemButton);
		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/eng1.jpg")));
		add(testResult);
	}
	public void frameDeclaration()
	{
		banglaPoem = new JDialog();
		banglaPoem.setTitle("English poem");
		banglaPoem.setForeground(Color.blue);
		banglaPoem.setSize(515, 540);
		banglaPoem.add(this);
		banglaPoem.setLocationRelativeTo(null);
		banglaPoem.setModal(true);
		banglaPoem.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setFrameVisible(true);
	}
	
	public void setFrameVisible(boolean flag)
	{
		banglaPoem.setVisible(flag);
	}

	JComboBox englishPoemList;
	JDialog banglaPoem;
	JScrollPane scrollPane;
	JLabel testResult;
	JTextArea poemTextArea;
	JButton recitPoemButton;
}
