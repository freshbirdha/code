package dbutils;

public class Stu {
	private int sid;
	private String sname;
	private int age;
	private String gender;
	private String province;
	private int tuition;
	
	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public int getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}

	@Override
	public String toString() {
		return "Stu [sid=" + sid + ", sname=" + sname + ", age=" + age + ", gender=" + gender + ", province=" + province
				+ ", tuition=" + tuition + "]";
	}

	public Stu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Stu(int sid, String sname, int age, String gender, String province, int tuition) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.gender = gender;
		this.province = province;
		this.tuition = tuition;
	}

}
