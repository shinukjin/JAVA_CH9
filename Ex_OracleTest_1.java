package a.b.c.ch9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex_OracleTest_1 {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		

		/*	
		1.	oracle.jdbc.driver.OracleDriver : ojdbc6.jar 오라클 드라이버 찾는 시작점 클래스으 네임스패이스
			oracle.jdbc.driver : 패키지 이름
			OracleDriver : 클래스 이름
		
		2.	jdbc:oracle:thin: - 오라클 jdbc thin 드라이버 찾는 문자열
		3. @localhost - @ 구분자, localhost : 데이터베이스가 설치된 컴퓨터 이름
								127.0.0.1
								192.168.219.100
								SAMSUNG
		4. 1521 - 오라클 데이터베이스 가르키는 PORT번호
		5. orclKOSMO)) 데이터 베이스 식별자 : SID 또는 전역데이터베이스 이름
		6. : <== 구분자
		7. scott : 계정
		8. tiger : 비밀번호
		
	*/
	
		
	
		Class.forName("oracle.jdbc.driver.OracleDriver"); // .forName(className)
		// 1. 첫번째 라인에서 ojdbc.jar에서 oracle.jdbc.driver.OracleDriver 클래스를 찾아서 메모리에 올린다.
		System.out.println("1번째 라인 :: " + Class.forName("oracle.jdbc.driver.OracleDriver"));

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott", "tiger");
		// 2. 두번째 라인에서 java.sql.Connection 인터페이스를
		//	     상속해서 Oracle Vender에서 jdbc 드라이버를 만드는 팀에서 실현한 oracle.jdbc.driver.T4CConnection클래스로
		//	     우리가 제공한 datasource 연결정보를 가지고 Ex_OracleTest_1클래스와 orclKOSMO0.scott 계정에 연결을 한다.
		// 	     두 객체(자바어플과 데이터베이스)가 연결이 되면 자동 커밋(auto commit)으로 세션이 열리게 된다.
		System.out.println("2번째 라인 :: " + conn);
		System.out.println("2번재 라인 :: conn.getAutoCommit() >>> : " + conn.getAutoCommit());
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMP WHERE ROWNUM <=1");
		// 3. 세번째 라인에서 java.sql.PreparedStatement 를 상속한 oracle.jdbc.driver.OraclePreparedStatementWrapper@174d20a
		// 	    오라클 벤더 구현체클래스가 prepareStatement() 함수에 적재된 쿼리문 문자열을 가지고
		//	   오라클 데이터 베이스에 (localhost:1521:"orclKOSMO00", : "scott" : "tiger") 전달한다.
		System.out.println("3번쨰 라인 :: " + pstmt);
		
		// 쿼리전달의 시작 포인트는 executeQuery() 함수이다.
		ResultSet rsRs = pstmt.executeQuery();
		// 4. 네번째 라인에서  오라클 데이터베이스에 전달된 쿼리문을 오라클 Optimizer가 실행을 해서 결과가 발생이 되면
		//	  oracle.jdbc.driver.OraclePreparedStatementWrapper@174d20a 객체가 발생된 결과를
		//	  java.sql.ResultSet 인터페이스를 상속한 오라클 벤더 구현체 클래스
		//	  oracle.jdbc.driver.OracleResultSetImpl@735b5592가 결과를 받는다.
		//	    그 결과를 파일형태의 메모리 구조를 가지고 있다.
		
		/*
		  	7369 : SMITH : CLERK : 7902 : 1980-12-17 00:00:00 : 800 : null : 20
			7499 : ALLEN : SALESMAN : 7698 : 1981-02-20 00:00:00 : 1600 : 300 : 30
			7521 : WARD : SALESMAN : 7698 : 1981-02-22 00:00:00 : 1250 : 500 : 30
			7566 : JONES : MANAGER : 7839 : 1981-04-02 00:00:00 : 2975 : null : 20
			7654 : MARTIN : SALESMAN : 7698 : 1981-09-28 00:00:00 : 1250 : 1400 : 30
			7698 : BLAKE : MANAGER : 7839 : 1981-05-01 00:00:00 : 2850 : null : 30
			7782 : CLARK : MANAGER : 7839 : 1981-06-09 00:00:00 : 2450 : null : 10
			7788 : SCOTT : ANALYST : 7566 : 1987-04-19 00:00:00 : 3000 : null : 20
			7839 : KING : PRESIDENT : null : 1981-11-17 00:00:00 : 5000 : null : 10
			7844 : TURNER : SALESMAN : 7698 : 1981-09-08 00:00:00 : 1500 : 0 : 30
			7876 : ADAMS : CLERK : 7788 : 1987-05-23 00:00:00 : 1100 : null : 20
			7900 : JAMES : CLERK : 7698 : 1981-12-03 00:00:00 : 950 : null : 30
			7902 : FORD : ANALYST : 7566 : 1981-12-03 00:00:00 : 3000 : null : 20
			7934 : MILLER : CLERK : 7782 : 1982-01-23 00:00:00 : 1300 : null : 10
		 */
		System.out.println("4번쨰 라인 :: " + rsRs);
		
		//5. 다섯번째 라인 while 문에서 next() 커서 함수를 이용해서 레코드를 출력 하거나 변수에 바인딩 한다. 
		System.out.println("5번째 라인 ::" + "while(rs.Rsnext())");
		while(rsRs.next()) {
			System.out.print(rsRs.getString(1) + " : " );
			System.out.print(rsRs.getString(2) + " : " );
			System.out.print(rsRs.getString(3) + " : " );
			System.out.print(rsRs.getString(4) + " : " );
			System.out.print(rsRs.getString(5) + " : " );
			System.out.print(rsRs.getString(6) + " : " );
			System.out.print(rsRs.getString(7) + " : " );
			System.out.println(rsRs.getString(8));
			
		}

	}

}
