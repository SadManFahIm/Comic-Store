import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class CustomerHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton borrowBtn, changePasswordBtn, viewDetailsBtn, logoutBtn,borrowbook,booklist;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public CustomerHome(String userId)
	{
		super("Customer Home Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(350, 50, 180, 80);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(250, 120, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		viewDetailsBtn = new JButton("My Information");
		viewDetailsBtn.setBounds(50, 120, 150, 30);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
		borrowBtn = new JButton("Borrow Info");
		borrowBtn.setBounds(450, 120, 150, 30);
		borrowBtn.addActionListener(this);
		panel.add(borrowBtn);
		
		borrowbook = new JButton("Borrow Book");
		borrowbook.setBounds(50, 180, 150, 30);
		borrowbook.addActionListener(this);
		panel.add(borrowbook);
		
		booklist = new JButton("Book List");
		booklist.setBounds(250, 180, 150, 30);
		booklist.addActionListener(this);
		panel.add(booklist);
		
		Random rand = new Random();
		int  x = rand.nextInt(5);
		String y= ".jpg";
		String x1 =""+x+".jpg";
		img = new ImageIcon(x1);
		imgLabel = new JLabel(img);
		imgLabel.setBounds(0, 0, 800, 800);
		panel.add(imgLabel);
		
		
		this.add(panel);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
	
		String text = ae.getActionCommand();
		
		if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(changePasswordBtn.getText()))
		{
			ChangePassword cp = new ChangePassword(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewDetailsBtn.getText()))
		{
			    ViewCustomer vc = new ViewCustomer(userId);
				vc.setVisible(true);
				this.setVisible(false);
			
		}
		else if(text.equals(borrowBtn.getText()))
		{
			
			    borrowinfo bi = new borrowinfo(userId);
				bi.setVisible(true);
				this.setVisible(false);
			
		}
		else if(text.equals(borrowbook.getText()))
		{
			
			    borrowBook bi = new borrowBook(userId);
				bi.setVisible(true);
				this.setVisible(false);
			
		}
		else if(text.equals(booklist.getText()))
		{
			
			    booklist bi = new booklist(userId);
				bi.setVisible(true);
				this.setVisible(false);
			
		}
		else{}
	}
	
}