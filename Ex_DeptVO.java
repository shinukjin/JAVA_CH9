package a.b.c.ch9;

// �����͸� ��� �� : Value Object : Data Transport Object : Beans
// ����Ģ : Ŭ�����̸� + VO
public class Ex_DeptVO {
	
	// private ���������� : �ش� ������ Ŭ���� �ۿ� ���� ȣ���ϸ� �ȵȴ�. : ����ȭ : encapsulation
	// �����͸� ����Ϸ��� setter, getter �Լ��� �̿��ؾ� �Ѵ�. �Ǵ� �����ڵ� �����ϴ�.
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
	
	// ������
	