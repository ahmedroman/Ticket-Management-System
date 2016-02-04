package myProject;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;

import Classes.Admin;

public class AddForm extends JFrame implements ActionListener{
	Color bg = new Color(200,200,200);
	int axisX = BoxLayout.X_AXIS;
	int axisY = BoxLayout.Y_AXIS;
	//String[] country = new String[4];
	//String[] stedium = new String[4];
	String[] country = {"BANGLADESH" , "INDIA" , "PAKISTAN" ,"SRILANKA"};
	String[] stedium = {"MIRPUR" , "CTGONG" , "KHULNA" ,"SYLHET"};

	JComboBox com1 ;
	JComboBox com2 ;
	JComboBox com3 ;
	JTextField tfVip ;
	JTextField tfGalery ;
	JTextField tfSta ;
	JTextField tfDate ;
	JTextField tfMnth ;
	JTextField tfYear ;
	String con1;
	String con2;
	String ste;
	int vip;
	int gal;
	int stand;
	String date;
	
	public AddForm(){
		

		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel , axisY));
		panel.setBorder(BorderFactory.createEmptyBorder(20,20,30,20));
		panel.setBackground(bg);
		add(panel);
		
		//first Panel
		
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan , axisX));
		pan.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
		pan.setBackground(bg);
		
		JLabel lSteduim = new JLabel("Steduim");
		lSteduim.setFont(lSteduim.getFont().deriveFont(14.0f));
		JLabel lVip = new JLabel("VIP");
		lVip.setFont(lVip.getFont().deriveFont(14.0f));
		JLabel lGalery = new JLabel("Gallery");
		lGalery.setFont(lGalery.getFont().deriveFont(14.0f));
		JLabel lStand = new JLabel("Stand");
		lStand.setFont(lStand.getFont().deriveFont(14.0f));
		JLabel lDate = new JLabel("Date");
		lDate.setFont(lDate.getFont().deriveFont(14.0f));
		
		pan.add(Box.createRigidArea(new Dimension(210, 0)));
		pan.add(lSteduim);
		pan.add(Box.createRigidArea(new Dimension(60, 0)));
		pan.add(lVip);
		pan.add(Box.createRigidArea(new Dimension(35, 0)));
		pan.add(lGalery);
		pan.add(Box.createRigidArea(new Dimension(20,0)));
		pan.add(lStand);
		pan.add(Box.createRigidArea(new Dimension(30,0)));
		pan.add(lDate);
		panel.add(pan);
		
		//second Panel
		
		JPanel pan1 = new JPanel();
		pan1.setLayout(new BoxLayout(pan1 , axisX));
		pan1.setBackground(bg);
		
		com1 = new JComboBox(country);
		JLabel l1 = new JLabel("VS");
		
		com2 = new JComboBox(country);
		com3 = new JComboBox(stedium);
		tfVip = new JTextField(5);
		tfVip.setMaximumSize(tfVip.getPreferredSize());
		tfGalery = new JTextField(5);
		tfGalery.setMaximumSize(tfGalery.getPreferredSize());
		tfSta = new JTextField(5);
		tfSta.setMaximumSize(tfSta.getPreferredSize());
		//date
		tfDate = new JTextField(2);
		tfDate.setMaximumSize(tfDate.getPreferredSize());
		tfDate.setText("D");
		tfMnth = new JTextField(2);
		tfMnth.setMaximumSize(tfMnth.getPreferredSize());
		tfMnth.setText("M");
		tfYear = new JTextField(4);
		tfYear.setMaximumSize(tfYear.getPreferredSize());
		tfYear.setText("Y");	
		
		pan1.add(com1);
		pan1.add(Box.createRigidArea(new Dimension(15, 0)));
		pan1.add(l1);
		pan1.add(Box.createRigidArea(new Dimension(15, 0)));
		pan1.add(com2);
		pan1.add(Box.createRigidArea(new Dimension(15, 0)));
		pan1.add(com3);
		pan1.add(Box.createRigidArea(new Dimension(15, 0)));
		pan1.add(tfVip);
		pan1.add(Box.createRigidArea(new Dimension(15, 0)));
		pan1.add(tfGalery);
		pan1.add(Box.createRigidArea(new Dimension(15, 0)));
		pan1.add(tfSta);
		
		pan1.add(Box.createRigidArea(new Dimension(20, 0)));
		pan1.add(tfDate);
		pan1.add(Box.createRigidArea(new Dimension(5, 0)));
		pan1.add(tfMnth);
		pan1.add(Box.createRigidArea(new Dimension(5, 0)));
		pan1.add(tfYear);
		panel.add(pan1);
		
		//panel button
		JPanel pan2 = new JPanel();
		pan2.setLayout(new BoxLayout(pan2, BoxLayout.LINE_AXIS));
		pan2.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));
		pan2.setBackground(bg);
		
		JButton add = new JButton("Add");
		add.add(Box.createRigidArea(new Dimension(40,10)));
		add.addActionListener(this);
		add.setActionCommand("add");
		
		JButton cancel = new JButton("Cancel");
		cancel.add(Box.createRigidArea(new Dimension(40,10)));
		cancel.addActionListener(this);
		cancel.setActionCommand("cancel");
		
		pan2.add(Box.createRigidArea(new Dimension(390, 0)));
		pan2.add(cancel);
		pan2.add(Box.createRigidArea(new Dimension(10,40)));
		pan2.add(add);
		pan2.add(Box.createRigidArea(new Dimension(0, 30)));
		
		panel.add(pan2);
		form();
		
	}
	
	public void form(){
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setLocation(600,400);
		setSize(750 ,200);
		//center of the screen
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		int x = (screenSize.width - getWidth()) / 2;
		int y = (screenSize.height - getHeight()) / 2;
		setLocation(x, y);
		setVisible(true);				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("cancel")){
			this.dispose();		
		}
		if(e.getActionCommand().equals("add")){
			try{
				String y = tfYear.getText();
				String m = tfMnth.getText();
				String d = tfDate.getText();				
				con1 = country[com1.getSelectedIndex()];
				con2 = country[com2.getSelectedIndex()];
				ste = stedium[com3.getSelectedIndex()];
				vip = Integer.parseInt(tfVip.getText());
				gal = Integer.parseInt(tfGalery.getText());
				stand = Integer.parseInt(tfSta.getText());
				date = y+"-"+m+"-"+d;
				if(Integer.parseInt(y)==0||Integer.parseInt(m)==0||Integer.parseInt(d)==0){
					JOptionPane.showMessageDialog(null, "Not valid");				
				}
				else{
					this.dispose();
					
					JOptionPane.showMessageDialog(null, "Added");
					if(con1.equals(con2)){
											
					}else{
						try {
							Admin.addByAdmin(con1,con2,ste,vip,gal,stand,date);
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Not valid");
						}
					}
				}
	
			}catch(Exception es){
				JOptionPane.showMessageDialog(null, "Not valid");
			}
				
		}
		
	}

	
}
