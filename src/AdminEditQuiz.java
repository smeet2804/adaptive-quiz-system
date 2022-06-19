import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JButton;


public class AdminEditQuiz implements ActionListener {

	public JFrame frame;
	String quizname;
	private JComboBox comboBox;
	
	
	
	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new AdminEditQuiz();
	}

	public void actionPerformed(ActionEvent e) {
        quizname=comboBox.getSelectedItem().toString();
		System.out.println("Quiz Name"+quizname);
		new AdminEditQuestions(quizname);
		frame.dispose();
    }
	/**
	 * Create the application.
	 */
	public AdminEditQuiz() {
		
		initialize();
		fillCombo();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void fillCombo()
	{
		//comboBox.addItem("Select Quiz");
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
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 970, 816);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new adminDash();
				frame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(37, 31, 97, 25);
		panel.add(btnBack);
		
		JLabel lblSelectQuiz = new JLabel("Select Quiz:");
		lblSelectQuiz.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectQuiz.setBounds(268, 273, 144, 30);
		panel.add(lblSelectQuiz);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setBounds(434, 273, 144, 27);
		panel.add(comboBox);
		
		JButton btnEdit = new JButton("EDIT");
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBounds(390, 355, 97, 25);
		panel.add(btnEdit);
		btnEdit.addActionListener(this);
		frame.setVisible(true);
        frame.setSize(1000,900);
        frame.setLocation(400,150);
	}
}
