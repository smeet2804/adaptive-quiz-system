import javax.swing.table.AbstractTableModel;


public class studentTable extends AbstractTableModel{

	private String[] columns;
	private Object[][] rows;
	
	public studentTable()
	{
		
	}
	
	public studentTable(String[] columnsName,Object[][] data)
	{
		this.columns=columnsName;
		this.rows=data;
	}
	
	public Class getColumnClass(int col)
	{
		return getValueAt(0,col).getClass();
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columns.length;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rows.length;
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return this.rows[rowIndex][columnIndex];
	}
	@Override
	public String getColumnName(int col)
	{
		return this.columns[col];
	}

}
