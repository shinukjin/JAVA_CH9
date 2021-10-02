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
		1.	oracle.jdbc.driver.OracleDriver : ojdbc6.jar ����Ŭ ����̹� ã�� ������ Ŭ������ ���ӽ����̽�
			oracle.jdbc.driver : ��Ű�� �̸�
			OracleDriver : Ŭ���� �̸�
		
		2.	jdbc:oracle:thin: - ����Ŭ jdbc thin ����̹� ã�� ���ڿ�
		3. @localhost - @ ������, localhost : �����ͺ��̽��� ��ġ�� ��ǻ�� �̸�
								127.0.0.1
								192.168.219.100
								SAMSUNG
		4. 1521 - ����Ŭ �����ͺ��̽� ����Ű�� PORT��ȣ
		5. orclKOSMO)) ������ ���̽� �ĺ��� : SID �Ǵ� ���������ͺ��̽� �̸�
		6. : <== ������
		7. scott : ����
		8. tiger : ��й�ȣ
		
	*/
	
		
	
		Class.forName("oracle.jdbc.driver.OracleDriver"); // .forName(className)
		// 1. ù��° ���ο��� ojdbc.jar���� oracle.jdbc.driver.OracleDriver Ŭ������ ã�Ƽ� �޸𸮿� �ø���.
		System.out.println("1��° ���� :: " + Class.forName("oracle.jdbc.driver.OracleDriver"));

		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orclKOSMO00", "scott", "tiger");
		// 2. �ι�° ���ο��� java.sql.Connection �������̽���
		//	     ����ؼ� Oracle Vender���� jdbc ����̹��� ����� ������ ������ oracle.jdbc.driver.T4CConnectionŬ������
		//	     �츮�� ������ datasource ���������� ������ Ex_OracleTest_1Ŭ������ orclKOSMO0.scott ������ ������ �Ѵ�.
		// 	     �� ��ü(�ڹپ��ð� �����ͺ��̽�)�� ������ �Ǹ� �ڵ� Ŀ��(auto commit)���� ������ ������ �ȴ�.
		System.out.println("2��° ���� :: " + conn);
		System.out.println("2���� ���� :: conn.getAutoCommit() >>> : " + conn.getAutoCommit());
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM EMP WHERE ROWNUM <=1");
		// 3. ����° ���ο��� java.sql.PreparedStatement �� ����� oracle.jdbc.driver.OraclePreparedStatementWrapper@174d20a
		// 	    ����Ŭ ���� ����üŬ������ prepareStatement() �Լ��� ����� ������ ���ڿ��� ������
		//	   ����Ŭ ������ ���̽��� (localhost:1521:"orclKOSMO00", : "scott" : "tiger") �����Ѵ�.
		System.out.println("3���� ���� :: " + pstmt);
		
		// ���������� ���� ����Ʈ�� executeQuery() �Լ��̴�.
		ResultSet rsRs = pstmt.executeQuery();
		// 4. �׹�° ���ο���  ����Ŭ �����ͺ��̽��� ���޵� �������� ����Ŭ Optimizer�� ������ �ؼ� ����� �߻��� �Ǹ�
		//	  oracle.jdbc.driver.OraclePreparedStatementWrapper@174d20a ��ü�� �߻��� �����
		//	  java.sql.ResultSet �������̽��� ����� ����Ŭ ���� ����ü Ŭ����
		//	  oracle.jdbc.driver.OracleResultSetImpl@735b5592�� ����� �޴´�.
		//	    �� ����� ���������� �޸� ������ ������ �ִ�.
		
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
		System.out.println("4���� ���� :: " + rsRs);
		
		//5. �ټ���° ���� while ������ next() Ŀ�� �Լ��� �̿��ؼ� ���ڵ带 ��� �ϰų� ������ ���ε� �Ѵ�. 
		System.out.println("5��° ���� ::" + "while(rs.Rsnext())");
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
