import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;


public class addQuestions implements ActionListener {

	JFrame frame;
	private JTextField difTF;
	private JTextArea quesTA;
	private JTextArea aTA;
	private JTextArea bTA;
	private JTextArea cTA;
	private JTextArea dTA;
	private JTextArea copTA;
	private JLabel qname_1;
	private JLabel lb1;
	private JLabel lb2;
	private JLabel lb3;
	private JButton btnAdd;
	int i=1;
	int tq;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public addQuestions(String qname, int totques) {
		initialize(qname,totques);
		lb1.setText("Total Questions to be added: "+(totques*5));
		lb2.setText("Question no: 1");
		lb3.setText("Please add "+totques+" questions of each difficulty level (1 to 5) ");
		tq=totques;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String qname, int totques) {
		frame = new JFrame("Add Questions");
		frame.setBackground(Color.WHITE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1017, 1055);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.scrollbar);
		panel.setBounds(0, 0, 982, 1055);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
	 quesTA = new JTextArea();
	 quesTA.setColumns(20);
	 quesTA.setFont(new Font("Arial", Font.PLAIN, 18));
		quesTA.setBounds(301, 173, 503, 42);
		panel.add(quesTA);
		
		JLabel lblNewLabel = new JLabel("Question");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel.setBounds(141, 176, 88, 39);
		panel.add(lblNewLabel);
		
		JLabel lblA = new JLabel("A");
		lblA.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblA.setBounds(141, 246, 88, 39);
		panel.add(lblA);
		
		 aTA = new JTextArea();
		 aTA.setFont(new Font("Arial", Font.PLAIN, 18));
		 aTA.setBackground(Color.WHITE);
		 aTA.setForeground(Color.BLACK);
		aTA.setBounds(301, 243, 503, 42);
		panel.add(aTA);
		
		JLabel lblB = new JLabel("B");
		lblB.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblB.setBounds(141, 325, 88, 39);
		panel.add(lblB);
		
	     bTA = new JTextArea();
	     bTA.setFont(new Font("Arial", Font.PLAIN, 18));
		bTA.setBounds(301, 322, 503, 42);
		panel.add(bTA);
		
		JLabel lblC = new JLabel("C");
		lblC.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblC.setBounds(141, 412, 88, 39);
		panel.add(lblC);
		
	 cTA = new JTextArea();
	 cTA.setFont(new Font("Arial", Font.PLAIN, 18));
		cTA.setBounds(301, 409, 503, 42);
		panel.add(cTA);
		
		JLabel lblD = new JLabel("D");
		lblD.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblD.setBounds(141, 492, 73, 39);
		panel.add(lblD);
		
		 dTA = new JTextArea();
		 dTA.setFont(new Font("Arial", Font.PLAIN, 18));
		 dTA.setColumns(10);
		dTA.setBounds(301, 489, 503, 42);
		panel.add(dTA);
		
		JLabel lblCorrectAnswer = new JLabel("Correct Answer");
		lblCorrectAnswer.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblCorrectAnswer.setBounds(103, 585, 174, 39);
		panel.add(lblCorrectAnswer);
		
		 copTA = new JTextArea();
		 copTA.setFont(new Font("Arial", Font.PLAIN, 18));
		copTA.setBounds(301, 582, 117, 42);
		panel.add(copTA);
		
		JLabel lblNewLabel_5_1 = new JLabel("Difficulty");
		lblNewLabel_5_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblNewLabel_5_1.setBounds(141, 674, 110, 39);
		panel.add(lblNewLabel_5_1);
		
		difTF = new JTextField();
		difTF.setFont(new Font("Arial", Font.PLAIN, 18));
		difTF.setBounds(301, 674, 124, 39);
		panel.add(difTF);
		difTF.setColumns(10);
		
		JLabel lblQuizName = new JLabel("Quiz Name");
		lblQuizName.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblQuizName.setBounds(130, 98, 100, 39);
		panel.add(lblQuizName);
		
		qname_1 = new JLabel("");
		qname_1.setFont(new Font("SansSerif", Font.BOLD, 16));
		qname_1.setBounds(338, 109, 174, 16);
		panel.add(qname_1);
		qname_1.setText(qname);
		
		btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnAdd.setBounds(203, 780, 117, 55);
		panel.add(btnAdd);
		btnAdd.addActionListener(this);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnFinish.setBackground(Color.BLACK);
		btnFinish.setForeground(Color.WHITE);
		btnFinish.setFont(new Font("SansSerif", Font.BOLD, 18));
		btnFinish.setBounds(399, 777, 117, 55);
		panel.add(btnFinish);
		
		lb1 = new JLabel("");
		lb1.setBounds(130, 25, 246, 16);
		panel.add(lb1);
		
		 lb2 = new JLabel("");
		lb2.setBounds(130, 56, 167, 16);
		panel.add(lb2);
		
		 lb3 = new JLabel("");
		lb3.setBounds(547, 56, 332, 16);
		panel.add(lb3);
		frame.setVisible(true);
        frame.setSize(1000,900);
        frame.setLocation(400,150);
	
        System.out.println(qname+""+totques);
	}
	
	
	public static void main(String[] arg){
     
		
    }
	public void clearSelection()
	{
		quesTA.setText("");
		aTA.setText("");
		bTA.setText("");
		cTA.setText("");
		dTA.setText("");
		copTA.setText("");
		difTF.setText("");
	}
	
	public void actionPerformed(ActionEvent ae){
        
        String ques = quesTA.getText();
        String a=aTA.getText();
        String b=bTA.getText();
        String c=cTA.getText();
        String d=dTA.getText();
        String cop=copTA.getText();
        String qname=qname_1.getText();
        int dif=Integer.parseInt(difTF.getText());
        
        System.out.println(a+" "+b);
            try{
        		Connection conn=myConnection.getConnection();
        		PreparedStatement ps;
            	ps=conn.prepareStatement("insert into questions (quename,a,b,c,d,cop,dif,qname) values (?,?,?,?,?,?,?,?)");
            	ps.setString(1,ques);
            	ps.setString(2,a);
            	ps.setString(3,b);
            	ps.setString(4,c);
            	ps.setString(5,d);
            	ps.setString(6,cop);
    			ps.setInt(7,dif);
    			ps.setString(8,qname);
                ps.executeUpdate();
                
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
      
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
           }
         	
         	clearSelection();
         	i++;
         	lb2.setText("Question no:"+i);
         	if(i==((tq*5)+1))
         	{
         		btnAdd.setEnabled(false);
         		JOptionPane.showMessageDialog(null,"Quiz have been created successfully");
         		frame.dispose();
         	}
	}
}
