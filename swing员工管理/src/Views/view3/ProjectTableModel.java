package Views.view3;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


import entity.Project;
import entity.Student;

public class ProjectTableModel extends AbstractTableModel{
	List <Project>proList =new ArrayList();
	String[] columnnames= {"id","ϵͳ"};
      public ProjectTableModel  ( List <Project>proList) {
      this.proList=proList;	  
      }
      public void setList( List <Project>proList) {
          this.proList=proList;	  
          }

	public int getRowCount() {
		// TODO Auto-generated method stub
		return proList.size();
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
			return proList.get(rowIndex).getId();
		}
		if(columnIndex==1) {
			return proList.get(rowIndex).getName();
		}
		
		
		
	     return "";
	}
	  public String getColumnName(int column) {
	       
	        return columnnames[column];
	        
	        }
	   

}
