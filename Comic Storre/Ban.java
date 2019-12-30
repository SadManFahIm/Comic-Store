import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Ban extends JFrame implements ActionListener
{
	JLabel userLabel;
	JTextField userTF;
	JButton delBtn, backBtn, logoutBtn;
	JPanel panel;
	private ImageIcon img;
	private JLabel imgLabel;
	
	String userId;
	
	public Ban(String userId)
	{
		super("Ban");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId = userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 70, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 70, 120, 30);
		panel.add(userTF);
		
		delBtn = new JButton("Delete");
		delBtn.setBounds(350, 400, 120, 30);
		delBtn.addActionListener(this);
		panel.add(delBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(500, 400, 120, 30);
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
			ManageEmployee2 me = new ManageEmployee2(userId);
			me.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(logoutBtn.getText()))
		{
			Login lg = new Login();
			lg.setVisible(true);
			this.setVisible(false);
		}
		else if(text.equals(delBtn.getText()))
		{
			
			deleteFromDB();
			ManageEmployee2 l = new ManageEmployee2(userId);
			l.setVisible(true);
			this.setVisible(false);
		
		}
		else{}
	}
		public void deleteFromDB()
	{
		String newId = userTF.getText();
		String query1 = "DELETE from customer WHERE userId='"+newId+"';";
		String query2 = "DELETE from login WHERE userId='"+newId+"';";
		System.out.println(query1);
		System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m1", "root", "");
			Statement stm = con.createStatement();
			stm.execute(query1);
			stm.execute(query2);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			

		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
}