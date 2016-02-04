package myProject;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import Classes.User;

public class RegForm extends JFrame implements ActionListener{
	Color bg = new Color(200,200,200);
	//Font font = new Font("" , Font.BOLD , 10);
	int axisX = BoxLayout.X_AXIS;
	int axisY = BoxLayout.Y_AXIS;
	JTextField tfuName ;
	JPasswordField tfPas ;
	JPasswordField tfPas2 ;
	JTextField tfEmail ;
	JTextField tfNum ;
	
	String name ;
	String pas ;
	String email;
	int num;
	
	public RegForm(){
		
		//main_Panel
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, axisY));
		panel.setBorder(BorderFactory.createMatteBorder(50,0,0,0 ,bg));
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

		tfuName.setMaximumSize(tfuName.getPreferredSize());;
		//tfuName.setPreferredSize(new Dimension(120,30));
		//tfuName.add(Box.createRigidArea(new Dimension(140,0)));
		
		pan1.add(uName);
		pan1.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan1.add(tfuName);
		panel.add(pan1);
		
		//Second Panle
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2 , axisX));
		pan2.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan2.setBackground(bg);
	
		JLabel pas = new JLabel("Password : ");
		pas.setFont(pas.getFont().deriveFont(15.0f));
		tfPas = new JPasswordField(12);
		tfPas.setMaximumSize(tfPas.getPreferredSize());
	
		pan2.add(pas);
		pan2.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan2.add(tfPas);
		panel.add(pan2);
		
		//third Panle
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BoxLayout(pan3 , axisX));
		pan3.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan3.setBackground(bg);
	
		JLabel pas2 = new JLabel("Password : ");
		pas2.setFont(pas2.getFont().deriveFont(15.0f));
		tfPas2 = new JPasswordField(12);
		tfPas2.setMaximumSize(tfPas2.getPreferredSize());
	
		pan3.add(pas2);
		pan3.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan3.add(tfPas2);
		panel.add(pan3);
		
		//Fourth Panle
		JPanel pan4 = new JPanel();
		pan4.setLayout(new BoxLayout(pan4 , axisX));
		pan4.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan4.setBackground(bg);
	
		JLabel email = new JLabel("Email         : ");
		email.setFont(email.getFont().deriveFont(15.0f));
		tfEmail = new JTextField(12);
		tfEmail.setMaximumSize(tfEmail.getPreferredSize());
	
		pan4.add(email);
		pan4.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan4.add(tfEmail);
		panel.add(pan4);
		
		//Fifth Panle
		JPanel pan5 = new JPanel();
		pan5.setLayout(new BoxLayout(pan5 , axisX));
		pan5.setBorder(BorderFactory.createMatteBorder(10,0,10,0 ,bg));
		pan5.setBackground(bg);
	
		JLabel num = new JLabel("Number     : ");
		num.setFont(num.getFont().deriveFont(15.0f));
		tfNum = new JTextField(12);
		tfNum.setMaximumSize(tfNum.getPreferredSize());
	
		pan5.add(num);
		pan5.add(Box.createRigidArea(new Dimension(20 , 0)));
		pan5.add(tfNum);
		panel.add(pan5);
		
		//Sixth Panle
		JPanel pan6 = new JPanel();
		pan6.setLayout(new BoxLayout(pan6 , axisX));
		pan6.setBorder(BorderFactory.createMatteBorder(30,0,0,0 ,bg));
		pan6.setBackground(bg);
		
		JButton cancel = new JButton("Cancel");
		cancel.add(Box.createRigidArea(new Dimension(43,10)));
		cancel.addActionListener(this);
		cancel.setActionCommand("cancel");
		JButton login = new JButton("Sign Up");
		login.add(Box.createRigidArea(new Dimension(43,10)));
		login.addActionListener(this);
		login.setActionCommand("reg");
		
		
		pan6.add(Box.createRigidArea(new Dimension(90 , 0)));
		pan6.add(cancel);
		pan6.add(Box.createRigidArea(new Dimension(5 , 0)));
		pan6.add(login);

		panel.add(pan6);
		
		form();
		
	}
	
	public void form(){
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBackground(bg);
		setSize(300,360);
		setLocation(604, 120);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("cancel")){
			this.dispose();		
		}
		if(e.getActionCommand().equals("reg")){
			num = Integer.parseInt(tfNum.getText());
			
			if(tfPas2.getText().equals(tfPas.getText())){				
				try {
					this.dispose();
					User.insertUser(tfuName.getText(),tfPas.getText(), tfEmail.getText(),num );
					JOptionPane.showMessageDialog(null , "Success...\nYou can login now\nEnjoy!!!");
				} catch (SQLException e1) {				
					e1.printStackTrace();
				}catch(Exception en){
					JOptionPane.showMessageDialog(null, "Enter a valid number");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Password didnt match");
			}

		}
		
	}

}
