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


public class adminDash implements ActionListener {

	public JFrame frame;
	private JButton btnViewResults;
	private JButton btnCreate;
	private JButton btnEditQuiz;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public adminDash() {
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
		frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(400,150);
	     btnCreate = new JButton("CREATE NEW QUIZ");
		btnCreate.setBackground(Color.BLACK);
		btnCreate.setForeground(Color.WHITE);
		btnCreate.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCreate.setBounds(261, 218, 256, 52);
		panel.add(btnCreate);
		
	    btnViewResults = new JButton("VIEW RESULTS");
		btnViewResults.setForeground(Color.WHITE);
		btnViewResults.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnViewResults.setBackground(Color.BLACK);
		btnViewResults.setBounds(261, 315, 256, 52);
		panel.add(btnViewResults);
		
		btnEditQuiz = new JButton("EDIT QUIZ");
		btnEditQuiz.setForeground(Color.WHITE);
		btnEditQuiz.setFont(new Font("Arial Black", Font.BOLD, 17));
		btnEditQuiz.setBackground(Color.BLACK);
		btnEditQuiz.setBounds(261, 408, 256, 52);
		panel.add(btnEditQuiz);
		btnCreate.addActionListener(this);
		btnViewResults.addActionListener(this);
		btnEditQuiz.addActionListener(this);
	}
		public void actionPerformed(ActionEvent ae){
        
			if(ae.getActionCommand().toString().equals("VIEW RESULTS"))
			{
				new displayResults().frame.setVisible(true);
            	frame.dispose();
			}
			if(ae.getActionCommand().toString().equals("CREATE NEW QUIZ"))
			{
				new AdminCreateQuiz().frame.setVisible(true);
            	frame.dispose();
			}
			if(ae.getActionCommand().toString().equals("EDIT QUIZ"))
			{
				new AdminEditQuiz().frame.setVisible(true);
            	frame.dispose();
			}
    }
    public static void main(String[ ] arg){
       
    }
}
