package a.b.c.ch9;

// 데이터를 담는 통 : Value Object : Data Transport Object : Beans
// 명명규칙 : 클래스이름 + VO
public class Ex_DeptVO {
	
	// private 접근제한자 : 해당 변수를 클래스 밖에 서는 호출하면 안된다. : 은닉화 : encapsulation
	// 데이터를 사용하려면 setter, getter 함수를 이용해야 한다. 또는 생성자도 가능하다.
	private String deptno;
	private String dname;
	private String loc;

	public Ex_DeptVO() {}



	public Ex_DeptVO(String deptno, String dname, String loc) {

		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
		
		public String getDeptno() {
			return deptno;
		}
		public String getDname() {
			return dname;
		}
		public String getLoc() {
			return loc;
		}
		public void setDeptno(String deptno) {
			this.deptno = deptno;
		}
		public void setDname(String dname) {
			this.dname = dname;
		}

		public void setLoc(String loc) {
			this.loc = loc;
		}
	}
	
	// 생성자
	