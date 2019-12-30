import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ManageEmployee2 extends JFrame implements ActionListener
{
	JButton BanBtn, BookUpdateBtn, backBtn, logoutBtn,viewCustomerBtn,viewallCustomerBtn,bookEntryBtn,bookBtn,borrowBtn;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public ManageEmployee2(String userId)
	{
		super("Manage Employee Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		BanBtn = new JButton("Ban Member");
		BanBtn.setBounds(50, 120, 150, 30);
		BanBtn.addActionListener(this);
		panel.add(BanBtn);
		
		BookUpdateBtn = new JButton("Book Update");
		BookUpdateBtn.setBounds(220, 120, 150, 30);
		BookUpdateBtn.addActionListener(this);
		panel.add(BookUpdateBtn);
		
		viewCustomerBtn = new JButton("View Customer");
		viewCustomerBtn.setBounds(400, 120, 150, 30);
		viewCustomerBtn.addActionListener(this);
		panel.add(viewCustomerBtn);
		
		viewallCustomerBtn = new JButton("Customer List");
		viewallCustomerBtn.setBounds(50, 180, 150, 30);
		viewallCustomerBtn.addActionListener(this);
		panel.add(viewallCustomerBtn);
		
		bookEntryBtn = new JButton("Book Entry");
		bookEntryBtn.setBounds(220, 180, 150, 30);
		bookEntryBtn.addActionListener(this);
		panel.add(bookEntryBtn);
		
		bookBtn = new JButton("Book List");
		bookBtn.setBounds(400, 180, 150, 30);
		bookBtn.addActionListener(this);
		panel.add(bookBtn);
		
		borrowBtn = new JButton("Borrow Update");
		borrowBtn.setBounds(50, 240, 150, 30);
		borrowBtn.addActionListener(this);
		panel.add(borrowBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(220, 240, 150, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
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
		
		if(text.equals(backBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(userId);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(BanBtn.getText()))
		{
			Ban ve = new Ban(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(BookUpdateBtn.getText()))
		{
			BookUpdate bu = new BookUpdate(userId);
			bu.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewCustomerBtn.getText()))
		{
			ViewCustomer3 ve = new ViewCustomer3(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(viewallCustomerBtn.getText()))
		{
			CustomerList2 ve = new CustomerList2(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(bookEntryBtn.getText()))
		{
			bookEntry ve = new bookEntry(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(bookBtn.getText()))
		{
			booklist2 ve = new booklist2(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(borrowBtn.getText()))
		{
			borrowUpdate ve = new borrowUpdate(userId);
			ve.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
}