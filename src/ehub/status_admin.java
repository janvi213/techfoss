package ehub;

import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Color;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
@SuppressWarnings("serial")
public class status_admin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					status_admin frame = new status_admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//edit
	public void fillcomboBox()
	{
		try {
			String  query="select * from order_details";
			PreparedStatement stmt=conn.prepareStatement(query);
			ResultSet rs=stmt.executeQuery();
			while(rs.next())
			{
				comboBox.addItem(rs.getString("order_id"));
			}
			rs.close();
			stmt.close();		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null,"show  problem!");
			e1.printStackTrace();
		}
	}
	boolean x=false;
	private JTable table;
	private JComboBox<String> comboBox;
	/**
	 * Create the frame.
	 */
	Connection conn = null;
	private JTextField dateofc;
	private JTextField dateofr;
	private JTextField stat;
	
	//constructor
	public status_admin() {
		conn=postconnection.dbconnector();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1057, 689);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 89, 100));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton show_btn = new JButton("Show status");
		show_btn.setFont(new Font("Tahoma", Font.BOLD, 13));
		show_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="select * from order_details";
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
		show_btn.setBounds(508, 194, 137, 30);
		contentPane.add(show_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(327, 234, 585, 213);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		dateofc = new JTextField();
		dateofc.setBounds(37, 239, 131, 39);
		contentPane.add(dateofc);
		dateofc.setColumns(10);
		
		dateofr = new JTextField();
		dateofr.setBounds(37, 303, 131, 39);
		contentPane.add(dateofr);
		dateofr.setColumns(10);
		
		stat = new JTextField();
		stat.setBounds(37, 375, 137, 39);
		contentPane.add(stat);
		stat.setColumns(10);
		
		JLabel doc = new JLabel("DOC");
		doc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		doc.setForeground(Color.white);
		doc.setBounds(77, 222, 45, 13);
		contentPane.add(doc);
		
		JLabel dor = new JLabel("DOR");
		dor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dor.setForeground(Color.white);
		dor.setBounds(92, 288, 45, 13);
		contentPane.add(dor);
		
		JLabel status = new JLabel("Status");
		status.setFont(new Font("Tahoma", Font.PLAIN, 13));
		status.setForeground(Color.white);
		status.setBounds(77, 364, 45, 13);
		contentPane.add(status);
		
		JButton updatebtn = new JButton("UPDATE");
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="UPDATE order_details SET  date_of_commencement='"+dateofc.getText()+"',date_of_release='"+dateofr.getText()+"',status='"+stat.getText()+"' where order_id='"+(String)comboBox.getSelectedItem()+"' ";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.execute();
					JOptionPane.showMessageDialog(null,"updated");
					stmt.close();
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"updated problem");
					ex.printStackTrace();

				}
			}
		});
		updatebtn.setFont(new Font("Tahoma", Font.BOLD, 11));
		updatebtn.setBounds(37, 494, 131, 39);
		contentPane.add(updatebtn);
		
		JButton deletebtn = new JButton("DELETE");
		deletebtn.setFont(new Font("Tahoma", Font.BOLD, 10));
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String  query="DELETE FROM order_details  where order_id='"+(String)comboBox.getSelectedItem()+"' ";
					PreparedStatement stmt=conn.prepareStatement(query);
					stmt.execute();
					JOptionPane.showMessageDialog(null,"Deleted");
					stmt.close();
								}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,"delete  problem");
					ex.printStackTrace();

				}
			}
		});
		deletebtn.setBounds(37, 543, 131, 39);
		contentPane.add(deletebtn);
		
		JButton backbtn = new JButton("BACK");
		backbtn.setFont(new Font("Tahoma", Font.BOLD, 13));
		backbtn.setBounds(44, 69, 104, 39);
		ImageIcon i = new ImageIcon(new ImageIcon("D:\\applications\\eclipse\\ehub\\src\\back.jpg").getImage().getScaledInstance(25, 25, 6));
		backbtn.setIcon(i);
		backbtn.setBackground(new Color(239,238,239));
		backbtn.setBounds(20, 20, 100, 25);
		backbtn.setBorder(null);
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					adminhome obj1=new adminhome();
					obj1.setVisible(true);
					
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});

		contentPane.add(backbtn);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(37, 143, 158, 39);
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 2000, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STATUS");
		lblNewLabel.setBounds(360, 21, 213, 30);
		panel.add(lblNewLabel);
		lblNewLabel.setBackground(new Color(127, 255, 212));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		fillcomboBox();
		}
}

