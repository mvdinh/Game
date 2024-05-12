package Entity;

public class Point {
	private String user;
	private int point;
	public Point(String user, int point) {
		super();
		this.user = user;
		this.point = point;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
}
