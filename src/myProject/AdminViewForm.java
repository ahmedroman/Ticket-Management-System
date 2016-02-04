package myProject;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

import Classes.Admin;
import Classes.Book;
import Classes.Main;

public class AdminViewForm extends JFrame implements ActionListener{
	
	static ArrayList<Integer> al = new ArrayList<Integer>();
	
	static JButton logout ;
	static JButton log ;
	static JButton add ;
	static JButton delete ;
	String name ;
	JLabel l1 ;
	String play;
	int ii=0;

	
	public AdminViewForm(){
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		add(panel);
		
		
		
		//first panel
		JPanel regPanel = new JPanel();
		regPanel.setLayout(new BoxLayout(regPanel , BoxLayout.X_AXIS));
		regPanel.setBorder(BorderFactory.createEmptyBorder(15 , 10 , 20 , 10 ));				
		
		log = new JButton("Admin");
		log.addActionListener(this);
		log.setActionCommand("login");
		
		regPanel.add(Box.createRigidArea(new Dimension(150,30)));		
		log.add(Box.createRigidArea(new Dimension(70,15)));
		
		logout = new JButton("Logout");
		logout.add(Box.createRigidArea(new Dimension(70,15)));
		logout.addActionListener(this);
		logout.setActionCommand("logout");		
		
		regPanel.add(Box.createRigidArea(new Dimension(50,0)));
		regPanel.add(log);
		regPanel.add(Box.createRigidArea(new Dimension(10,0)));
		regPanel.add(logout);
		
		panel.add(regPanel);
		
				
		//second panel
		
		JPanel panAdd = new JPanel();
		panAdd.setLayout(new BoxLayout(panAdd, BoxLayout.X_AXIS));
		panAdd.setBorder(BorderFactory.createEmptyBorder(0 , 210 , 30 , 10 ));
		
		add = new JButton("Add");
		add.add(Box.createRigidArea(new Dimension(188,15)));
		add.addActionListener(this);
		add.setActionCommand("add");
		
		panAdd.add(add);
		panel.add(panAdd);
		
		
		//Third panel
		
		JPanel pan2 = null;
		String data ;
		al = Admin.getPid();
		
		for(int i = 0 ; i <al.size() ; i++){
			
			data = Admin.getValuesAdmin(al.get(i));
			//data = "Dhalka/Khulna/BArisal/Raj/KIJ/LIKI/LKIK?LIKJ";
			//System.out.println(data);
			String [] dataArray = data.split("/");
			
			
			pan2 = new JPanel();		
			pan2.setLayout(new BoxLayout(pan2, BoxLayout.X_AXIS));			
			pan2.setBorder(BorderFactory.createMatteBorder(1 , 0 , 0 , 0 ,Color.BLACK));
			pan2.add(Box.createRigidArea(new Dimension(0,100)));
			
			dataArray[0] = dataArray[0].substring(0, 3);
			dataArray[1] = dataArray[1].substring(0, 3);
			l1 = new JLabel("");
			l1.setText(dataArray[0]+"  vs  "+dataArray[1]);
			l1.setFont(new Font("Serif" , Font.PLAIN , 20));
			JLabel l2 = new JLabel();
			l2.setText(dataArray[6]);
			l2.setFont(new Font("Serif" , Font.PLAIN , 20));			
			
			JLabel infoB = new JLabel();
			infoB.setText(dataArray[2]);
			infoB.setFont(new Font("Serif" , Font.PLAIN , 20));
			ii = al.get(i);
			System.out.println(ii);
			delete = new JButton("Delete");	
			delete.addActionListener(this);
			delete.setActionCommand("delete");

			
			//System.out.println(log.getText());
			pan2.add(l1);
			pan2.add(Box.createRigidArea(new Dimension(20,0)));	
			pan2.add(l2);
			pan2.add(Box.createRigidArea(new Dimension(20,0)));
			pan2.add(infoB);
			pan2.add(Box.createRigidArea(new Dimension(10,0)));	
			pan2.add(delete);
			
			panel.add(pan2);
			play = dataArray[0]+" vs "+dataArray[1];
			Book.info(dataArray[3], dataArray[4], dataArray[5], dataArray[2], dataArray[6], play);

		}
		JScrollPane sp = new JScrollPane(panel , ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED , ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		add(sp);
		
		myFrame();
		
	}
	
	
	public void myFrame(){
		
		setSize(500,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		//center of the screen
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		
		
		if(e.getActionCommand().equals("delete")){		
			Admin.deleteValuesAdmin(ii);
			JOptionPane.showMessageDialog(null, "Didnt add this feature");
		}
		
		if(e.getActionCommand().equals("login")){
			if(log.getText().equals("Login")){
				LoginForm l =new LoginForm();
				l.setVisible(true);
			}			
		}
		if(e.getActionCommand().equals("logout")){
			Main.open();
			this.dispose();
		}
		if(e.getActionCommand().equals("add")){
			AddForm af = new AddForm();
		}
		

			
	}
}
