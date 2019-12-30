import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class bookEntry extends JFrame implements ActionListener
{
	JLabel userLabel, titleLabel, aNameLabel, yearLabel, qtnLabel;
	JTextField userTF, titleTF, yearTF, aNameTF,qtnTF;
	JButton  addBtn, backBtn;
	JPanel panel;
	private ImageIcon img;
	private JLabel imgLabel;
	
	String userId;
	
	public bookEntry(String userId)
	{
		super("Add New Book");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.userId=userId;
		
		panel = new JPanel();
		panel.setLayout(null);
		
		userLabel = new JLabel("Book ID : ");
		userLabel.setBounds(250, 100, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 100, 120, 30);
		panel.add(userTF);
		
		titleLabel = new JLabel("Book Name : ");
		titleLabel.setBounds(250, 150, 120, 30);
		panel.add(titleLabel);
		
		titleTF = new JTextField();
		titleTF.setBounds(400, 150, 120, 30);
		panel.add(titleTF);
		
		
		aNameLabel = new JLabel("Author Name : ");
		aNameLabel.setBounds(250, 200, 120, 30);
		panel.add(aNameLabel);
		
		aNameTF = new JTextField();
		aNameTF.setBounds(400, 200, 120, 30);
		panel.add(aNameTF);
		
		yearLabel = new JLabel("P.Year : ");
		yearLabel.setBounds(250, 250, 120, 30);
		panel.add(yearLabel);
		
		yearTF = new JTextField();
		yearTF.setBounds(400, 250, 120, 30);
		panel.add(yearTF);
		
		qtnLabel = new JLabel("Quantity : ");
		qtnLabel.setBounds(250, 300, 120, 30);
		panel.add(qtnLabel);
		
		qtnTF = new JTextField();
		qtnTF.setBounds(400, 300, 120, 30);
		panel.add(qtnTF);
		
		addBtn = new JButton("Add");
		addBtn.setBounds(250, 400, 120, 30);
		addBtn.addActionListener(this);
		panel.add(addBtn);
		
		backBtn = new JButton("Back");
		backBtn.setBounds(400, 400, 120, 30);
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

		else if(text.equals(addBtn.getText()))
		{
			insertIntoDB();
			bookEntry me = new bookEntry(userId);
			me.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
		public void insertIntoDB()
	{
		String newId = userTF.getText();
		String newTitle = titleTF.getText();
		String newaName = aNameTF.getText();
		String newYear = yearTF.getText();
		String newQtn = qtnTF.getText();
		
		
		String query1 = "INSERT INTO book VALUES ('"+newId+"','"+newTitle+"','"+ newaName+"','"+newYear+"','"+newQtn+"');";
		System.out.println(query1);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/m1", "root", "");
			Statement stm = con.createStatement();
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
}