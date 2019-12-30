import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class borrowBook extends JFrame implements ActionListener
{
	JLabel bookId,borrowId,borrowDate,returnDate;
	JTextField bookIdTF,borrowIdTF,borrowDateTF,returnDateTf;
	JButton borrowBtn, backBtn, logoutBtn;
	JPanel panel;
	String userId;
	private ImageIcon img;
	private JLabel imgLabel;
	
	public borrowBook(String userId)
	{
		super("Borrow Book");
		
		this.userId = userId;
		this.setSize(800,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId=userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		logoutBtn = new JButton("Logout");
		logoutBtn.setBounds(600, 50, 100, 30);
		logoutBtn.addActionListener(this);
		panel.add(logoutBtn);
		
		borrowBtn = new JButton("Borrow");
		borrowBtn.setBounds(350, 350, 100, 30);
		borrowBtn.addActionListener(this);
		panel.add(borrowBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(450, 350, 100, 30);
		backBtn.addActionListener(this);
		panel.add(backBtn);
		
		bookId = new JLabel("bookId : ");
		bookId.setBounds(150, 100, 120, 30);
		panel.add(bookId);
	
		bookIdTF = new JTextField();
		bookIdTF.setBounds(400, 100, 120, 30);
		panel.add(bookIdTF);
		
		borrowId = new JLabel("borrowId (b00#) : ");
		borrowId.setBounds(150, 150, 120, 30);
		panel.add(borrowId);
	
		borrowIdTF = new JTextField();
		borrowIdTF.setBounds(400, 150, 120, 30);
		panel.add(borrowIdTF);
		
		borrowDate = new JLabel("borrow Date (January 1,1999) : ");
		borrowDate.setBounds(150, 200, 200, 30);
		panel.add(borrowDate);
	
		borrowDateTF = new JTextField();
		borrowDateTF.setBounds(400, 200, 120, 30);
		panel.add(borrowDateTF);
		
		borrowDate = new JLabel("Return Date (January 1,1999) : ");
		borrowDate.setBounds(150, 250, 200, 30);
		panel.add(borrowDate);
	
		returnDateTf = new JTextField();
		returnDateTf.setBounds(400, 250, 120, 30);
		panel.add(returnDateTf);
		
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
				qtn = rs.getInt("availableQuantity")-1;
				flag=true;
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
	
	
	public void updateInQtn(String bookId)
	{
		    
			loadFromDB(bookId);
			
			
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
	
	
	
	
	
	
	public void updateInDB()
	{
		String newbookIdTF = bookIdTF.getText();
		String newUser = userId;
		String newborrowIdTF = borrowIdTF.getText();
		String newborrowDatetf=borrowDateTF.getText();
		String newreturnDatetf=returnDateTf.getText();
		
		String query = "INSERT INTO borrowinfo VALUES ('"+newborrowIdTF+"','"+newbookIdTF+"','"+newUser+"','"+newborrowDatetf+"','"+newreturnDatetf+"');";	
        Connection con=null;//for connection
        Statement st = null;//for query execution
		System.out.println(query);
        try 
		{
			Class.forName("com.mysql.jdbc.Driver");//load driver
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m1","root","");
			st = con.createStatement();//create statement
			st.executeUpdate(query);
			updateInQtn(newbookIdTF);
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
		
		if(text.equals(borrowBtn.getText()))
			
		{   
                        updateInDB();
                  		//borrowinfo bi = new borrowinfo(userId);
						CustomerHome ch = new CustomerHome(userId);
						//bi.setVisible(true);
						ch.setVisible(true);
						this.setVisible(false);
		
		}
		else if(text.equals(backBtn.getText()))
		{
			CustomerHome ch = new CustomerHome(userId);
						ch.setVisible(true);
						this.setVisible(false);
		}
	}
}