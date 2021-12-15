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
public class status_client extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					status_client frame = new status_client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//edit
	
	boolean x=false;
	private JTable table;

	/**
	 * Create the frame.
	 */
	Connection conn = null;
	
	//constructor
	public status_client() {
		conn=postconnection.dbconnector();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 949, 596);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(189, 183, 107));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STATUS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(342, 30, 227, 46);
		contentPane.add(lblNewLabel);
		
		JButton show_btn = new JButton("Show status");
		show_btn.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
		show_btn.setBounds(369, 163, 139, 46);
		contentPane.add(show_btn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(185, 219, 517, 200);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton backbtn = new JButton("BACK");
		backbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dispose();
					purschase obj1=new purschase();
					obj1.setVisible(true);
					
					}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,"show  problem!");
					e1.printStackTrace();
				}
			}
		});
		backbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		backbtn.setBounds(41, 96, 114, 37);
		contentPane.add(backbtn);
	}
}
