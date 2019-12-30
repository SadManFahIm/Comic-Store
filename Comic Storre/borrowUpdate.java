import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class borrowUpdate extends JFrame implements ActionListener
{
	JLabel userLabel;
	JTextField userTF;
	JButton delBtn, backBtn, logoutBtn;
	JPanel panel;
	private ImageIcon img;
	private JLabel imgLabel;
	
	String userId;
	
	public borrowUpdate(String userId)
	{
		super("Borrow Update");
		
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
		
		userLabel = new JLabel("borrow ID : ");
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
		String newId2=newId;
		String query1 = "DELETE from borrowinfo WHERE borrowId='"+newId+"';";
		System.out.println(query1);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m1", "root", "");
			Statement stm = con.createStatement();
			updateInQtn(newId2);
			stm.execute(query1);
			stm.close();
			con.close();
			JOptionPane.showMessageDialog(this, "Success !!!");
			

		}
        catch(Exception ex)
		{
			JOptionPane.showMessageDialog(this, "Oops !!!");
        }
	}
	
	public void loadFromDB(String bookId)
	{
		
		String loadId = bookId;
		String query = "SELECT *  FROM `book` WHERE `bookId`='"+loadId+"';";     
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
			String bName = null;
			String aName = null;
			int pYear = 0;
			int qtn = 0;			
			while(rs.next())
			{
                bName = rs.getString("bookTitle");
				aName = rs.getString("authorName");
				pYear = rs.getInt("publicationYear");
				qtn = rs.getInt("availableQuantity")+1;
				flag=true;
				System.out.println("Jhamela : "+qtn);
				updateInDB2(loadId,bName,aName,pYear,qtn);
				
				
				
			}
			if(!flag)
			{
				
				JOptionPane.showMessageDialog(this,"Invalid ID"); 
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
	
	
	public void updateInQtn(String borrowId)
	{
		String loadId = borrowId;
		String query = "SELECT `bookId`  FROM `borrowinfo` WHERE `borrowId`='"+loadId+"';";     
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
			String newbookId = null;
						
			while(rs.next())
			{
                newbookId = rs.getString("bookId");
				loadFromDB(newbookId);
				
				
				
			}
			if(!flag)
			{
				
				//JOptionPane.showMessageDialog(this,"Invalid ID"); 
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
	
	
	public void updateInDB2(String bookId,String bName,String aName,int pYear,int qtn)
	{
		String newId = bookId;
		String eName = bName;
		String anName = aName;
		int NewYear = pYear;
		int Newqtn=qtn;
		/*try
		{
			newYear = Integer.parseInt(yearTF.getText());
			qtn = Integer.parseInt(qtnTF.getText());
			
		}*/
		//catch(Exception e){}
		String query = "UPDATE book SET bookTitle='"+eName+"', authorName = '"+anName+"', publicationYear = '"+NewYear+"', availableQuantity = "+Newqtn+" WHERE bookId='"+newId+"'";	
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
			//JOptionPane.showMessageDialog(this, "Success !!!");
			
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(this, "Oops !!!");
		}
	}
	
	
}