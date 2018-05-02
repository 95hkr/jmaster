package sht.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddCartServlet
 */
@WebServlet("/AddCartServlet")
public class AddCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCartServlet() {
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


		HttpSession session = request.getSession(false);
		if(session == null) {
			out.println("<html><head><title>ShowCart</title></head><body>");
			out.println("<h1>ログインしてください</h1>");
			return;
		}else {
			String isLogin = (String)session.getAttribute("isLogin");
			if(isLogin == null || !isLogin.equals("true")) {
				out.println("<html><head><title>ShowCart</title><head><body>");
				out.println("<h1>ログインしてください</h1>");
				return;
			}
		}


		// リクエストパラメータの読み込み
		String productNo = request.getParameter("product_no");
		int no = Integer.parseInt(productNo);
		String productName = null;
		// 選択された商品の判定
		switch (no) {
		case 100:
			productName = "パソコン";
			break;
		case 101:
			productName = "プリンタ";
			break;
		case 102:
			productName = "デジタルカメラ";
			break;
		default:
			productName = "???";
		}

		// セッション領域の取得
//		HttpSession session = request.getSession();

		@SuppressWarnings("unchecked")
		ArrayList<String> cart = (ArrayList<String> ) session.getAttribute("products");
		if(cart == null) { // 初めてのときはカートを作成
			cart = new ArrayList<String>();
			session.setAttribute("products", cart);
		}
		// 商品の追加
		cart.add(productName);

		// クライアントごとのカート情報の表示
		out.println("<html><head><title>ShowCart</title></head><body>");
		out.println("現在のカートの中身は下記のとおりです<br><br>");
		for(int i = 0; i < cart.size(); i++) {
			out.println(i + 1);
			out.println(":" + cart.get(i) + "<br>");
		}

		// 商品リストへのリンク
		out.println("<hr><a href='/jmaster/selectProduct.html'>商品リスト</a>");
		out.println("</body></html>");
	}
}
