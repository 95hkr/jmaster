package sht.practice;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class No001_
 */
@WebServlet("/No001_")
public class No001_ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public No001_() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;carset=UTF-8");
		PrintWriter out = response.getWriter();

		String num1 = request.getParameter("value1");
		String num2 = request.getParameter("value2");
		String num3 = request.getParameter("value3");

		int i1 = Integer.parseInt(num1);
		int i2 = Integer.parseInt(num2);
		int i3 = Integer.parseInt(num3);

		int answer = i1 * i2 * i3;

		out.println("<html><head><title>No001_</title></head><body>");
		out.println(answer);
		out.println("</body></html>");

	}

}
