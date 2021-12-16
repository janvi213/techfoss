package ehub;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

@SuppressWarnings("serial")
public class empdetails extends JFrame {
	private static Border brd;
	
	java.sql.Connection conn = null;
	empdetails(){
		conn=postconnection.dbconnector();
		JFrame f =new JFrame("Employee details");
		f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        
        JTextField empid;
    	JTextField fname;
        JTextField lname;
        JTextField qual;
    	JTextField spcl;
        JTextField dateofj;
    	
      //icon
      		Image icon = Toolkit.getDefaultToolkit().getImage("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg");
      		f.setIconImage(icon);
      		
      		JLabel name= new JLabel("TECHFOSS");
    		name.setBounds(650,15,350,40);
    	    name.setFont(new Font("Eras Bold ITC",Font.BOLD,50));
    		f.add(name);
    		
    		JLabel logo= new JLabel();
            ImageIcon imageIcon = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\techfoss.jpeg").getImage().getScaledInstance(50, 50, 3));
            logo.setBorder(brd);
            logo.setIcon(imageIcon);
        	logo.setBounds(590,2,75,75);
    		f.add(logo);
    		
    		JLabel help= new JLabel("help");
    		help.setBounds(1300,15,350,40);
    	    help.setFont(new Font("Eras ITC",Font.ITALIC,20));
    		f.add(help);
    		
    		JLabel contact= new JLabel("Contact us");
    		contact.setBounds(1400,15,350,40);
    	    contact.setFont(new Font("Eras ITC",Font.ITALIC,20));
    		f.add(contact);
    		
    		JPanel panela = new JPanel();
			panela.setLayout(null);
			panela.setBounds(0,200,1600,1600);
			panela.setBackground(new Color(0, 89, 100));
			f.add(panela);
			

			/*JButton home = new JButton("HOME");
			f.add(home);
			home.setBounds(10,10,130,50);
			ImageIcon i3 = new ImageIcon(new ImageIcon("file:///C:/Users/Advait.edu/eclipse-workspace/TechFoss/src/Home%20logo.jpeg").getImage().getScaledInstance(10, 10, 5));
			home.setIcon(i3);*/
			
			JButton home=new JButton("Home");
	        ImageIcon i = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\homeicon.png").getImage().getScaledInstance(25, 25, 5));
			home.setIcon(i);
			home.setBackground(new Color(239,238,239));
	      	home.setForeground(Color.black);
			home.setBounds(10, 10, 100, 25);
			home.setBorder(null);
	      	home.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent e) {
	      			adminhome obj = new adminhome();
	      			obj.setVisible(true);
	      			f.dispose();
	      		}
	      	});
	        f.add(home);
			

			JLabel note= new JLabel("<HTML><U>EMPLOYEE DETAILS TABLE</U></HTML>");
			  note.setBounds(150,0,500,70); 
			  note.setFont(new Font("Eras ITC",Font.ITALIC,30));
			  note.setForeground(Color.white);
			  panela.add(note);

			JLabel textempid= new JLabel("EMP_ID :");
			  textempid.setBounds(320, 400, 100, 30); 
			  textempid.setForeground(Color.white);
			  panela.add(textempid);

			
			empid= new JTextField();
			empid.setBounds(400, 400, 100, 25);
			panela.add(empid);
			empid.setColumns(10);
			

			JLabel textfname= new JLabel("First Name:");
			  textfname.setBounds(620, 400, 100, 30); 
			  textfname.setForeground(Color.white);
			  panela.add(textfname);

			
			fname = new JTextField();
			fname.setBounds(700, 400, 100, 25);
			panela.add(fname);
			fname.setColumns(10);
			

			JLabel textlname= new JLabel("Last Name :");
			  textlname.setBounds(920, 400, 100, 30); 
			  textlname.setForeground(Color.white);
			  panela.add(textlname);

			
			lname = new JTextField();
		    lname.setBounds(1000, 400, 100, 25);
			panela.add(lname);
		    lname.setColumns(5);
		    

			JLabel textqual= new JLabel("Qualification :");
			  textqual.setBounds(320, 480, 100, 30); 
			  textqual.setForeground(Color.white);
			  panela.add(textqual);

			
			
			qual = new JTextField();
			qual.setBounds(400, 480, 100, 25);
			panela.add(qual);
			qual.setColumns(10);
			

			JLabel textspcl= new JLabel("Specialization :");
			  textspcl.setBounds(610, 480, 100, 30); 
			  textspcl.setForeground(Color.white);
			  panela.add(textspcl);

			

		    spcl= new JTextField();
			spcl.setBounds(700, 480, 100, 25);
			panela.add(spcl);
			spcl.setColumns(10);
			

			JLabel textdoj= new JLabel("Date of join :");
			  textdoj.setBounds(920, 480, 100, 30); 
			  textdoj.setForeground(Color.white);
			  panela.add(textdoj);

			
			
			dateofj = new JTextField();
		    dateofj.setBounds(1000, 480, 100, 25);
			panela.add(dateofj);
		    dateofj.setColumns(5);
		    
		    

			JButton projbutt = new JButton("Projects");
			panela.add(projbutt);
			projbutt.setBounds(0,140,70,150);
			projbutt.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent e) {
	      			Project_lists obj1 = new Project_lists();
	      			obj1.setVisible(true);
	      			f.dispose();
	      		}
	      	});
            

			JButton teambutt = new JButton("Team alloc");
			panela.add(teambutt);
			teambutt.setBounds(0,300,70,150);
			teambutt.addActionListener(new ActionListener() {
	      		public void actionPerformed(ActionEvent e) {
	      			status_admin obj1 = new status_admin();
		   			 obj1.setVisible(true);
		   			 f.dispose();
	      		}
	      	});
          			
			DefaultTableModel model = new DefaultTableModel(); 
		      JTable table = new JTable(model); 
		      JScrollPane scroller = new JScrollPane(table);
		      scroller.setBounds(300, 90, 800, 250);
		       String [] col= {"Emp_ID","First_Name","Last_Name","Qualification","Specialization","Date_of_join"};
		       model.setColumnIdentifiers(col);
		       table.setModel(model);
		       panela.add(scroller);
		       try {
					String  query="select * from employee";
					PreparedStatement stmt=conn.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					stmt.close();	
		       }
				catch(Exception e)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e.printStackTrace();
				}
		      
		       JButton addbtn = new JButton("ADD");
				panela.add(addbtn);
				addbtn.setBounds(1300,100,130,50);
				addbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							String  query2="insert into employee values(?,?,?,?,?,?)";
							PreparedStatement stmt11=conn.prepareStatement(query2);
							
							stmt11.setString(1,empid.getText());
							stmt11.setString(2,fname.getText());
							stmt11.setString(3,lname.getText());
							stmt11.setString(4,qual.getText());
							stmt11.setString(5,spcl.getText());
							stmt11.setString(6,dateofj.getText());
							stmt11.execute();
							stmt11.close();	
							
							String  query="select * from employee";
							PreparedStatement stmt=conn.prepareStatement(query);
							ResultSet rs=stmt.executeQuery();
							table.setModel(DbUtils.resultSetToTableModel(rs));
							JOptionPane.showMessageDialog(null,"employee details inserted");
							rs.close();
							stmt.close();
																				
							}
						catch(Exception e1)
						{
							JOptionPane.showMessageDialog(null,"show  problem!");
							e1.printStackTrace();
						}
	}
					});
				
				JButton updatebtn = new JButton("UPDATE");
				panela.add(updatebtn);
				updatebtn.setBounds(1300,180,130,50);
				updatebtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {  
							Statement st = conn.createStatement();  
							st.execute("UPDATE student SET f_name='" + fname.getText() +"',l_name='" + lname.getText() + "',qualification='"+qual.getText()+
									"',specialization='"+spcl.getText()+"',doj='"+dateofj.getText()+"'where empid='"+empid.getText()+"');");
							JOptionPane.showMessageDialog(null, "Record is updated...");
							st.close(); 
							conn.close();  
							} 
						catch (Exception e2) {  
							JOptionPane.showMessageDialog(null, e2); 
							}  
					}
				});
				

				JButton deletebtn = new JButton("DELETE");
				panela.add(deletebtn);
				deletebtn.setBounds(1300,260,130,50);
				deletebtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
				/*try {
					String  query3="delete from employee";
					PreparedStatement s=conn.prepareStatement(query3);
					ResultSet rs=s.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					s.close();	
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}*/
					}});
		       
	}

	public static void main(String[] args) {
		new empdetails();

	}
}
	