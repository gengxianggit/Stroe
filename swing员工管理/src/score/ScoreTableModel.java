package score;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import dao.ScoreDao;
import entity.Score;
import entity.Student;

public class ScoreTableModel extends AbstractTableModel {
     List<Score> list =new ArrayList();
	 String[] columnnames = { "id", "姓名", "部门", "项目", "成绩", "等级" };
	 private Set<Score> set = new HashSet();/*防止重改导存俩数据*/
	
	 
	 
	 
	 public Set<Score> getSet() {
		return set;
	    }

	

	public ScoreTableModel(List<Score> list) {
		this.list = list;

	}

	public void setList(List<Score> list) {
		this.list = list;
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    	
      if(!aValue.equals("")) {/*防止转换不过去，不输入无法换格*/
		list.get(rowIndex).setValue(Integer.parseInt(String.valueOf(aValue)));
        fireTableCellUpdated(rowIndex, columnIndex);
		 set.add(list.get(rowIndex));
		 }
      
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
		if (columnIndex == 0) {
			return list.get(rowIndex).getId();
		}
		if (columnIndex == 1) {
			return list.get(rowIndex).getEmp().getName();
		}
		if (columnIndex == 2) {
			return list.get(rowIndex).getEmp().getDep().getName();

		} else if (columnIndex == 3) {
			return list.get(rowIndex).getPro().getName();
		} else if (columnIndex == 4) {
			return list.get(rowIndex).getValue();

		} else if (columnIndex == 5) {
			return list.get(rowIndex).getGrade();
		}

		return "";
	}

	public String getColumnName(int column) {

		return columnnames[column];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		
if (columnIndex == 4&&list.get(rowIndex).getPro().getId()!=0){
	
	return true;
	
	}

      return false;
	}

	
}
