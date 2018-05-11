package sht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sht.dao.AppDao;
import sht.dao.DAOException;

/**
 * Servlet implementation class AppServlet
 */
@WebServlet("/AppServlet")
public class AppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		try {
		// リクエストパラメータの取得
		String action = request.getParameter("action");

		AppDao aDao = new AppDao();
		List<String> list = aDao.findAll();

		list.get(0);
		list.get(1);

		String lisName = list.get(0);
		String lisPass = list.get(1);

			// DBへ接続
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			String url = "jdbc:mysql://localhost/sample2?serverTimezone=UTC&useSSL=false";
//			String user = "root";
//			String pass = "sht30";
//
//			Connection con = DriverManager.getConnection(url,user,pass);
//
//			String sql = "SELECT * FROM user";
//
//			PreparedStatement st = con.prepareStatement(sql);
//
//			ResultSet rs = st.executeQuery();
//
//			// DBから名前とパスを取得
//			while(rs.next()) {
//				userName = rs.getString("name");
//				userPass = rs.getString("pass");
//			}
//
//			rs.close();
//			st.close();
//			con.close();

		if(action.equals("login")) {
			// 入力値の取得
			String Name = request.getParameter("name");
			String passWord = request.getParameter("pw");

			// 入力値とDB内データの一致確認
		if(Name.equals(lisName)&&passWord.equals(lisPass)) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", Name);

			// マイページへ
			RequestDispatcher rd = request.getRequestDispatcher("/mypage.jsp");
			rd.forward(request, response);
			}
		} else if(action.equals("add")) { // 入力値取得のifの〆
			String NewName = request.getParameter("newname");
			String NewPass = request.getParameter("newpass");
			aDao.addInfo(NewName, NewPass);

			RequestDispatcher rd = request.getRequestDispatcher("/newInput.jsp");
			rd.forward(request, response);
		}

		} catch (DAOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
