import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class AddCustomer extends JFrame implements ActionListener
{
	JLabel userLabel, passLabel, eNameLabel, phoneLabel, addressLabel, salaryLabel;
	JTextField userTF, passTF, phoneTF1, phoneTF2, eNameTF,addressTF;
	JButton  addBtn, backBtn;
	JPanel panel;
	private ImageIcon img;
	private JLabel imgLabel;
	
	String userId;
	
	public AddCustomer()
	{
		super("Add New Member");
		
		this.setSize(800, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		
		userLabel = new JLabel("User ID : ");
		userLabel.setBounds(250, 100, 120, 30);
		panel.add(userLabel);
		
		userTF = new JTextField();
		userTF.setBounds(400, 100, 120, 30);
		panel.add(userTF);
		
		passLabel = new JLabel("Password : ");
		passLabel.setBounds(250, 150, 120, 30);
		panel.add(passLabel);
		
		passTF = new JTextField();
		passTF.setBounds(400, 150, 120, 30);
		panel.add(passTF);
		
		
		eNameLabel = new JLabel("Customer Name : ");
		eNameLabel.setBounds(250, 200, 120, 30);
		panel.add(eNameLabel);
		
		eNameTF = new JTextField();
		eNameTF.setBounds(400, 200, 120, 30);
		panel.add(eNameTF);
		
		phoneLabel = new JLabel("Phone No. : ");
		phoneLabel.setBounds(250, 250, 120, 30);
		panel.add(phoneLabel);
		
		phoneTF1 = new JTextField("+880");
		phoneTF1.setBounds(400, 250, 35, 30);
		phoneTF1.setEnabled(false);
		phoneTF1.setForeground(Color.BLACK);
		panel.add(phoneTF1);
		
		phoneTF2 = new JTextField();
		phoneTF2.setBounds(435, 250, 85, 30);
		panel.add(phoneTF2);
		
		addressLabel = new JLabel("Address : ");
		addressLabel.setBounds(250, 300, 120, 30);
		panel.add(addressLabel);
		
		addressTF = new JTextField();
		addressTF.setBounds(400, 300, 120, 30);
		panel.add(addressTF);
		
		addBtn = new JButton("Sign");
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
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}

		else if(text.equals(addBtn.getText()))
		{
			insertIntoDB();
			Login l = new Login();
			l.setVisible(true);
			this.setVisible(false);
		}
		else{}
	}
		public void insertIntoDB()
	{
		String newId = userTF.getText();
		String newPass = passTF.getText();
		String eName = eNameTF.getText();
		String phnNo = phoneTF1.getText()+phoneTF2.getText();
		String address = addressTF.getText();
		int status = 1;
		
		
		String query1 = "INSERT INTO customer VALUES ('"+newId+"','"+eName+"','"+ phnNo+"','"+address+"');";
		String query2 = "INSERT INTO login VALUES ('"+newId+"','"+newPass+"',"+status+");";
		System.out.println(query1);
		System.out.println(query2);
        try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/m1", "root", "");
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