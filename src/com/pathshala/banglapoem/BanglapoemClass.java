package com.pathshala.banglapoem;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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
import com.pathshala.main.mainWIndowClass;

public class BanglapoemClass extends JPanel {

	Font banglaFont;
	mainWIndowClass mWC;
	public BanglapoemClass()
	{
		banglaFont = new Font("Siyam Rupali", Font.PLAIN, 17);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		labelDeclaration();
		frameDeclaration();
	}
	
	mainWIndowClass mC;
	
	public BanglapoemClass(mainWIndowClass mWC) {
		this.mWC = mWC;
		// TODO Auto-generated constructor stub
		banglaFont = new Font("Siyam Rupali", Font.PLAIN, 17);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		labelDeclaration();
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		poemTextArea.setSize(0, 0);
		poemTextArea.setLocation(0, 0);
		scrollPane.setSize(300, 400);
		scrollPane.setLocation(95, 55);
		testResult.setLocation(0, 0);
		recitPoemButton.setSize(170, 50);
		recitPoemButton.setLocation(390,500);
		englishPoemList.setLocation(400, 10);
		
	}

	public void labelDeclaration()
	{
		poemTextArea = new JTextArea("This area will contain the poem.");
		poemTextArea.setFont(banglaFont);
		poemTextArea.setBackground(this.getBackground().MAGENTA);
		poemTextArea.setEditable(false);
		
		scrollPane = new JScrollPane(poemTextArea);
		add(scrollPane);
		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/write2.png")));
		
		String poemList[] = {"এত খুসি", "চাঁদ মামা", "আতা গাছে", "খকন খকন","এক দুই", "মেঘের কোলে ","দোল দোল"}; 
		englishPoemList = new JComboBox(poemList);
		englishPoemList.setFont(banglaFont);
		englishPoemList.setForeground(Color.BLUE);
		englishPoemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String fileName = "banglapoem/akdui.txt";
				if(englishPoemList.getSelectedItem().equals("এক দুই"))
				{
					fileName = "banglapoem/123.txt";
				
				}
				else if(englishPoemList.getSelectedItem().equals("চাঁদ মামা"))
				{
					fileName = "banglapoem/chadmama.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("আতা গাছে"))
				{
					fileName = "banglapoem/ata.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("এত খুসি"))
				{
					fileName = "banglapoem/atohashi.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("মেঘের কোলে"))
				{
					fileName = "banglapoem/maghar.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("দোল দোল"))
				{
					fileName = "banglapoem/doldol.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("খকন খকন"))
				{
					fileName = "banglapoem/khokon.txt";
				}
				try {
					Scanner fileScanner = new Scanner(new File(fileName));
					System.out.println("file name: " + fileName );
					String s = "";
					while(fileScanner.hasNext())
					{
						s += fileScanner.nextLine() + "\n";
						System.out.println("reading...");
					}
					//
					poemTextArea.setText("" + s);
					System.out.println("////////////////" + s);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sorry the file for " + englishPoemList.getSelectedItem() + " is missing." );
				}
			}
		});
		add(englishPoemList);
		
		recitPoemButton = new JButton("Recit The Poem");
		recitPoemButton.addActionListener(new ActionListener() {
			AudioClip click;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try{
					 if(englishPoemList.getSelectedItem().equals("এত খুসি"))
					{
						URL urlClick = BanglapoemClass.class.getResource("/" + "1.wav");
						 click = Applet.newAudioClip(urlClick);
						 click.play();
					}
					 else if(englishPoemList.getSelectedItem().equals("t"))
						{
							URL urlClick = BanglapoemClass.class.getResource("/" + "1.wav");
							 click = Applet.newAudioClip(urlClick);
							 click.play();
						}

					 
					}catch(Exception e){
						JOptionPane.showMessageDialog(null, "The .wav file not found");
					}
			}
		});
		add(recitPoemButton);
		add(testResult);
	}
	
	public void frameDeclaration()
	{
		banglaPoem = new JDialog();
		banglaPoem.setTitle("বাংলা কবিতা");
		banglaPoem.setSize(570, 600);
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
	JLabel testResult;
	JScrollPane scrollPane;
	JTextArea poemTextArea;
	JButton recitPoemButton;
  	JDialog banglaPoem;
}
