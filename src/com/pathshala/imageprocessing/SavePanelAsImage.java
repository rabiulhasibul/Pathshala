package com.pathshala.imageprocessing;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.pathshala.bangla.BanglaAlphabetDetails;

public class SavePanelAsImage extends JPanel implements MouseMotionListener, MouseListener{

	JDialog savePanelAsImageDialog;
	JButton checkButton,checkButton2;
	JPanel mainPanel;
	JPanel panel2;
	JLabel characterImage;
	public JDialog alphabetDetailsDialog;
	public String character;
	public JLabel CurrentAlphabet, image, detailsOfCharacter, image1,image2,image3,image4,image5,image6;
	public int characterNumber=1; 
	String details[] = new String[85];
	JButton soun;
	JPanel panel;
	public String ButtonCategory = "";
	public SavePanelAsImage() {
		// TODO Auto-generated constructor stub
		
		checkButton = new JButton("Next");
		checkButton.setBounds(134, 113, 61, 23);
		checkButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//takeSnapShot(mainPanel);
				setImage(imgNo++);
			}
		});
		
		checkButton2 = new JButton("Clear");
		checkButton2.setBounds(154, 123, 61, 23);
		checkButton2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			panel.getGraphics().clearRect(0, 0, 684, 282);
			}
		});
		
	//	mainPanel = this;	
		
		//addMouseMotionListener(this);
		//addMouseListener(this);
		
		image = new JLabel(); 
		image.setBounds(200, 5, 350, 240);
		image1 = new JLabel();
		image1.setBounds(200, 5, 350, 240);
		image2 = new JLabel();
		image2.setBounds(200, 5, 350, 240);
		image4 = new JLabel();
		image4.setBounds(200, 5, 350, 240);
		image5 = new JLabel();
		image5.setBounds(200, 5, 350, 240);
		image6 = new JLabel();
		image6.setBounds(200, 5, 350, 240);
		setLayout(null);
		
		
		panel = new JPanel();
		panel.setBounds(0, 269, 684, 282);
		add(panel);
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
		
		
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 684, 282);
		add(panel2);
		panel2.addMouseListener(this);
		panel2.addMouseMotionListener(this);
		
		panel2.add(checkButton2);
		panel2.add(checkButton);
		
		
		
		setImage(10);
		
	
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int a[] = {1, 39, 4}, i=1;
				while(true)
				{
					setImageControl(i);
					//repaint();
					i++;
					i = i % 7;
					if(i == 0) i++;
					System.out.println("thread running : " + i);
					try{
					Thread.sleep(2000);
					}catch(Exception e){}
				}
				
			}
		});
		//panel2.;
		thread.start();
		
		savePanelAsImageDialog = new JDialog();
		//savePanelAsImageDialog.add(checkButton);
		savePanelAsImageDialog.getContentPane().add(this);
		
		
		savePanelAsImageDialog.setTitle("Writing Test");
		savePanelAsImageDialog.setSize(700, 600);
		savePanelAsImageDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		savePanelAsImageDialog.setLocationRelativeTo(null);
		savePanelAsImageDialog.setVisible(true);		
	}
	
	int imgNo =1;
	
