import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class EmployeeHome extends JFrame implements ActionListener
{
	JLabel welcomeLabel;
	JButton manageEmployeeBtn, changePasswordBtn, viewDetailsBtn, logoutBtn;
	JPanel panel;
	String userId,role;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public EmployeeHome(String userId)
	{
		super("Employee Home Window");
		
		this.userId = userId;
		this.setSize(800,450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		welcomeLabel = new JLabel("Welcome, "+userId);
		welcomeLabel.setBounds(350, 50, 130, 50);
		panel.add(welcomeLabel);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		changePasswordBtn = new JButton("Change Password");
		changePasswordBtn.setBounds(50, 120, 150, 30);
		changePasswordBtn.addActionListener(this);
		panel.add(changePasswordBtn);
		
		manageEmployeeBtn = new JButton("Manage Employee");
		manageEmployeeBtn.setBounds(220, 120, 150, 30);
		manageEmployeeBtn.addActionListener(this);
		panel.add(manageEmployeeBtn);
		
		viewDetailsBtn = new JButton("My Information");
		viewDetailsBtn.setBounds(400, 120, 150, 30);
		viewDetailsBtn.addActionListener(this);
		panel.add(viewDetailsBtn);
		
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
	
	public void Checkrole()
	{
		    String query = "SELECT `role` FROM `employee` WHERE `userId`='"+userId+"';"; 
            Connection con=null;//for connection
            Statement st = null;//for query execution
		    ResultSet rs = null;//to get row by row result from DB
		    System.out.println(query);
            try
		    {
			Class.forName("com.mysql.jdbc.Driver");//load driver
			System.out.println("driver loaded");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m1","root","");
			System.out.println("connection done");//connection with database established
			st = con.createStatement();//create statement
			System.out.println("statement created");
			rs = st.executeQuery(query);//getting result
			System.out.println("results received");
			while(rs.next())
			{
			System.out.println("age");
			role = rs.getString("role");
			System.out.println("Role : "+role);
			}
			
			if(role.equals("Manager"))
			{
				ManageEmployee me = new ManageEmployee(userId);
				me.setVisible(true);
				this.setVisible(false);
			}
			
			
			else{
				ManageEmployee2 me = new ManageEmployee2(userId);
				me.setVisible(true);
				this.setVisible(false);
			}
			
			}
			
			
			catch(Exception ex)
		    {
			System.out.println("Exception : " +ex.getMessage());
            }
			
	
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
			ChangePassword2 cp = new ChangePassword2(userId);
			cp.setVisible(true);
			this.setVisible(false);
		}
		
		else if(text.equals(manageEmployeeBtn.getText()))
		{
			Checkrole();
			
			
			}
				
			
		else if(text.equals(viewDetailsBtn.getText()))
		{
			
				MyInfo me = new MyInfo(userId);
				me.setVisible(true);
				this.setVisible(false);
			
		}
		else{}
	}
	
}