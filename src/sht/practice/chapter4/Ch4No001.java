package sht.practice.chapter4;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch4No001
 */
@WebServlet("/Ch4No001")
public class Ch4No001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ch4No001() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());

		String num1 = request.getParameter("n1");
		String num2 = request.getParameter("n2");
		String num3 = request.getParameter("n3");

		int i1;
		int i2;
		int i3;

		int answer = 0;

		i1 = Integer.parseInt(num1);
		i2 = Integer.parseInt(num2);
		i3 = Integer.parseInt(num3);

		answer = i1 * i2 * i3;
	}

}
