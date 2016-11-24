package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.Drink;
import model.BO.DrinkBO;

/**
 * Servlet implementation class SearchAjaxServlet
 */
@WebServlet(asyncSupported = true, name = "search", urlPatterns = { "/search" })
public class SearchAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchAjaxController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<Drink> listDrinks;
		DrinkBO drinkBO = new DrinkBO();
		String searchKey = "";
		String act = request.getParameter("act");
		if (act == null) {
			act = "";
		}
		switch (act) {
		case "search":
			String drinkID = request.getParameter("drinkID");
			listDrinks = new ArrayList<>();
			if (drinkID != null) {
				listDrinks.add(drinkBO.getDrinkByDrinkID(drinkID));
			} else {
				searchKey = request.getParameter("searchKey");
				System.out.println(searchKey);
				listDrinks = drinkBO.getListAllDrinksByDrinkName(searchKey);
			}
			HttpSession session = request.getSession();
			session.setAttribute("displayLoginForm", 1);
			request.setAttribute("listAllDrinks", listDrinks);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		default:
			searchKey = request.getParameter("searchKey");
			System.out.println("Search key: " + searchKey);
			listDrinks = drinkBO.getListAllDrinksByDrinkName(searchKey);
			System.out.println(listDrinks.size());
			PrintWriter out = null;
			try {
				out = response.getWriter();
				String tmp = "";
				for (Drink drink : listDrinks) {
					tmp += drink.getDrinkID() + "$" + drink.getName() + "#";
				}
				out.print(tmp);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
