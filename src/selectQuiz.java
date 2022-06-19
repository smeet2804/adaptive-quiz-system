import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTextField;


public class selectQuiz implements ActionListener {

	private JFrame frame;
	private JTextField emailTF;
	private JTextField snameTF;
	private JTextField mobTF;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					selectQuiz window = new selectQuiz();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public selectQuiz() {
		initialize();
		fillCombo();
	}

	private void fillCombo()
	{
		comboBox.addItem("Select Quiz");
		Connection conn=myConnection.getConnection();
		Statement st;
		ResultSet rs;
		
		try
		{
			st=conn.createStatement();
			rs=st.executeQuery("select * from quiz");
		
			
			while(rs.next())
			{
				comboBox.addItem(rs.getString("qname"));
			}
		}
		
		catch(Exception ex)
		{
			
		}

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(200, 100, 900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 882, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblName = new JLabel("Email ID:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(201, 181, 77, 28);
		panel.add(lblName);
		
		emailTF = new JTextField();
		emailTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		emailTF.setBounds(358, 185, 193, 22);
		panel.add(emailTF);
		emailTF.setColumns(10);
		
		snameTF = new JTextField();
		snameTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		snameTF.setColumns(10);
		snameTF.setBounds(358, 127, 193, 22);
		panel.add(snameTF);
		
		JLabel lblName_1 = new JLabel("Name:");
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName_1.setBounds(201, 123, 65, 28);
		panel.add(lblName_1);
		
		JLabel lblSelectQuiz = new JLabel("Select Quiz:");
		lblSelectQuiz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectQuiz.setBounds(201, 324, 112, 19);
		panel.add(lblSelectQuiz);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(358, 321, 193, 22);
		panel.add(comboBox);
		
		JButton btnStart = new JButton("Start");
		btnStart.setForeground(Color.WHITE);
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnStart.setBackground(Color.BLACK);
		btnStart.setBounds(333, 414, 107, 40);
		panel.add(btnStart);
		btnStart.addActionListener(this);
		JLabel lblName_1_1 = new JLabel("Mob No.:");
		lblName_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName_1_1.setBounds(201, 248, 98, 28);
		panel.add(lblName_1_1);
		
		mobTF = new JTextField();
		mobTF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		mobTF.setColumns(10);
		mobTF.setBounds(358, 252, 193, 22);
		panel.add(mobTF);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String sname=snameTF.getText();
		String email=emailTF.getText();
		String mob=mobTF.getText();
		String qn=comboBox.getSelectedItem().toString();
		new studentAttemptQuiz(sname,email,mob,qn);
		frame.dispose();
		
	}
}
