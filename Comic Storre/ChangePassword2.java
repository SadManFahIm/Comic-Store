import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class ChangePassword2 extends JFrame implements ActionListener
{
	JLabel oldPassLabel, newPassLabel;
	JTextField oldPassTF, newPassTF;
	JButton changeBtn, backBtn, logoutBtn;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public ChangePassword2(String userId)
	{
		super("Change Password Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId=userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changeBtn = new JButton("Save");
		changeBtn.setBounds(350, 250, 100, 30);
		changeBtn.addActionListener(this);
		panel.add(changeBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(300, 50, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		oldPassLabel = new JLabel("old Password : ");
		oldPassLabel.setBounds(250, 100, 120, 30);
		panel.add(oldPassLabel);
		
		newPassLabel = new JLabel("New Password : ");
		newPassLabel.setBounds(250, 150, 120, 30);
		panel.add(newPassLabel);
		
		oldPassTF = new JTextField();
		oldPassTF.setBounds(400, 100, 120, 30);
		panel.add(oldPassTF);
		
		newPassTF = new JTextField();
		newPassTF.setBounds(400, 150, 120, 30);
		panel.add(newPassTF);
		
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
	public void updateInDB()
	{
		String newPass = newPassTF.getText();
		String newUser = userId;
		
		String query = "UPDATE login SET password='"+newPass+"' WHERE userId='"+newUser+"'";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m1","root","");
			st = con.createStatement();//create statement
			st.executeUpdate(query);
			st.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		String text = ae.getActionCommand();
		
		if(text.equals(changeBtn.getText()))
		{
		updateInDB();
		    Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		
		}
		else if(text.equals(backBtn.getText()))
		{
			EmployeeHome ch = new EmployeeHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
		}
	}
}