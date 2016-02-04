package myProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.mysql.jdbc.log.Log;

import Classes.Book;

public class MoreInfo  extends JFrame implements ActionListener{
	Color bg = new Color(200,200,200);
	//Font font = new Font("" , Font.BOLD , 10);
	int axisX = BoxLayout.X_AXIS;
	int axisY = BoxLayout.Y_AXIS;
	JTextField tfuName ;
	JTextField tfPas ;
	JTextField tfPas2 ;
	JTextField tfEmail ;
	JTextField tfNum ;
	JTextField tfgal ;
	JTextField tfstnd ;
	JTextField tfdate ;
	
	String uname;
	int vipTkt ;
	int galTkt ;
	int standTkt ;
	String stedium ;
	String date ; 
	String play ;
	
	
	public MoreInfo(String name){
		String info = Book.getInfo();
		String [] infoArr = info.split("/");
		//main_Panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, axisY));
		panel.setBorder(BorderFactory.createMatteBorder(30,0,0,0 ,bg));
		panel.setBackground(bg);
		add(panel);
		
		//first_Panel
		JPanel pan1 = new JPanel();
		pan1.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		//pan1.setPreferredSize(new Dimension(100,400));
		pan1.setLayout(new BoxLayout(pan1 , axisX));
		pan1.setBackground(bg);
		
		JLabel uName = new JLabel("Username : ");
		uName.setFont(uName.getFont().deriveFont(15.0f));
		tfuName = new JTextField(12);
		
		tfuName.setMaximumSize(tfuName.getPreferredSize());
		tfuName.setText(name);
		
		
		pan1.add(uName);
		pan1.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan1.add(tfuName);
		panel.add(pan1);
		
		//Second Panle
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2 , axisX));
		pan2.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan2.setBackground(bg);
	
		JLabel pas = new JLabel("Play           : ");
		pas.setFont(pas.getFont().deriveFont(15.0f));
		tfPas = new JTextField(12);
		tfPas.setMaximumSize(tfPas.getPreferredSize());
		tfPas.setText(infoArr[5]);
	
		pan2.add(pas);
		pan2.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan2.add(tfPas);
		panel.add(pan2);
		
		//third Panle Stedium
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BoxLayout(pan3 , axisX));
		pan3.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan3.setBackground(bg);
	
		JLabel pas2 = new JLabel("Stedium    : ");
		pas2.setFont(pas2.getFont().deriveFont(15.0f));
		tfPas2 = new JTextField(12);
		tfPas2.setMaximumSize(tfPas2.getPreferredSize());
		tfPas2.setText(infoArr[3]);
		
		System.out.println(info);
		pan3.add(pas2);
		pan3.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan3.add(tfPas2);
		panel.add(pan3);
		
		//Fourth Panle VIp
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BoxLayout(pan4 , axisX));
		pan4.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan4.setBackground(bg);
	
		JLabel email = new JLabel("Vip             : ");
		email.setFont(email.getFont().deriveFont(15.0f));
		tfEmail = new JTextField(12);
		tfEmail.setMaximumSize(tfEmail.getPreferredSize());
		tfEmail.setText("0");
		
		pan4.add(email);
		pan4.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan4.add(tfEmail);
		panel.add(pan4);
		

		
		
		//Fifth A Panle gallery
		JPanel pan5a = new JPanel();
		pan5a.setLayout(new BoxLayout(pan5a , axisX));
		pan5a.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan5a.setBackground(bg);
	
		JLabel gal = new JLabel("Gallery      : ");
		gal.setFont(gal.getFont().deriveFont(15.0f));
		tfgal = new JTextField(12);
		tfgal.setMaximumSize(tfgal.getPreferredSize());
		tfgal.setText("0");
	
		pan5a.add(gal);
		pan5a.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan5a.add(tfgal);
		panel.add(pan5a);
		
		
		//Fifth b Panle Stand
		JPanel pan5b = new JPanel();
		pan5b.setLayout(new BoxLayout(pan5b , axisX));
		pan5b.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan5b.setBackground(bg);
	
		JLabel stnd = new JLabel("Stand        : ");
		stnd.setFont(stnd.getFont().deriveFont(15.0f));
		tfstnd = new JTextField(12);
		tfstnd.setMaximumSize(tfstnd.getPreferredSize());
		tfstnd.setText("0");
	
		pan5b.add(stnd);
		pan5b.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan5b.add(tfstnd);
		panel.add(pan5b);
		
	
		//Fifth c Panle Date
		JPanel pan5c = new JPanel();
		pan5c.setLayout(new BoxLayout(pan5c , axisX));
		pan5c.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan5c.setBackground(bg);
	
		JLabel datel = new JLabel("Date         : ");
		datel.setFont(datel.getFont().deriveFont(15.0f));
		tfdate = new JTextField(12);
		tfdate.setMaximumSize(tfstnd.getPreferredSize());
		tfdate.setText(infoArr[4]);
	
		pan5c.add(datel);
		pan5c.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan5c.add(tfdate);
		panel.add(pan5c);
	
		
		//Sixth Panle
		JPanel pan6 = new JPanel();
		pan6.setLayout(new BoxLayout(pan6 , axisX));
		pan6.setBorder(BorderFactory.createMatteBorder(10,0,0,0 ,bg));
		pan6.setBackground(bg);
		
		JButton cancel = new JButton("Cancel");
		cancel.add(Box.createRigidArea(new Dimension(43,10)));
		cancel.addActionListener(this);
		cancel.setActionCommand("cancel");
		
		JButton book = new JButton("Book");
		book.add(Box.createRigidArea(new Dimension(43,10)));
		book.addActionListener(this);
		book.setActionCommand("book");
		
		
		pan6.add(Box.createRigidArea(new Dimension(90 , 0)));
		pan6.add(cancel);
		pan6.add(Box.createRigidArea(new Dimension(5 , 0)));
		pan6.add(book);

		panel.add(pan6);
		

		System.out.println(galTkt);
		form();
		
	}
	
	public void form(){
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBackground(bg);
		setSize(300,380);
		setLocation(604, 200);
		setVisible(true);
		
	}		
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("cancel")){
			this.dispose();
		}
		if(e.getActionCommand().equals("book")){
			this.dispose();
			try {
				
				uname = tfuName.getText();
				vipTkt = Integer.parseInt(tfEmail.getText()); 
				galTkt = Integer.parseInt(tfgal.getText());
				standTkt = Integer.parseInt(tfstnd.getText());
				stedium = tfPas2.getText();
				date = tfdate.getText();
				play = tfPas.getText();
				int price = vipTkt*1000 + galTkt*200 + standTkt*100;
				
				//System.out.println(uname+vipTkt+galTkt+standTkt+stedium+date+play);
				Book.book(uname,vipTkt,galTkt,standTkt,price,stedium,date,play);
				JOptionPane.showMessageDialog(null , "Total Price: "+price);
			} catch (SQLException e1) {				
				e1.printStackTrace();
			}
		}
		
	}
	
}
