package entity;

public class Score {
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private  String grade;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	private Integer value;
   private Student emp;
   private Project pro;
public Student getEmp() {
	return emp;
}
public void setEmp(Student emp) {
	this.emp = emp;
}
public Project getPro() {
	return pro;
}
public void setPro(Project pro) {
	this.pro = pro;
}
   
	
	
}
