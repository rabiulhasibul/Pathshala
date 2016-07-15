package com.pathshala.main;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import com.pathshala.Mathalphabet.BanglaMathalphabet;
import com.pathshala.bangla.BanglaAlphabet;
import com.pathshala.banglapoem.BanglapoemClass;
import com.pathshala.english.EnlishAlphabet;
import com.pathshala.englishmath.EnlishMathAlphabet;
import com.pathshala.englishpoem.EnglishPeomClass;
import com.pathshala.imageprocessing.DrawAndSaveImage;
import com.pathshala.test.ReadingTest;
import com.robiul.pathshala.initial;

//import com.pathshala.test.ReadingTest;

public class mainWIndowClass extends JPanel {

	mainWIndowClass mainWNDW;

	public mainWIndowClass() {
		this.mainWNDW = this;
		// TODO Auto-generated constructor stub

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
		}

		labelDeclaration();
		frameDeclaration();
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		tabbedPane.setLocation(0, 0);
		tabbedPane.setSize(1370, 760);
	}

	public void labelDeclaration() {
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("", new ImageIcon("src/main.jpg"), new initial(this));
		tabbedPane.addTab("", new ImageIcon("src/bangla.jpg"), new BanglaAlphabet(this));
		// add(tabbedPane);

		tabbedPane.addTab("",new ImageIcon("src/gonit.jpg"), new BanglaMathalphabet(this));

		tabbedPane.addTab("",new ImageIcon("src/english.jpg"), new EnlishAlphabet(this));

		tabbedPane.addTab("",new ImageIcon("src/math.jpg"),new EnlishMathAlphabet(this));

		//tabbedPane.addTab("Bangla Poem",new ImageIcon("src/alamin.gif"), new BanglapoemClass(this));

	//	tabbedPane.addTab("English Poem",new ImageIcon("src/alamin.gif"), new EnglishPeomClass(this));

		tabbedPane.addTab("",new ImageIcon("src/tast.png"), new ReadingTest(this));

		//tabbedPane.addTab("Drawing",new ImageIcon("src/alamin.gif"), new DrawAndSaveImage(this));
         add(tabbedPane);
	}

	public void frameDeclaration() {
		mainWindowFrame = new JFrame("main window");
		mainWindowFrame.setSize(1370, 760);
		mainWindowFrame.add(this);
		mainWindowFrame.setLocationRelativeTo(null);
		mainWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWindowFrame.setVisible(true);
	}

	JTabbedPane tabbedPane;

	JButton BanglaAlphabet, EnglishAlphabet, BanglaMathematicalAlphabet,
			EnglishMathematicalAlphabet, BanglaPoem, EnglishPoem, WritingTest,
			Test;

	public JFrame mainWindowFrame;

	public static void main(String[] args) {
		new mainWIndowClass();
	}
}
