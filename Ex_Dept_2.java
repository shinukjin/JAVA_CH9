package a.b.c.ch9;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import a.b.c.common.ConnProperty; //

public class Ex_Dept_2 {

	// 쿼리문 
	public static final String DEPT_SELECT = "SELECT * FROM DEPT"; //쿼리문 입력

	public ArrayList deptSelect() {
		// 객체 초기화 = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ArrayList aList = null;
		
		try {
			
			conn = ConnProperty.getConnection(); // ConnPropery클래스에 있는 getConnection() 함수 가져옴
			stmt = conn.createStatement();
			rsRs = stmt.executeQuery(Ex_Dept_2.DEPT_SELECT); // << DB가 rsRs로 들어옴.
			
		//rsRs 가 null값이 아니면
			if (rsRs !=null) {
				aList = new ArrayList(); //al.list 초기화
				// .next() 커서 함수.
				while (rsRs.next()) {
					
					Ex_DeptVO dvo = new Ex_DeptVO();
					dvo.setDeptno(rsRs.getString("DEPTNO"));
					dvo.setDeptno(rsRs.getString("DNAME"));
					dvo.setDeptno(rsRs.getString("LOC"));
					
					aList.add(dvo);
				}				
			}
		}catch(Exception e) {
			System.out.println("emsSelect() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// main() 함수 : 프로그램 시작점
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		System.out.println("main() 함수 시작");
		
		Ex_Dept_2 de = new Ex_Dept_2();
		ArrayList aList = de.deptSelect();
		System.out.println("aList 사이즈 :: aList 담겨있는 깡통 클래스(EmpVO) 갯수 >>> : " + aList.size());

		if (aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				
				Ex_DeptVO dvo = (Ex_DeptVO)aList.get(i); // aList.get(i)와 Ex_DeptVO dvo의 데이터 타입을 맞춰주기 위해서 레퍼런스 캐스팅을 해준다.
														 // (Ex_DeptVO)
		
				System.out.print(dvo.getDeptno()+ " : ");
				System.out.print(dvo.getDname()+ " : ");
				System.out.println(dvo.getLoc());				
			}		
		}
	}
}








