package Views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Student;

public class StudentTableModel extends AbstractTableModel{
	List <Student>list =new ArrayList();
	String[] columnnames= {"id","姓名","性别","年龄","部门"};
      public StudentTableModel( List <Student>list) {
      this.list=list;	  
      }
      public void setList( List <Student>list) {
          this.list=list;	  
          }
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnnames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if(columnIndex==0) {
			return list.get(rowIndex).getId();
		}
		if(columnIndex==1) {
			return list.get(rowIndex).getName();
			
		}
		else if(columnIndex==2) {
			  return  list.get(rowIndex).getSex();
		}
		else if(columnIndex==3) {
			return list.get(rowIndex).getAge();
			
		}
		  else if(columnIndex==4) {
			return list.get(rowIndex).getDep().getName();
		}
		
		
	     return "";
	}
	  public String getColumnName(int column) {
	       
	        return columnnames[column];
	    }

}