//	protected void paintComponent(Graphics g)
//	{
//		panel.paintComponents(g);
//		
//		
//		//message.setLocation(0, 0);
//		
//		setLocation(50, 20);
//		setSize(400, 500);
//		image.setLocation(200, 0);
//		image1.setLocation(200, 0);
//		image2.setLocation(200, 0);
//		g.setColor(Color.lightGray);
//		g.fillRect(100, 250, 300, 250);
//		//setBackground(Color.green);
//	}
	
	public void setImage(int imno)
	{
		try
		{
			image.setIcon( new ImageIcon(getClass().getResource("/wri (" + imgNo + ").jpg")) );
			System.out.println(imno);
			panel2.add(image);
			image1.setIcon( new ImageIcon(getClass().getResource("/wri1 (" + imgNo + ").jpg")) );
			image1.setVisible(false);
			panel2.add(image1);
			
			image2.setIcon( new ImageIcon(getClass().getResource("/wri2 (" + imgNo + ").jpg")) );
			image2.setVisible(false);
			panel2.add(image2);
			image4.setIcon( new ImageIcon(getClass().getResource("/wri3 (" + imgNo + ").jpg")) );
			image4.setVisible(false);
			panel2.add(image4);
			image5.setIcon( new ImageIcon(getClass().getResource("/wri4 (" + imgNo + ").jpg")) );
			image5.setVisible(false);
			panel2.add(image5);
			image6.setIcon( new ImageIcon(getClass().getResource("/wri5 (" + imgNo + ").jpg")) );
			image6.setVisible(false);
			panel2.add(image6);
			setImageControl(1);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Image not found for character number: " + characterNumber);
		}
	}
	
	public void setImageControl(int imno)
	{
		if(imno == 1) 
		{
			image.setVisible(true);
			image1.setVisible(false);
			image2.setVisible(false);
			image4.setVisible(false);
			image5.setVisible(false);
			image6.setVisible(false);
		}
		else if(imno == 2) 
		{
			image.setVisible(false);
			image1.setVisible(true);
			image2.setVisible(false);
			image4.setVisible(false);
			image5.setVisible(false);
			image6.setVisible(false);
		}
		else if(imno==3)
		{
			image.setVisible(false);
			image1.setVisible(false);
			image2.setVisible(true);
			image4.setVisible(false);
			image5.setVisible(false);
			image6.setVisible(false);
		}
		else if(imno==4)
		{
			image.setVisible(false);
			image1.setVisible(false);
			image2.setVisible(false);
			image4.setVisible(true);
			image5.setVisible(false);
			image6.setVisible(false);
		}
		else if(imno==5)
		{
			image.setVisible(false);
			image1.setVisible(false);
			image2.setVisible(false);
			image4.setVisible(false);
			image5.setVisible(true);
			image6.setVisible(false);
		}
		else 
		{
			image.setVisible(false);
			image1.setVisible(false);
			image2.setVisible(false);
			image4.setVisible(false);
			image5.setVisible(false);
			image6.setVisible(true);
		}
		System.out.println(imno + " is visible now");
		//repaint();
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
	
	ButtonHandler buttonHandler = new ButtonHandler();
	
	
	
//	
//	public void run() {
//		// TODO Auto-generated method stub
//		int a[] = {1, 39, 4}, i=1;
//		while(true)
//		{
//			setImageControl(i);
//			//repaint();
//			i++;
//			i = i % 4;
//			if(i == 0) i++;
//			System.out.println("thread running : " + i);
//			try{
//			Thread.sleep(2000);
//			}catch(Exception e){}
//		}
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SavePanelAsImage();
	}
	
	/*public void takeSnapShot(JPanel mainPanel)
	{
		BufferedImage bufImage = new BufferedImage(mainPanel.getSize().width, mainPanel.getSize().height, BufferedImage.TYPE_INT_RGB);
		mainPanel.paint(bufImage.createGraphics());
				
		//File imageFile = new File("." + File.separator);
		File imageFile = new File("p.jpeg");
		try{
			imageFile.createNewFile();
			ImageIO.write(bufImage, "jpeg", imageFile);
			System.out.println("file saved");
			JOptionPane.showMessageDialog(null, "File saved");
		}catch(Exception e){
			System.out.println("Exception found");
			JOptionPane.showMessageDialog(null, "Exception found");
			e.printStackTrace();
		}
	}*/

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		count = 0;
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		count = 0;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	int x, y;
	int px;
	int py;
	int count = 0;
//	private JPanel panel;
	@Override
	public void mouseDragged(MouseEvent e2) {
		// TODO Auto-generated method stub
		if (count == 0) {
			x = e2.getX();
			y = e2.getY();
			Graphics g = panel.getGraphics();
			g.setColor(Color.black);
			g.drawLine(x, y, x, y);
			px = x;
			py = y;
			count = 1;
		} else {
			x = e2.getX();
			y = e2.getY();
			Graphics g = panel.getGraphics();
			g.setColor(Color.black);
			g.drawLine(px, py, x, y);
			px = x;
			py = y;
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
