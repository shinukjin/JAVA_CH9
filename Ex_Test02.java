package a.b.c.ch9;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


//데이터 소스를 공통패키지에 만들어놔서 import해서 가져온다.
import a.b.c.common.ConnProperty_Test02; 

public class Ex_Test02 {

	// 쿼리문 
	public static final String T3_SELECT = "SELECT * FROM T3";

	public ArrayList<Ex_Test02VO> t3Select() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ArrayList<Ex_Test02VO> aList = null;
		
		try {
			
			conn = ConnProperty_Test02.getConnection();
			stmt = conn.createStatement();
			rsRs = stmt.executeQuery(Ex_Test02.T3_SELECT);
			
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
						
			if (rsRs !=null) {
				aList = new ArrayList<Ex_Test02VO>();
				
				while (rsRs.next()) {
					
					Ex_Test02VO et2 = new Ex_Test02VO();
					et2.setT3_1(rsRs.getString("T3_1"));
					et2.setT3_2(rsRs.getString("T3_2"));
					et2.setT3_3(rsRs.getString("T3_3"));
					et2.setT3_4(rsRs.getString("T3_4"));
					et2.setT3_5(rsRs.getString("T3_5"));
					et2.setT3_6(rsRs.getString("T3_6"));

					
					aList.add(et2);
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
		
		
		Ex_Test02 ext = new Ex_Test02();
		ArrayList<Ex_Test02VO> aList = ext.t3Select();
		
//		aList.clear();
//		aList=null; 에러안뜨면서 실행이 안됨.  
//		boolean b = aList.isEmpty();
//		System.out.println("aList 사이즈 :: aList 담겨있는 깡통 클래스(EmpVO) 갯수 >>> : " + aList.size());
//		null 들어가있을때 프린트함수 확인시 에러뜬다. NullPointerException
		
		
// 		if () : 조건식들어가는 부분에서  aList != null 넣어줘서 null값 여부 확인해준다.
		if (aList != null && aList.size() > 0) { 
			for (int i=0; i < aList.size(); i++) {
				Ex_Test02VO et2 = aList.get(i);
				System.out.print(et2.getT3_1() + " : ");
				System.out.print(et2.getT3_2() + " : ");
				System.out.print(et2.getT3_3() + " : ");
				System.out.print(et2.getT3_4() + " : ");
				System.out.print(et2.getT3_5() + " : ");
				System.out.println(et2.getT3_6());	
			
			}		
		}
	}
}








