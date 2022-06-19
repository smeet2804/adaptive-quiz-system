import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class QuestionQuery {
	public ArrayList<Questions> QuestionList(int d, String qn)
	{
		ArrayList<Questions> clist= new ArrayList<Questions>();
		Connection conn=myConnection.getConnection();
		Statement st;
		ResultSet rs;
		
		try
		{
			st=conn.createStatement();
			rs=st.executeQuery("select * from questions where dif = '"+d+"' and qname = '"+qn+"'");
			Questions c;
			
			while(rs.next())
			{
				c=new Questions(rs.getInt("queid"),
						rs.getString("quename"),
						rs.getString("a"),
						rs.getString("b"),
						rs.getString("c"),
						rs.getString("d"),
						rs.getString("cop"),
						rs.getString("qname"),
						rs.getInt("dif")
						);

				clist.add(c);
			}
		}
		
		catch(Exception ex)
		{
			
		}
		return clist;
	}
}
