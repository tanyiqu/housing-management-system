//连接数据库的工具类
//使用JDBC连接
//依赖“mssql-jdbc-6.4.0.jre8.jar”
//081417137吴硕

package util;

import java.sql.*;

public class DBUtil {

	private static final String DB = "FWGL";
	private static final String USER="fw";
	private static final String PASSWORD="108412696";
	private static final String URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=" + DB + ";user=" + USER + ";password=" + PASSWORD;
	protected static Statement s=null;
	protected static ResultSet rs=null;
	protected static Connection conn=null;

	/**
	 * 创建数据库链接
	 * @return 数据库连接
	 */
	public static synchronized Connection getConnection(){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn=DriverManager.getConnection(URL);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 **执行insert update delete语句
	 * @param sql sql
	 * @return 执行结果 int
	 */
	public static int executeUpdate(String sql){
		int result=0;
		try {
			s=getConnection().createStatement();
			result=s.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/**
	 **执行select语句
	 * @param sql sql
	 * @return result结果集
	 */
	public static ResultSet executeQuery(String sql){
		try {
			s=getConnection().createStatement();
			rs=s.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	/**
	 **执行动态sql语句
	 * @param sql sql
	 * @return PreparedStatement
	 */
	public static PreparedStatement executePreparedStatment(String sql){
		PreparedStatement ps=null;
		try {
			ps=getConnection().prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ps;
	}

	/**
	 * 执行存储过程或函数
	 * @param sql sql
	 * @return CallableStatement
	 */
	public static CallableStatement executeCall(String sql){
		CallableStatement cs = null;
		try {
			cs = getConnection().prepareCall(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cs;
	}

	/**
	 **事务回滚
	 */
	public static void rollback(){
		try {
			getConnection().rollback();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 **关闭连接对象
	 */
	public static void close(){
		try {
			if(rs!=null)
				rs.close();
			if(s!=null)
				s.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}