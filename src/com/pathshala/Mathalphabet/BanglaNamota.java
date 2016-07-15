package com.pathshala.Mathalphabet;

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

public class BanglaNamota extends JPanel{
	Font banglaFont;
	BanglaMathalphabet mWC;
	public BanglaNamota(BanglaMathalphabet mWC) {
		this.mWC = mWC;
		// TODO Auto-generated constructor stub
		
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
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		new EnglishPeomClass();
//	}
	
	public void labelDeclaration()
	{
		String poemList[] = {"এক", "দুই", "তিন", "চার", "পাঁচ","ছয়", "সাত", "আট","নয়","দশ"}; 
		englishPoemList = new JComboBox(poemList);
		englishPoemList.setFont(banglaFont);
		englishPoemList.setForeground(Color.MAGENTA);
		englishPoemList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				String fileName = "banglaNamota";
				if(englishPoemList.getSelectedItem().equals("এক"))
				{
					fileName = "BanglaNamota/1.txt";
					
					//poemTextArea.setText();
				}
				else if(englishPoemList.getSelectedItem().equals("দুই"))
				{
					fileName = "BanglaNamota/2.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("তিন"))
				{
					fileName = "BanglaNamota/3.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("চার"))
				{
					fileName = "BanglaNamota/4.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("পাঁচ"))
				{
					fileName = "BanglaNamota/5.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("ছয়"))
				{
					fileName = "BanglaNamota/6.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("সাত"))
				{
					fileName = "BanglaNamota/7.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("আট"))
				{
					fileName = "BanglaNamota/8.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("নয়"))
				{
					fileName = "BanglaNamota/9.txt";
				}
				else if(englishPoemList.getSelectedItem().equals("দশ"))
				{
					fileName = "BanglaNamota/10.txt";
				}
				try {
					Scanner fileScanner = new Scanner(new File(fileName));
					String s = "";
					while(fileScanner.hasNext())
					{
						s += fileScanner.nextLine() + "\n";
					}
					poemTextArea.setText(s);
					//System.out.println("succsessfull");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Sorry the file for " + englishPoemList.getSelectedItem() + " is missing." );
				}
			}
		});
		add(englishPoemList);
		
		poemTextArea = new JTextArea("This area will contain the poem.");
		poemTextArea.setFont(banglaFont);
		poemTextArea.setBackground(this.getBackground().cyan);
		poemTextArea.setEditable(false);
		//poemTextArea.setse(false);
		//add(poemTextArea);
		
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
					 URL urlClick = BanglaNamota.class.getResource("/" + "1.wav");
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
		banglaPoem.setTitle("বাংলা নামতা");
		banglaPoem.setForeground(Color.blue);
		banglaPoem.setSize(515, 540);
		banglaPoem.add(this);
		banglaPoem.setLocationRelativeTo(null);
		banglaPoem.setModal(true);
		banglaPoem.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setFrameVisible(false);
	}
	
	public void setFrameVisible(boolean flag)
	{
		banglaPoem.setVisible(flag);
	}

	

	JComboBox englishPoemList;
	
	JScrollPane scrollPane;
	JTextArea poemTextArea;
	JButton recitPoemButton;
	JLabel testResult;
	JDialog banglaPoem;
}
