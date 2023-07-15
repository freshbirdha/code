package reflection;

public class Person {

	private String nameString;
	private String idString;
	
	//没有参数的构造方法
	public Person() {
		
	}
	//有参数的构造方法
	public Person(String nameString, String idString) {
		super();
		this.nameString = nameString;
		this.idString = idString;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}
	
	

}
