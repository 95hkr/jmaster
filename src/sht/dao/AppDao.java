package sht.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AppDao {
	private Connection con;

	public AppDao() throws DAOException{
		getConnection();
	}

	public List<String> findAll() throws DAOException{
		if(con == null)
			getConnection();

	PreparedStatement st = null;
	ResultSet rs = null;

	try {

		String sql = "SELECT * FROM user";
		st = con.prepareStatement(sql);
		rs = st.executeQuery();

		List<String> list = new ArrayList<String>();

		// DBから名前とパスを取得
		while(rs.next()) {
			String userName = rs.getString("name");
			String userPass = rs.getString("pass");

			list.add(userName);
			list.add(userPass);
		}

		rs.close();
		st.close();
		con.close();

		return list;

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("");

		}
	}

	public void addInfo(String name,String pass) throws DAOException{

		PreparedStatement st = null;

		try {

			String sql = "INSERT INTO user(name,pass)VALUES(?,?)";
			st = con.prepareStatement(sql);

			st.setString(0,name);
			st.setString(1,pass);
			st.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました。");
		}finally {
			try {
				if(st != null)st.close();
			} catch (Exception e) {
				throw new DAOException("リソースの解放に失敗しました。");
			}
		}
	}

	private void getConnection() throws DAOException{
		try {
				// DBへ接続
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC&useSSL=false";
			String user = "root";
			String pass = "sht30";

			con = DriverManager.getConnection(url,user,pass);

		} catch (Exception e) {
			throw new DAOException("データの取得に失敗しました。");
		}
	}
}
