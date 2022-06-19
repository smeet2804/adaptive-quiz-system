import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class studentAttemptQuiz implements ActionListener {

	private JFrame frame;
	private JRadioButton rdbtnA;
	private JRadioButton rdbtnB;
	private JRadioButton rdbtnC;
	private JRadioButton rdbtnD;
	private ButtonGroup bg;
	private JLabel aLB;
	private JLabel bLB;
	private JLabel cLB;
	private JLabel dLB;
	private JLabel qname;
	private JLabel qnameLB1;
	private JLabel question;
	private JLabel qno;
	private JButton btnSubmit;
	private JButton btnNext;
	QuestionQuery cq=new QuestionQuery();
	ArrayList<ArrayList<Questions> > clist = new ArrayList<ArrayList<Questions> >();
	int track[]=new int[5];
	int p=0,res=0,first=0,last=4;
	int counter=0;
	int counter2=0;
	String sname,email,mob,quizname;
	public void addData(String qn)
	{
		try
		{
			Connection conn=myConnection.getConnection();
			Statement st;
			ResultSet rs;
			st=conn.createStatement();
			rs=st.executeQuery("select * from quiz where qname = '"+qn+"'");
			
			
			while(rs.next())
			{
			counter=rs.getInt("totques");
			}
			System.out.print("COunter:"+counter);
		}
		catch(Exception e)
		{
			System.out.println("Excpetion: "+e);
		}
		for(int i=0;i<5;i++)
		{
		clist.add(new ArrayList<Questions>()); 
		clist.get(i).addAll(cq.QuestionList(i+1,qn));
		Collections.shuffle(clist.get(i)); 
		}
		 
	}
	/**
	 * Launch the application.

	 */
	public static void main(String[] args) {
	
	//	new studentAttemptQuiz("a","b","c","Java");
	}

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public studentAttemptQuiz(String sname, String email, String mob, String qname) {
		System.out.println("Quiz started");
		initialize();
		frame.setVisible(true);
        frame.setSize(900,700);
        frame.setLocation(400,150);
        addData(qname);
        fetchData();
        this.sname=sname;
        this.email=email;
        this.mob=mob;
        this.quizname=qname;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void fetchData()
	{
		
			System.out.println(clist.size());
			qnameLB1.setText(""+counter);
			qno.setText(""+(counter2+1));
			qname.setText(clist.get(p).get(track[p]).getqname());
			question.setText(clist.get(p).get(track[p]).getqueame());
			aLB.setText(clist.get(p).get(track[p]).geta());
			bLB.setText(clist.get(p).get(track[p]).getb());
			cLB.setText(clist.get(p).get(track[p]).getc());
			dLB.setText(clist.get(p).get(track[p]).getd());
			
	}
	
	private void initialize() {
		frame = new JFrame("Attempt Quiz");
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 882, 853);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quiz Name:");
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblNewLabel.setBounds(102, 40, 146, 16);
		panel.add(lblNewLabel);
		
		 qname = new JLabel("");
		 qname.setFont(new Font("Arial Black", Font.BOLD, 16));
		qname.setBounds(272, 40, 161, 16);
		panel.add(qname);
		
		 qno = new JLabel("qno");
		qno.setFont(new Font("Arial Black", Font.PLAIN, 18));
		qno.setBounds(87, 103, 56, 25);
		panel.add(qno);
		
		question = new JLabel("question");
		question.setFont(new Font("Arial Black", Font.PLAIN, 18));
		question.setBounds(175, 103, 454, 25);
		panel.add(question);
		
		rdbtnA = new JRadioButton("A");
		rdbtnA.setBackground(Color.WHITE);
		rdbtnA.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnA.setBounds(87, 149, 56, 25);
		panel.add(rdbtnA);
		
		rdbtnB = new JRadioButton("B");
		rdbtnB.setBackground(Color.WHITE);
		rdbtnB.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnB.setBounds(87, 194, 56, 25);
		panel.add(rdbtnB);
		
		rdbtnC = new JRadioButton("C");
		rdbtnC.setBackground(Color.WHITE);
		rdbtnC.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnC.setBounds(87, 248, 50, 25);
		panel.add(rdbtnC);
		
		rdbtnD = new JRadioButton("D");
		rdbtnD.setBackground(Color.WHITE);
		rdbtnD.setFont(new Font("Tahoma", Font.BOLD, 14));
		rdbtnD.setBounds(87, 305, 50, 25);
		panel.add(rdbtnD);
		bg=new ButtonGroup();
		bg.add(rdbtnA);
		bg.add(rdbtnB);
		bg.add(rdbtnC);
		bg.add(rdbtnD);
		
		aLB = new JLabel("oop");
		aLB.setFont(new Font("Arial", Font.PLAIN, 16));
		aLB.setBounds(151, 153, 478, 21);
		panel.add(aLB);
		
		bLB = new JLabel("opa");
		bLB.setFont(new Font("Arial", Font.PLAIN, 16));
		bLB.setBounds(152, 198, 477, 16);
		panel.add(bLB);
		
		cLB = new JLabel("opa");
		cLB.setFont(new Font("Arial", Font.PLAIN, 16));
		cLB.setBounds(152, 248, 477, 16);
		panel.add(cLB);
		
		dLB = new JLabel("opa");
		dLB.setFont(new Font("Arial", Font.PLAIN, 16));
		dLB.setBounds(151, 309, 501, 16);
		panel.add(dLB);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnSubmit.setBackground(Color.BLACK);
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBounds(175, 385, 97, 44);
		panel.add(btnSubmit);
		
		btnNext = new JButton("Next");
		btnNext.setFont(new Font("Arial Black", Font.PLAIN, 16));
		btnNext.setBackground(Color.BLACK);
		btnNext.setForeground(Color.WHITE);
		btnNext.setBounds(356, 385, 97, 44);
		panel.add(btnNext);
		
		qnameLB1 = new JLabel((String) null);
		qnameLB1.setFont(new Font("Arial Black", Font.BOLD, 16));
		qnameLB1.setBounds(661, 40, 115, 16);
		panel.add(qnameLB1);
		
		JLabel qnameLB = new JLabel("Total Questions:");
		qnameLB.setFont(new Font("Arial Black", Font.BOLD, 16));
		qnameLB.setBounds(445, 40, 184, 16);
		panel.add(qnameLB);
		
		
		
		btnSubmit.addActionListener(this);
		btnNext.addActionListener(this);
	}
	 public String getSelectedButtonText(ButtonGroup buttonGroup) {
	        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();

	            if (button.isSelected()) {
	                return button.getText();
	            }
	        }

	        return null;
	    }

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		if(arg0.getActionCommand().equals("Next"))
			{
				
				System.out.println("Next button");
			
				if(getSelectedButtonText(bg).equals(clist.get(p).get(track[p]).getcop().toUpperCase()) && p!=last)
				{
					System.out.println("Correct");
					p=p+1;
					res=res+(p+1)*10;
				}
				else if(!getSelectedButtonText(bg).equals(clist.get(p).get(track[p]).getcop().toUpperCase()) && p!=first)
				{
					System.out.println("InCorrect");
					p=p-1;
					
				}
				else
					p=p;
				
				 track[p]=track[p]+1;
					
				   counter2++;
					
					
					if(counter==counter2)
					{
						 btnNext.setEnabled(false);
						 JOptionPane.showMessageDialog(null,"Please Submit the quiz");
					}
					else
					{
						fetchData();
					bg.clearSelection();
					}
			}
		
		if(arg0.getActionCommand().equals("Submit"))
		{
		
			  try{
	        		Connection conn=myConnection.getConnection();
	        		PreparedStatement ps;
	            	ps=conn.prepareStatement("insert into student (sname,email,mob,score,qname) values (?,?,?,?,?)");
	            	ps.setString(1,sname);
	            	ps.setString(2,email);
	            	ps.setString(3,mob);
	            	ps.setString(5,quizname);
	            	ps.setInt(4,res);
	                ps.executeUpdate();
	                
	                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
	                frame.dispose();
	      
	            }
			  catch(Exception ee){
	                System.out.println("The error is:"+ee);
	           }
		}

		
		
	}
}
