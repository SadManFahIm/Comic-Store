import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Login extends JFrame implements ActionListener
{
	JLabel title,signup1,signup2, userLabel, passLabel;
	JTextField userTF;
	JPasswordField passPF;
	JButton loginBtn, exitBtn,signupBtn;
	JPanel panel;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public Login()
	{
		super("Login Window");
		
		this.setSize(800, 450);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		title = new JLabel("The Comic Store");
		title.setBounds(350, 50, 350, 30);
		panel.add(title);
		
		
		signup1 = new JLabel("Are you new member? Click " );
		signup1.setBounds(200,280,360,80);
		panel.add(signup1);
		
		signupBtn = new JButton("SignUp");
		signupBtn.setBounds(365, 311, 80, 15);
		signupBtn.addActionListener(this);
		panel.add(signupBtn);
		
		signup2 = new JLabel("For Joining With us" );
		signup2.setBounds(450,280,360,80);
		panel.add(signup2);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(300, 100, 60, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(370, 100, 100, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(300, 150, 70, 30);
		panel.add(passLabel);
		
		passPF = new JPasswordField();
		passPF.setBounds(370, 150, 100, 30);
		panel.add(passPF);
		
		loginBtn = new JButton("Login");
		loginBtn.setBounds(300, 200, 80, 30);
		loginBtn.addActionListener(this);
		panel.add(loginBtn);
		
		
		exitBtn = new JButton("Exit");
		exitBtn.setBounds(390, 200, 80, 30);
		exitBtn.addActionListener(this);
		panel.add(exitBtn);
		
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
		
		if(text.equals(loginBtn.getText()))
		{
			checkLogin();
		}
		else if(text.equals(signupBtn.getText()))
		{
			            AddCustomer ch = new AddCustomer();
						ch.setVisible(true);
						this.setVisible(false);
		}
		else if(text.equals(exitBtn.getText()))
		{
			System.exit(0);
		}
		else{}
	}
	
	public void checkLogin()
	{
		String query = "SELECT `userId`, `password`, `status` FROM `login`;"; 
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
			
			boolean flag = false;			
			while(rs.next())
			{
                String userId = rs.getString("userId");
                String password = rs.getString("password");
				int status = rs.getInt("status");
				
				if(userId.equals(userTF.getText()) && password.equals(passPF.getText()))
				{
					flag=true;
					if(status==0)
					{
						EmployeeHome eh = new EmployeeHome(userId);
						eh.setVisible(true);
						this.setVisible(false);
					}
					else if(status==1)
					{
						CustomerHome ch = new CustomerHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
					}
					
					else{}
				}
			}
			if(!flag)
			{
				JOptionPane.showMessageDialog(this,"Invalid ID or Password"); 
			}
		}
        catch(Exception ex)
		{
			System.out.println("Exception : " +ex.getMessage());
        }
        finally
		{
            try
			{
                if(rs!=null)
					rs.close();

                if(st!=null)
					st.close();

                if(con!=null)
					con.close();
            }
            catch(Exception ex){}
        }
	}
}