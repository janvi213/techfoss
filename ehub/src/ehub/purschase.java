package ehub;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;


@SuppressWarnings("serial")
public class purschase extends JFrame {
	
	

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purschase frame = new purschase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    
	public void fillcomboBox()
	{
		try {
			String  query="select * from software";
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				comboBoxname.addItem(rs.getString("s_id"));
			}
			rs.close();
			stmt.close();		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,"show  problem!");
			e1.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 */
	String order_id;
	Connection conn = null;
	private JTable table;
	private JTextField s_idfield;
	private JComboBox<String> comboBoxname;

	public purschase() {
		conn=postconnection.dbconnector();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1162, 704);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setForeground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(434, 287, 517, 217);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton showproductsbtn = new JButton("Click for products list");
		showproductsbtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		showproductsbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select s_id,s_name,price from software";
					PreparedStatement stmt=conn.prepareStatement(query);
					ResultSet rs=stmt.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					rs.close();
					stmt.close();		}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		showproductsbtn.setBounds(588, 223, 171, 41);
		contentPane.add(showproductsbtn);
		
		s_idfield = new JTextField();
		s_idfield.setBackground(new Color(211, 211, 211));
		s_idfield.setBounds(69, 412, 222, 35);
		contentPane.add(s_idfield);
		s_idfield.setColumns(10);
		
		JButton buybtn = new JButton("BUY");
		buybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String orde = null;
					
				     
					
					String  incr="SELECT * FROM increment ORDER BY increment DESC LIMIT 1";
					PreparedStatement stmt=conn.prepareStatement(incr);
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						orde=rs.getString("increment");
					}
					String ord="o-"+orde;
					rs.close();
					stmt.close();
					int i=(Integer.parseInt(orde))+1;
					String  incre="insert into increment values(?)";
					PreparedStatement stmt1=conn.prepareStatement(incre);
					stmt1.setInt(1,i);
					stmt1.execute();
					stmt1.close();
					String  query="insert into order_details(order_id,s_id) values(?,?)";
					PreparedStatement stmt11=conn.prepareStatement(query);
					
					stmt11.setString(1,ord);
					stmt11.setString(2,(String)comboBoxname.getSelectedItem());
					stmt11.execute();
					JOptionPane.showMessageDialog(null,"purchased");
					
					stmt11.close();		}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
				
				payment obj = new payment();
				obj.setVisible(true);
			}
		});
		buybtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		buybtn.setBounds(105, 457, 130, 41);
		contentPane.add(buybtn);
		
		 comboBoxname = new JComboBox<String>();
		 comboBoxname.setBackground(Color.PINK);
		 comboBoxname.setFont(new Font("Tahoma", Font.BOLD, 13));
		 comboBoxname.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
					String  query="select * from software where s_id=?";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.setString(1,(String)comboBoxname.getSelectedItem());
					ResultSet rs=stmt.executeQuery();
					while(rs.next())
					{
						s_idfield.setText(rs.getString("s_name"));
						
					}
					rs.close();
					stmt.close();		}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
		 	}
		 });
		comboBoxname.setBounds(78, 307, 186, 35);
		contentPane.add(comboBoxname);
		
		JLabel lblNewLabel_1 = new JLabel("purchase_pg");
		lblNewLabel_1.setBackground(new Color(147, 112, 219));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(464, 39, 187, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("select id of software");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 262, 212, 35);
		contentPane.add(lblNewLabel);
		
		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					clienthome obj=new clienthome();
					obj.setVisible(true);
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbtn.setBounds(52, 113, 139, 35);
		contentPane.add(backbtn);
		
		JButton statusbtn = new JButton("STATUS");
		statusbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					status_client obj=new status_client();
					obj.setVisible(true);
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		statusbtn.setFont(new Font("Tahoma", Font.BOLD, 12));
		statusbtn.setBounds(902, 114, 146, 35);
		contentPane.add(statusbtn);
		
		fillcomboBox();
	}
}
