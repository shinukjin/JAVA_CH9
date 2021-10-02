package a.b.c.ch9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex_OracleTest {

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
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott", "tiger");
		Statement stmt = conn.createStatement();
		ResultSet rsRs = stmt.executeQuery("SELECT * FROM EMP");
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
