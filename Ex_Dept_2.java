package a.b.c.ch9;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import a.b.c.common.ConnProperty; //

public class Ex_Dept_2 {

	// ������ 
	public static final String DEPT_SELECT = "SELECT * FROM DEPT"; //������ �Է�

	public ArrayList deptSelect() {
		// ��ü �ʱ�ȭ = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ArrayList aList = null;
		
		try {
			
			conn = ConnProperty.getConnection(); // ConnProperyŬ������ �ִ� getConnection() �Լ� ������
			stmt = conn.createStatement();
			rsRs = stmt.executeQuery(Ex_Dept_2.DEPT_SELECT); // << DB�� rsRs�� ����.
			
		//rsRs �� null���� �ƴϸ�
			if (rsRs !=null) {
				aList = new ArrayList(); //al.list �ʱ�ȭ
				// .next() Ŀ�� �Լ�.
				while (rsRs.next()) {
					
					Ex_DeptVO dvo = new Ex_DeptVO();
					dvo.setDeptno(rsRs.getString("DEPTNO"));
					dvo.setDeptno(rsRs.getString("DNAME"));
					dvo.setDeptno(rsRs.getString("LOC"));
					
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
		
		Ex_Dept_2 de = new Ex_Dept_2();
		ArrayList aList = de.deptSelect();
		System.out.println("aList ������ :: aList ����ִ� ���� Ŭ����(EmpVO) ���� >>> : " + aList.size());

		if (aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				
				Ex_DeptVO dvo = (Ex_DeptVO)aList.get(i); // aList.get(i)�� Ex_DeptVO dvo�� ������ Ÿ���� �����ֱ� ���ؼ� ���۷��� ĳ������ ���ش�.
														 // (Ex_DeptVO)
		
				System.out.print(dvo.getDeptno()+ " : ");
				System.out.print(dvo.getDname()+ " : ");
				System.out.println(dvo.getLoc());				
			}		
		}
	}
}








