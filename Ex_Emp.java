package a.b.c.ch9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ex_Emp {

	// ��� 
	// �����ͺ��̽� ���� ���� : DataSource : �����δ� �����ͺ��̽� ���������� �����ͼҽ���� �θ���. 
	// �����ͺ��̽� ���� �������� ������ �־�� �ϴ°� 
	// 1. jdbc ����̹� ������ ���ӽ����̽� 
	// 2. �����ͺ��̽� ���� url 
	// 3. ������
	// 4. �������� �н����� 
	public static final String ORCL_JDBC_DIRVER = "oracle.jdbc.driver.OracleDriver"; // JDBC_DRIVER ���ӽ����̽� : ��Ű���̸�.Ŭ�����̸�
	public static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00"; // URL
	public static final String ORCL_USER = "scott"; 
	public static final String ORCL_PASS = "tiger";
	
	// ������ 
	public static final String EMP_SELECT = "SELECT * FROM EMP"; //������ �Է�
	// �������
	
	// ������
	public Ex_Emp() {
		try {
			System.out.println("Ex_Emp() ������ ����");
			System.out.println("���ϸ��� ORCL_JDBC_DRIVER ���¸� Ȯ����. >> �̻����");
			Class.forName(Ex_Emp.ORCL_JDBC_DIRVER);
		}catch(Exception e) {
			System.out.println("������ : JDBC ����̹� : ojdbc6.jar�� ã�� ���߳׿� >>> : " + e.getMessage());
		}
	}

	// �Լ�  <Ex_EmpVo> ���ʸ� �ٿ���
	public ArrayList<Ex_EmpVO> empSelect() {
		// ��ü �ʱ�ȭ = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ArrayList<Ex_EmpVO> aList = null;
		
		try {
			
			conn = DriverManager.getConnection(Ex_Emp.ORCL_URL, Ex_Emp.ORCL_USER, Ex_Emp.ORCL_PASS);
			stmt = conn.createStatement();
			rsRs = stmt.executeQuery(Ex_Emp.EMP_SELECT); // << DB�� rsRs�� ����.
			
//			7369	SMITH	CLERK	7902	80/12/17	800		20
//			7499	ALLEN	SALESMAN	7698	81/02/20	1600	300	30
//			7521	WARD	SALESMAN	7698	81/02/22	1250	500	30
//			7566	JONES	MANAGER	7839	81/04/02	2975		20
//			7654	MARTIN	SALESMAN	7698	81/09/28	1250	1400	30
//			7698	BLAKE	MANAGER	7839	81/05/01	2850		30
//			7782	CLARK	MANAGER	7839	81/06/09	2450		10
//			7788	SCOTT	ANALYST	7566	87/04/19	3000		20
//			7839	KING	PRESIDENT		81/11/17	5000		10
//			7844	TURNER	SALESMAN	7698	81/09/08	1500	0	30
//			7876	ADAMS	CLERK	7788	87/05/23	1100		20
//			7900	JAMES	CLERK	7698	81/12/03	950		30
//			7902	FORD	ANALYST	7566	81/12/03	3000		20
//			7934	MILLER	CLERK	7782	82/01/23	1300		10
						
			
			//rsRs �� null���� �ƴϸ�
			if (rsRs !=null) {
				aList = new ArrayList<Ex_EmpVO>(); //al.list �ʱ�ȭ
				// .next() Ŀ�� �Լ�.
				while (rsRs.next()) {
					
					Ex_EmpVO evo = new Ex_EmpVO();
					evo.setEmpno(rsRs.getString("EMPNO"));
					evo.setEname(rsRs.getString("ENAME"));
					evo.setJob(rsRs.getString("JOB"));
					evo.setMgr(rsRs.getString("MGR"));
					evo.setHiredate(rsRs.getString("HIREDATE"));
					evo.setSal(rsRs.getString("SAL"));
					evo.setComm(rsRs.getString("COMM"));
					evo.setDeptno(rsRs.getString("DEPTNO"));
					
					aList.add(evo);
				}				
			}
		}catch(Exception e) {
			System.out.println("emsSelect() �Լ����� ��񿬰� �Ǵ� �������� ������ ����׿� >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// main() �Լ� : ���α׷� ������
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		System.out.println("main() �Լ� ����");
		
		Ex_Emp exe = new Ex_Emp();
		ArrayList<Ex_EmpVO> aList = exe.empSelect();
		System.out.println("aList ������ :: aList ����ִ� ���� Ŭ����(EmpVO) ���� >>> : " + aList.size());

		if (aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				// ���ʸ��� ���<Ex_EmpVO>�ؼ� aList.get(i)�� ���۷��� ĳ������ ���� �ʾƵ� ������Ÿ���� ����. 
				Ex_EmpVO evo = aList.get(i);
				System.out.print(evo.getEmpno() + " : ");
				System.out.print(evo.getEname() + " : ");
				System.out.print(evo.getJob() + " : ");
				System.out.print(evo.getMgr() + " : ");
				System.out.print(evo.getHiredate() + " : ");
				System.out.print(evo.getSal() + " : ");
				System.out.print(evo.getComm() + " : ");
				System.out.println(evo.getDeptno());				
			}		
		}
	}
}








