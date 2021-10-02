package a.b.c.ch9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ex_Dept {

	// ��� 
	// �����ͺ��̽� ���� ���� : DataSource : �����δ� �����ͺ��̽� ���������� �����ͼҽ���� �θ���. 
	// �����ͺ��̽� ���� �������� ������ �־�� �ϴ°� a
	// 1. jdbc ����̹� ������ ���ӽ����̽� 
	// 2. �����ͺ��̽� ���� url 
	// 3. ������
	// 4. �������� �н����� 
	public static final String ORCL_JDBC_DIRVER = "oracle.jdbc.driver.OracleDriver"; // JDBC_DRIVER ���ӽ����̽� : ��Ű���̸�.Ŭ�����̸�
	public static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00"; // URL
	public static final String ORCL_USER = "scott"; 
	public static final String ORCL_PASS = "tiger";
	
	// ������ 
	public static final String DEPT_SELECT = "SELECT * FROM DEPT"; //������ �Է�
	// �������
	
	// ������
	public Ex_Dept() {
		try {
			System.out.println("Ex_DEPT() ������ ����");
			System.out.println("���ϸ��� ORCL_JDBC_DRIVER ���¸� Ȯ����. >> �̻����");
			Class.forName(Ex_Dept.ORCL_JDBC_DIRVER);
		}catch(Exception e) {
			System.out.println("������ : JDBC ����̹� : ojdbc6.jar�� ã�� ���߳׿� >>> : " + e.getMessage());
		}
	}

	
	public ArrayList deptSelect() {
		// ��ü �ʱ�ȭ = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ArrayList aList = null;
		
		try {
			
			conn = DriverManager.getConnection(Ex_Dept.ORCL_URL, Ex_Dept.ORCL_USER, Ex_Dept.ORCL_PASS);
			stmt = conn.createStatement();
			rsRs = stmt.executeQuery(Ex_Dept.DEPT_SELECT); // << DB�� rsRs�� ����.
			
		//rsRs �� null���� �ƴϸ�
			if (rsRs !=null) {
				aList = new ArrayList(); //al.list �ʱ�ȭ
				// .next() Ŀ�� �Լ�.
				while (rsRs.next()) {
					
					Ex_DeptVO dvo = new Ex_DeptVO();
					dvo.setDeptno(rsRs.getString("DEPTNO"));
					dvo.setDname(rsRs.getString("DNAME"));
					dvo.setLoc(rsRs.getString("LOC"));
					
					aList.add(dvo);
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
		
		Ex_Dept de = new Ex_Dept(); // ��������, ������ ����. >>Ex_Dept() �̵� 
		ArrayList aList = de.deptSelect(); //deptSelect() �Լ��� ���� �����͸� �޾ƿ� �ڿ� aList�� �ʱ�ȭ
		System.out.println("aList ������ :: aList ����ִ� ���� Ŭ����(EmpVO) ���� >>> : " + aList.size()); 
		//aList.size() ���� ���� ��
		if (aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				// ���ʸ��� ���<Ex_EmpVO>�ؼ� aList.get(i)�� ���۷��� ĳ������ ���� �ʾƵ� ������Ÿ���� ����. 
				Ex_DeptVO dvo = (Ex_DeptVO)aList.get(i);
		
				System.out.print(dvo.getDeptno()+ " : ");
				System.out.print(dvo.getDname()+ " : ");
				System.out.println(dvo.getLoc());				
			}		
		}
	}
}








