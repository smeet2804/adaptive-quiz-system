
public class Student {

	private int sid;
	private String sname,email,mob,quizname;
	private int score; 
	
	public Student(int sid, String sname, String email, String mob, int score,  String quizname)
	{
		this.sid=sid;
		this.sname=sname;
		this.email=email;
		this.mob=mob;
		this.score=score;
		this.quizname=quizname;
	}
	
	public int getsid()
	{
		return sid;
	}
	public String getsname()
	{
		return sname;
	}
	public String getemail()
	{
		return email;
	}
	public String getmob()
	{
		return mob;
	}
	public String getquizname()
	{
		return quizname;
	}
	public int getscore()
	{
		return score;
	}
}
