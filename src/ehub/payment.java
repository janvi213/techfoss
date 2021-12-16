package ehub;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class payment extends JFrame {

	Border brd;
	JFrame frame;
	JPanel panel1,panel2;
	JLabel L,pay,U,C,NC,E,CV;
	JComboBox<Object> Ut;
	payment(){
		frame = new JFrame();
		  frame.getContentPane();
		  
			Image icon = Toolkit.getDefaultToolkit().getImage("/Users/anjan/eclipse-workspace/PROJECT/src/LOGO.png");  
			frame.setIconImage(icon);
	      
		  panel1 = new JPanel();
		  panel1.setLayout(null);
		  panel1.setBounds(0,80,600,600);
		  frame.add(panel1);
		  
		  panel2= new JPanel();
		  panel2.setBackground(new Color(0, 89, 100));
		  frame.add(panel2);
		  
	      L = new JLabel("PAYMENT PORTAL");
		  L.setBounds(149,35,400,20);
		  L.setFont(new Font("Times New Roman",Font.BOLD,30));
		  L.setForeground(new Color(255,255,255));
		  panel2.add(L);
		  
		    pay= new JLabel();
	        ImageIcon imageIcon = new ImageIcon(new ImageIcon("/Users/anjan/eclipse-workspace/PROJECT/src/pay.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
	        pay.setBorder(brd);
	        pay.setIcon(imageIcon);
			pay.setBounds(10, 20, 70, 70);
			panel1.add(pay);
			
		  U= new JLabel("Card Type :");
		  U.setBounds(60,120,250,25);
		  U.setFont(new Font("Times New Roman",Font.BOLD,20));
	      panel1.add(U);
		  
	      String card[] = {"","Debit ", "Credit"};
	      Ut=new JComboBox<Object>(card);
	      Ut.setFont(new Font("Times New Roman",Font.BOLD,15));
		  Ut.setBounds(270,120,230,28);
	      panel1.add(Ut);        
	      
		  C= new JLabel("Card Number :");
		  C.setBounds(60,160,250,25);
		  C.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(C);
		  
		  final JTextField CN = new JTextField("");
		  CN.setEditable(true);
		  CN.setBounds(270,160,230,28);
		  panel1.add(CN);
		  
		  NC= new JLabel("Name on Card :");
		  NC.setBounds(60,200,250,25);
		  NC.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(NC);
		  
		  final JTextField N = new JTextField("");
		  N.setEditable(true);
		  N.setBounds(270,200,230,28);
		  panel1.add(N);
		  
		  
		  E= new JLabel("Expiry Date :");
		  E.setBounds(60,245,230,25);
		  E.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(E);
		  
		  final JTextField ED = new JTextField("");
		  ED.setEditable(true);
		  ED.setBounds(180,245,90,28);
		  panel1.add(ED);
		
		  CV= new JLabel("CVV Number :");
		  CV.setBounds(292,245,250,25);
		  CV.setFont(new Font("Times New Roman",Font.BOLD,20));
		  panel1.add(CV);
		  
		  final JTextField CVV = new JTextField("");
		  CVV.setEditable(true);
		  CVV.setBounds(424,245,75,28);
		  panel1.add(CVV);
		  
		  JButton B = new JButton("CONFIRM PAYMENT");
		  B.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						JOptionPane.showMessageDialog(null,"purchased");
						dispose();
						clienthome obj=new clienthome();
						obj.setVisible(true);
						frame.dispose();
						}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null,"show  problem!");
						e1.printStackTrace();
						
					}
				}
			});
		  B.setBounds(148,340,230, 40);
		  B.setFont(new Font("Times New Roman",Font.BOLD,15));
		  B.setBackground(new Color(0, 89, 100));
		  B.setForeground(new Color(255,255,255));
		  panel1.add(B);
		
		  frame.setSize(600,600);
	      frame.setVisible(true);
	}

	public static void main(String[] args) {
		new payment();
	}

	}