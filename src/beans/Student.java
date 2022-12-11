package beans;

public class Student {
	private int id;
	private String hoten;
	private String diachi;
	
	public Student(int id, String hoten, String diachi) {
		super();
		this.id = id;
		this.hoten = hoten;
		this.diachi = diachi;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}	
}
