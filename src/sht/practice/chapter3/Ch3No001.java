package sht.practice.chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch3No001
 */
@WebServlet("/Ch3No001")
public class Ch3No001 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ch3No001() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String[] values = request.getParameterValues("fluit");

		String selectedFluit = "*";
		if(values == null) {
			selectedFluit = "選択されていません。";
		}else {

			for(String fluit:values) {
				switch(fluit) {
				case "str":
					selectedFluit += "いちご" + "*";
					break;
				case "lem":
					selectedFluit += "れもん" + "*";
					break;
				case "gra":
					selectedFluit += "ぶどう" + "*";
					break;
				case "pea":
					selectedFluit += "もも" + "*";
					break;
				case "che":
					selectedFluit += "さくらんぼ" + "*";
				default:
					selectedFluit += "?" + "*";
					break;
				}
			}
		}

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Ch3No001</title></head><body>");
		out.println(selectedFluit);
		out.println("</body></html>");
	}
}
