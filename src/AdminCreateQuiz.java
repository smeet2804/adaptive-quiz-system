import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;


public class AdminCreateQuiz implements ActionListener {

	public JFrame frame;
	private JTextField quizNameTF;
	private JTextField questionTF;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public AdminCreateQuiz() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame("Create Quiz");
		frame.setBounds(100, 100, 900, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.white);
		
		frame.getContentPane().setBackground(Color.WHITE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 882, 753);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblQuizName = new JLabel("Quiz Name:");
		lblQuizName.setFont(new Font("Arial", Font.BOLD, 15));
		lblQuizName.setBounds(172, 162, 115, 43);
		panel.add(lblQuizName);
		
		quizNameTF = new JTextField();
		quizNameTF.setBounds(312, 162, 184, 43);
		panel.add(quizNameTF);
		quizNameTF.setColumns(10);
		
		JLabel lblNoOfQuestions = new JLabel("No of Questions:");
		lblNoOfQuestions.setFont(new Font("Arial", Font.BOLD, 15));
		lblNoOfQuestions.setBounds(132, 257, 155, 43);
		panel.add(lblNoOfQuestions);
		
		questionTF = new JTextField();
		questionTF.setColumns(10);
		questionTF.setBounds(312, 257, 184, 43);
		panel.add(questionTF);
		frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(400,150);
		JButton btnCreate = new JButton("CREATE");
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreate.setBounds(312, 356, 135, 52);
		panel.add(btnCreate);
		btnCreate.addActionListener(this);
	}
		public void actionPerformed(ActionEvent ae){
        
        String a = quizNameTF.getText();
        int b = Integer.parseInt(questionTF.getText());
     
        System.out.println(a+" "+b);
            try{
        		Connection conn=myConnection.getConnection();
        		PreparedStatement ps;
            	ps=conn.prepareStatement("insert into quiz (qname,totques) values (?,?)");
            //	ps.setInt(1);
            	ps.setString(1,a);
    			ps.setInt(2,b);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
      
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
         	new addQuestions(a,b).frame.setVisible(true);
        	frame.dispose();
    }
    public static void main(String[ ] arg){
       
    }
}
