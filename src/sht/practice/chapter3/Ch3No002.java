package sht.practice.chapter3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ch3No002
 */
@WebServlet("/Ch3No002")
public class Ch3No002 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ch3No002() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		String season = request.getParameter("sea");

		String selectSeason;

		if(season == null) {
			selectSeason = "選択されていません。";
		}else {
			switch(season) {
			case"spring":
				selectSeason = "春";
				break;
			case"summer":
				selectSeason = "夏";
				break;
			case"autumn":
				selectSeason = "秋";
				break;
			case"winter":
				selectSeason = "冬";
				break;
			default:
				selectSeason = "???";
				break;
			}
		}

		response.setContentType("text/html:charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><head><title>Season</title></head><body>");
		out.println("あなたが選択した季節は" + selectSeason + "です。");
		out.println("</body></html>");
	}
}
