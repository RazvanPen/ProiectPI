package flyscan;

import javax.swing.ImageIcon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics2D;
import java.awt.Cursor;

public class HomeFrame extends JFrame{
	private ImageIcon Picon = new ImageIcon("poza2.png"); 
	private JLabel x = new JLabel();
	private JLabel y = new JLabel("Welcome");
	private ImageIcon background = new ImageIcon("poza1.png");
	
	
	public HomeFrame(){
		
		setVisible(true);
		setSize(1280, 800);
		setTitle("FlyScanRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setIconImage(Picon.getImage());
		getContentPane().setBackground(new Color(0x123456));
		setLocationRelativeTo(null);
		setLayout(null);
		x.setIcon(background);
		add(x);
		x.setBounds(0, 0, 1280, 800);
		x.add(y);
		y.setBounds(0 , 40, 500, 500);
	}
	
}
