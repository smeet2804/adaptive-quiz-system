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


public class displayResults implements ActionListener {

	public JFrame frame;
	private JTable table;
	private JComboBox comboBox;
	String quizname;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new displayResults();
	}

	public void actionPerformed(ActionEvent e) {
        quizname=comboBox.getSelectedItem().toString();
		System.out.println("Quiz Name"+quizname);
        show();
    }
	/**
	 * Create the application.
	 */
	public displayResults() {
		
		initialize();
		fillCombo();
		
	}

	public ArrayList<Student> studentList()
	{
		ArrayList<Student> studentList=new ArrayList<>();
		Connection conn=myConnection.getConnection();
		Statement st;
		ResultSet rs;
		Student s;
		try
		{
			st=conn.createStatement();
			rs=st.executeQuery("select * from student where qname = '"+quizname+"'");
			Questions c;
			
			while(rs.next())
			{
				s=new Student(rs.getInt("sid"),
						rs.getString("sname"),
						rs.getString("email"),
						rs.getString("mob"),
						rs.getInt("score"),
						rs.getString("qname")
						);

				studentList.add(s);
			}
		}
		
		catch(Exception ex)
		{
			
		}
		return studentList;
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
	public void show()
	{
		ArrayList<Student> list=studentList();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		String[] colNames={"SID","Student Name","Email","Contact No","Score","Quiz Name"};
		Object[][] row=new Object[list.size()][12];
		for(int i=0;i<list.size();i++)
		{
			row[i][0]=list.get(i).getsid();
			row[i][1]=list.get(i).getsname();
			row[i][2]=list.get(i).getemail();
			row[i][3]=list.get(i).getmob();
			row[i][4]=list.get(i).getscore();
			row[i][5]=list.get(i).getquizname();
			model.addRow(row);
		}
		studentTable st=new studentTable(colNames,row);
		
		table.setModel(st);
		table.setRowHeight(40);
		table.getColumnModel().getColumn(11).setPreferredWidth(70);

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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 94, 892, 579);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		scrollPane.setViewportView(table);
		
		JLabel lblSelectQuiz = new JLabel("Select Quiz:");
		lblSelectQuiz.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSelectQuiz.setBounds(184, 31, 144, 30);
		panel.add(lblSelectQuiz);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBox.setBackground(Color.WHITE);
		comboBox.setForeground(Color.BLACK);
		comboBox.setBounds(350, 31, 144, 27);
		panel.add(comboBox);
		
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
		comboBox.addActionListener(this);
		
		frame.setVisible(true);
        frame.setSize(1000,900);
        frame.setLocation(400,150);
	}
}
