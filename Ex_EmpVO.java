package a.b.c.ch9;

// 데이터를 담는 통 : Value Object : Data Transport Object : Beans
// 명명규칙 : 클래스이름 + VO
public class Ex_EmpVO {
	
	// private 접근제한자 : 해당 변수를 클래스 밖에 서는 호출하면 안된다. : 은닉화 : encapsulation
	// 데이터를 사용하려면 setter, getter 함수를 이용해야 한다. 또는 생성자도 가능하다.
	private String empno;
	private String ename;
	private String job;
	private String mgr;
	private String hiredate;
	private String sal;
	private String comm;
	private String deptno;
	
	
	// 생성자
	public Ex_EmpVO() {}
	public Ex_EmpVO(String empno, String ename, 
				    String job, String mgr, 
				    String hiredate, String sal, 
				    String comm, String deptno) {

		this.empno = empno;
		this.ename = ename;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.sal = sal;
		this.comm = comm;
		this.deptno = deptno;
	}
	
	// getter() 함수
	public String getEmpno() {
		return empno;
	}
	public String getEname() {
		return ename;
	}
	public String getJob() {
		return job;
	}
	public String getMgr() {
		return mgr;
	}
	
	// setter() 함수
	public String getHiredate() {
		return hiredate;
	}
	public String getSal() {
		return sal;
	}
	public String getComm() {
		return comm;
	}
	public String getDeptno() {
		return deptno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public void setMgr(String mgr) {
		this.mgr = mgr;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public void setComm(String comm) {
		this.comm = comm;
	}
	public void setDeptno(String deptno) {
		this.deptno = deptno;
	}
	
}
