package sht.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sht.beans.ItemBean;
import sht.dao.DAOException;
import sht.dao.ItemDAO;

/**
 * Servlet implementation class ItemServlet
 */
@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// これをつけないと文字化けする
		request.setCharacterEncoding("UTF-8");

		// パラメータの解析は特になし

		try {

			String action = request.getParameter("action");

			ItemDAO dao = new ItemDAO();
			if(action == null || action.length() == 0) {
				List<ItemBean> list = dao.findAll();

				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");

			} else if(action.equals("add")) {
				String name = request.getParameter("name");
				int price = Integer.parseInt(request.getParameter("price"));
				dao.addItem(name, price);

				List<ItemBean> list = dao.findAll();

				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}

			else if(action.equals("sort")) {
				String key = request.getParameter("key");
				List<ItemBean> list;
				if(key.equals("price_asc"))
					list = dao.sortPrice(true);
				else
					list = dao.sortPrice(false);

				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			}
			else if(action.equals("search")) {
				int price = Integer.parseInt(request.getParameter("price"));
				List<ItemBean> list = dao.findByPrice(price);

				request.setAttribute("items", list);
				gotoPage(request,response,"showItem.jsp");
			}

			else if(action.equals("delete")) {
				int code = Integer.parseInt(request.getParameter("code"));
				dao.deleteByPrimaryKey(code);

				List<ItemBean> list = dao.findAll();

				request.setAttribute("items", list);
				gotoPage(request,response,"/showItem.jsp");
			} else {
				request.setAttribute("message", "正しく操作してください。");
				gotoPage(request,response,"/errInternal.jsp");
			}

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request,response,"/errInternal.jsp");
////			RequestDispatcher rd =
//					request.getRequestDispatcher("/errInternal.jsp");
//			rd.forward(request, response);
		}
	}

	protected void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException{
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
