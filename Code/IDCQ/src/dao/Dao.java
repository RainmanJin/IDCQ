package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Dao {
	public static Connection conn = null;
	static {
		try {
			if (conn == null) {
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://localhost:3306/jcx?characterEncoding=utf8";// 定义所访问数据库
				String user = "root";
				String password = "122157";
				conn = DriverManager.getConnection(url, user, password);// 实现数据库连接
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 执行指定查询
	private static ResultSet query(String QueryStr) {
		if (conn == null) {
			System.out.println("null");
			return null;
		}
		ResultSet rs = null;
		try {
			Statement stmt = null;
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(QueryStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public void Display(String sql){
		ResultSet rs = query(sql);
		try {
			ResultSetMetaData metaData = rs.getMetaData();
			for (int i = 0; i < metaData.getColumnCount(); i++) {
				System.out.print(metaData.getColumnName(i + 1)+"\t");
			}
			System.out.println();
			int colCount = metaData.getColumnCount();
			while (rs.next()) {
				for (int i = 1; i <= colCount; i++) {
					String str = rs.getString(i);
					if (str != null && !str.equals(""))
						str = str.trim();
					System.out.print(str+"\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
