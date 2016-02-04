package myProject;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Classes.Main;
import Classes.User;

public class LoginForm extends JFrame implements ActionListener{
	Color bg = new Color(200 , 200 , 200);
	static JTextField tfUser ;
	JPasswordField tfPas ;
	JButton login ;
	JButton cancel ;
	
	
	public LoginForm(){
		from();
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBorder(BorderFactory.createMatteBorder(30,20,20,20 ,bg));
		panel.setBackground(bg);
		
		add(panel);
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BoxLayout(pan1, BoxLayout.X_AXIS));
		pan1.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		pan1.setBackground(bg);
		
		JLabel user = new JLabel("Username   : ");
		user.setFont(user.getFont().deriveFont(15.0f));
		tfUser = new JTextField(15);
		tfUser.setMaximumSize( tfUser.getPreferredSize());
		
		pan1.add(user);
		pan1.add(Box.createRigidArea(new Dimension(20,0)));
		pan1.add(tfUser);
		
		panel.add(pan1);
		
		//panel pass
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2, BoxLayout.X_AXIS));
		pan2.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		pan2.setBackground(bg);
		
		JLabel pas = new JLabel("Password   : ");
		pas.setFont(pas.getFont().deriveFont(15.0f));
		tfPas = new JPasswordField(15);
		tfPas.setMaximumSize(tfPas.getPreferredSize());
		
		pan2.add(pas);
		pan2.add(Box.createRigidArea(new Dimension(20,0)));
		pan2.add(tfPas);
		
		panel.add(pan2);
		
		//panel button
		JPanel pan3 = new JPanel();
		pan3.setLayout(new BoxLayout(pan3, BoxLayout.X_AXIS));
		pan3.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		pan3.setBackground(bg);
		
		login = new JButton("Login");
		login.add(Box.createRigidArea(new Dimension(40,10)));
		login.addActionListener(this);
		login.setActionCommand("login");
		
		cancel = new JButton("Cancel");
		cancel.add(Box.createRigidArea(new Dimension(40,10)));
		cancel.addActionListener(this);
		cancel.setActionCommand("cancel");
		
		pan3.add(Box.createRigidArea(new Dimension(90, 0)));
		pan3.add(cancel);
		pan3.add(Box.createRigidArea(new Dimension(5,40)));
		pan3.add(login);

		
		
		
		panel.add(pan3);
		
		
	}
	
	public void from(){
		//setLayout(new FlowLayout());
		//setBackground(bg);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setSize(300,160);
		setLocation(604, 120);
		setUndecorated(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	}

	private static String name;
	public static String getNam(){
		return name;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("cancel")){
			this.dispose();			
		}		
		int c = User.match(tfUser.getText() , tfPas.getText());
		if(e.getActionCommand().equals("login")){
			if(tfUser.getText().equals("Admin") && tfPas.getText().equals("1234")){
				this.dispose();	
				//name = tfUser.getText();
				//View.bHideReg();
				//View v = new View();
				View v = Main.close();
				v.dispose();
				AdminViewForm avf =  new AdminViewForm();
				
			}
			//int c = 
			else if(c==1){
				this.dispose();
				name = tfUser.getText();
				View.bHideLog();	
			}
			else {
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
			}
				
		}
		
	}
	
}
