package Views.view2;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import entity.Department;
import entity.Student;

public class DeparetmentTableModel extends AbstractTableModel {
	List<Department> depList = new ArrayList();
	String[] columnnames = { "id", "部门", "人数" };

	public DeparetmentTableModel(List<Department> depList) {
		this.depList = depList;
	}

	public void setList(List<Department> depList) {
		this.depList = depList;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return depList.size();
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
			return depList.get(rowIndex).getId();
		}
		if (columnIndex == 1) {
			return depList.get(rowIndex).getName();
		} else if (columnIndex == 2) {
			return depList.get(rowIndex).getNum();
		}

		return "";
	}

	public String getColumnName(int column) {

		return columnnames[column];

	}

}
