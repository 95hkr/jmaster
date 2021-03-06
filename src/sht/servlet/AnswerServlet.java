package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.beans.PlusBean;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();

	// リクエストスコープから属性を取り出す
//	Integer num1 = (Integer)request.getAttribute("data1");
//	Integer num2 = (Integer)request.getAttribute("data2");
//	Integer answer = (Integer)request.getAttribute("answer");

	// リクエストスコープからPlusBeanを取り出す
	// ↑(リクエストスコープから属性を取り出す)部分をまとめている
	sht.beans.PlusBean bean = (PlusBean)request.getAttribute("plus");

	// 答えの出力
	out.println("<html><head><title>Plus</title></head><body>");
	out.println(bean.getValue1() + "+" + bean.getValue2() + "=" + bean.getAnswer());
	out.println("</body></html>");
	}
}
