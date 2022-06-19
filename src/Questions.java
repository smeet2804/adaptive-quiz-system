
public class Questions {

	private Integer queid;
	private String queame;
	private String a;
	private String b;
	private String c;
	private String d;
	private String cop;
	private String qname;
	private int dif;
	public Questions()
	{
		
	}
	
	public Questions(Integer queid,String queame,String a,String b,String c,String d,String cop,String qname,int dif)
	{
		this.queid=queid;
		this.queame=queame;
		this.a=a;
		this.b=b;
		this.c=c;
		this.d=d;
		this.cop=cop;
		this.qname=qname;
		this.dif=dif;
	}
	
	public Integer getqueid()
	{
		return queid;
	}
	
	public void setqueid(Integer queid)
	{
		this.queid=queid;
	}
	
	public String getqueame()
	{
		return queame;
	}
	
	public void setqueame(String queame)
	{
		this.queame=queame;
	}
	
	public String geta()
	{
		return a;
	}
	
	public void seta(String a)
	{
		this.a=a;
	}
	
	public String getb()
	{
		return b;
	}
	
	public void setb(String b)
	{
		this.b=b;
	}
	public String getc()
	{
		return c;
	}
	
	public void setc(String c)
	{
		this.c=c;
	}
	public String getd()
	{
		return d;
	}
	
	public void setd(String d)
	{
		this.d=d;
	}
	public String getcop()
	{
		return cop;
	}
	
	public void setcop(String cop)
	{
		this.cop=cop;
	}
	public String getqname()
	{
		return qname;
	}
	
	public void setqname(String qname)
	{
		this.qname=qname;
	}
	public int getdif()
	{
		return dif;
	}
	
	public void set(int dif)
	{
		this.dif=dif;
	}
}
