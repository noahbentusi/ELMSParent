package main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ui.GraphicsUtils;
import ui.MyPictureButton;
import ui.MyPictureButtonListener;
import data.RMIServer;
 /** 
 * 
 * @author czq 
 * @version 2015年11月26日 下午3:27:46 
 */
public class Server {
	private static Point start = new Point();
	private JFrame frmElms;
	private static Image bg;
	private MyPictureButton exit;
	private MyPictureButton set;
	static{
		bg = GraphicsUtils.getImage("server");
		
	}
	
	private RMIServer server;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server window = new Server();
					window.frmElms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Server() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmElms = new JFrame();
		frmElms.setTitle("ELMS服务器端");
		frmElms.setBounds(438, 179, 489, 411);
		frmElms.setUndecorated(true);
		frmElms.setBackground(new Color(0, 0, 0, 0));
		
		frmElms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmElms.setContentPane(new JPanel(){
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(bg, 0, 0, null);
			}
		});
		moveFrame();
		frmElms.getContentPane().setLayout(null);
		frmElms.getContentPane().setBackground(new Color(0, 0, 0, 0));
		server = new RMIServer(null, "6600");
		
		final MyPictureButton btnNewButton = new MyPictureButton("confirm");
		btnNewButton.setText("启动服务");
		btnNewButton.setBounds(119, 240, 89, 37);
		frmElms.getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MyPictureButtonListener(btnNewButton){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				server.startRMI();
				btnNewButton.setText("运行中");
			}
		}
			);
			
		MyPictureButton stop = new MyPictureButton("cancel");
		stop.setText("停止服务");
		stop.setBounds(288, 240, 89, 37);
		frmElms.getContentPane().add(stop);
		
		stop.addMouseListener(new MyPictureButtonListener(stop){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				server.stopRMI();
			}
		});
		
		
		exit = new MyPictureButton("close");
		exit.setBounds(429, 6, 53, 53);
		frmElms.getContentPane().add(exit);
		exit.addMouseListener(new MyPictureButtonListener(exit){
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				System.exit(0);
			}
		});
	}
	
	private void moveFrame(){
		
		frmElms.addMouseListener(new MouseAdapter() {
			
			 @Override
			public void mousePressed(MouseEvent e) {
				 start.x = e.getX();
				 start.y = e.getY();
			 }
			
			
		});
		
		frmElms.addMouseMotionListener(new MouseMotionAdapter() {
			
			 @Override
			public void mouseDragged(MouseEvent e) {
					 Point p = frmElms.getLocation();
					 
					 frmElms.setLocation( p.x + e.getX() -start.x , p.y + e.getY() - start.y);
			 }
		});
		
		
	}
}
