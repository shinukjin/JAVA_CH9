package a.b.c.ch9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ex_Dept_1 {

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
	public static final String DEPT_SELECT = "SELECT * FROM DEPT"; //쿼리문 입력
	// 멤버변수
	
	// 생성자
	public Ex_Dept_1() {
		try {
			System.out.println("Ex_DEPT() 생성자 시작");
			System.out.println("제일먼저 ORCL_JDBC_DRIVER 유뮤를 확인함. >> 이상없음");
			Class.forName(Ex_Dept_1.ORCL_JDBC_DIRVER);
		}catch(Exception e) {
			System.out.println("에러가 : JDBC 드라이버 : ojdbc6.jar를 찾지 못했네요 >>> : " + e.getMessage());
		}
	}

	// 
	public ArrayList deptSelect() {
		// 객체 초기화 = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rsRs = null;
		ArrayList aList = null;
		
		try {
			
			conn = DriverManager.getConnection(Ex_Dept_1.ORCL_URL, Ex_Dept_1.ORCL_USER, Ex_Dept_1.ORCL_PASS);
			stmt = conn.createStatement();
			rsRs = stmt.executeQuery(Ex_Dept_1.DEPT_SELECT); // << DB가 rsRs로 들어옴.
			
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
		
		Ex_Dept_1 de = new Ex_Dept_1();
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








