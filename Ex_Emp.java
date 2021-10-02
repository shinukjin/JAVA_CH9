package a.b.c.ch9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ex_Emp {

	// 상수 
	// 데이터베이스 연결 정보 : DataSource : 앞으로는 데이터베이스 연결정보를 데이터소스라고 부른다. 
	// 데이터베이스 연결 정보에는 무엇이 있어야 하는가 
	// 1. jdbc 드라이버 시작점 네임스페이스 
	// 2. 데이터베이스 연결 url 
	// 3. 계정명
	// 4. 계정명의 패스워드 
	public static final String ORCL_JDBC_DIRVER = "oracle.jdbc.driver.OracleDriver"; // JDBC_DRIVER 네임스페이스 : 패키지이름.클래스이름
	public static final String ORCL_URL = "jdbc:oracle:thin:@localhost:1521:orclKOSMO00"; // URL
	public static final String ORCL_USER = "scott"; 
	public static final String ORCL_PASS = "tiger";
	
	// 쿼리문 
	public static final String EMP_SELECT = "SELECT * FROM EMP"; //쿼리문 입력
	// 멤버변수
	
	// 생성자
	public Ex_Emp() {
		try {
			System.out.println("Ex_Emp() 생성자 시작");
			System.out.println("제일먼저 ORCL_JDBC_DRIVER 유뮤를 확인함. >> 이상없음");
			Class.forName(Ex_Emp.ORCL_JDBC_DIRVER);
		}catch(Exception e) {
			System.out.println("에러가 : JDBC 드라이버 : ojdbc6.jar를 찾지 못했네요 >>> : " + e.getMessage());
		}
	}

	// 함수  <Ex_EmpVo> 제너릭 붙여줌
	public ArrayList<Ex_EmpVO> empSelect() {
		// 객체 초기화 = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ArrayList<Ex_EmpVO> aList = null;
		
		try {
			
			conn = DriverManager.getConnection(Ex_Emp.ORCL_URL, Ex_Emp.ORCL_USER, Ex_Emp.ORCL_PASS);
			stmt = conn.createStatement();
			rsRs = stmt.executeQuery(Ex_Emp.EMP_SELECT); // << DB가 rsRs로 들어옴.
			
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
						
			
			//rsRs 가 null값이 아니면
			if (rsRs !=null) {
				aList = new ArrayList<Ex_EmpVO>(); //al.list 초기화
				// .next() 커서 함수.
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
			System.out.println("emsSelect() 함수에서 디비연결 또는 쿼리에서 문제가 생겼네요 >>> : " + e.getMessage());
		}
		
		return aList;
	}

	// main() 함수 : 프로그램 시작점
	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		System.out.println("main() 함수 시작");
		
		Ex_Emp exe = new Ex_Emp();
		ArrayList<Ex_EmpVO> aList = exe.empSelect();
		System.out.println("aList 사이즈 :: aList 담겨있는 깡통 클래스(EmpVO) 갯수 >>> : " + aList.size());

		if (aList.size() > 0) {
			for (int i=0; i < aList.size(); i++) {
				// 제너릭을 사용<Ex_EmpVO>해서 aList.get(i)를 레퍼런스 캐스팅을 하지 않아도 데이터타입이 같다. 
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








