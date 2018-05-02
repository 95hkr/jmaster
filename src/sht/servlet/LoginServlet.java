package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String USER="jack";
	private static final String PASS="abc";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String action = request.getParameter("action");
		if(action.equals("login")){


			String name = request.getParameter("name");
			String passWord = request.getParameter("pw");

			if(name.equals(USER)&&passWord.equals(PASS)) {

				HttpSession session = request.getSession();

				session.setAttribute("isLogin","true");
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ログイン成功!</h1>");
			}else {
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ユーザ名またはパスワードが違います</h1>");
			}
		}else if(action.equals("logout")) {

			HttpSession session = request.getSession(false);
			if(session != null) {

				session.invalidate();
				out.println("<html><head><title>ShowCart</title></head><body>");
				out.println("<h1>ログアウトしました</h1>");
			}
		}
		out.println("<a href='/jmaster/selectProduct.html'>戻る</a>");
		out.println("</body></html>");
	}
/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);

	}
}