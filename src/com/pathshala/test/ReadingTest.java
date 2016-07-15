package com.pathshala.test;

import java.applet.Applet;
import java.applet.AudioClip;
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

import com.pathsahala.test4.test4;
import com.pathshala.Mathalphabet.BanglaMathalphabet;
import com.pathshala.bangla.BanglaAlphabet;
import com.pathshala.banglapoem.BanglapoemClass;
import com.pathshala.english.EnlishAlphabet;
import com.pathshala.englishmath.EnlishMathAlphabet;
import com.pathshala.englishpoem.EnglishPeomClass;
import com.pathshala.imageprocessing.DrawAndSaveImage;
import com.pathshala.imageprocessing.SavePanelAsImage;
import com.pathshala.main.mainWIndowClass;
import com.pathshala.test1.EnglishTest;
import com.pathshala.test2.BanglaTest;
import com.pathshala.test3.BanglaTest2;

public class ReadingTest extends JPanel{

	mainWIndowClass mainWNDW;
	public ReadingTest(mainWIndowClass mainWNDW) {
		this.mainWNDW =mainWNDW;
		// TODO Auto-generated constructor stub
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}catch(Exception e){}
		
		labelDeclaration();
		frameDeclaration();
	}
	
	private class ButtonHandler implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent event) {
			// TODO Auto-generated method stub
			if(event.getSource() == Test1)
			{
				new EnglishTest();
			}
			else if(event.getSource() == Test2)
			{
			
				new BanglaTest();
			}
			else if(event.getSource() ==Test3)
			{
				new BanglaTest2();
				
			}
			else if(event.getSource() ==Test4)
			{
				new test4();
				
			}
			else if(event.getSource() == Test5)
			{
				new SavePanelAsImage();
			}
			else if(event.getSource() == Test6)
			{
				DrawAndSaveImage.startProcess();
			}
		}
		
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int Bx=650, By=60, Px=50, Py=50;
		Test1.setSize(Bx, By);
		Test1.setLocation(Px, Py);
		
		Py += 80;
		Test2.setSize(Bx, By);
		Test2.setLocation(Px, Py);
		
		Py += 80;
		Test3.setSize(Bx, By);
		Test3.setLocation(Px, Py);
		
		Py += 80;
		Test4.setSize(Bx, By);
		Test4.setLocation(Px, Py);
		
		Py += 80;
		Test5.setSize(Bx, By);
		Test5.setLocation(Px, Py);
		
		Py += 80;
		Test6.setSize(Bx, By);
		Test6.setLocation(Px, Py);
		testResult.setLocation(10,0);
		
		
	}
	
	
	public void labelDeclaration()
	{
		Font englishFont = new Font("Lucida Handwriting", Font.PLAIN, 45);
		
		Test1 = new JButton(" Alphabet Test1");
		Test1.setFont(englishFont);
		Test1.addActionListener(buttonHandler);
		
		Test2 = new JButton(" Alphabet Test2");
		Test2.setFont(englishFont);
		Test2.addActionListener(buttonHandler);
		
		Test3 = new JButton(" Alphabet Test3");
		Test3.setFont(englishFont);
		Test3.addActionListener(buttonHandler);
		
		Test4 = new JButton(" Alphabet Test4");
		Test4.setFont(englishFont);
		Test4.addActionListener(buttonHandler);
		
		Test5 = new JButton("Writing");
		Test5.setFont(englishFont);
		Test5.addActionListener(buttonHandler);
		
		Test6 = new JButton("Drawing");
		Test6.setFont(englishFont);
		Test6.addActionListener(buttonHandler);

		testResult = new JLabel();
		testResult.setIcon(new ImageIcon(getClass().getResource("/test.jpg")));
		add(Test1);
		add(Test2);
		add(Test3);
		add(Test4);
		add(Test5);
		add(Test6);
	    add(testResult);
		
	}
	
	public void frameDeclaration()
	{
		JDialog ReadingTest = new JDialog();
		ReadingTest.setTitle("");
		ReadingTest.setSize(750, 600);
		ReadingTest.add(this);
		ReadingTest.setModal(true);
		ReadingTest.setLocationRelativeTo(null);
		ReadingTest.setDefaultCloseOperation(ReadingTest.DISPOSE_ON_CLOSE);
		//ReadingTest.setVisible(true);
	}
	
	
	JButton Test1,  Test2, 
	Test3, Test4, Test5, Test6;
	JLabel testResult;
	ButtonHandler buttonHandler = new ButtonHandler();
	
}
