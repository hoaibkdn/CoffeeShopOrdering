package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.*;
import model.BO.DrinkBO;

/**
 * Servlet implementation class Search30Controller
 */
//@WebServlet(asyncSupported = true, name = "search30", urlPatterns = { "/search30" })
public class Search30Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search30Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		ArrayList<Drink> listDrinks;
		DrinkBO drinkBO = new DrinkBO();
		String searchKey = "";
		searchKey = request.getParameter("searchKey");
		ArrayList<Drink30> listDrink = new ArrayList<>();
		ArrayList<Drink30> listHotDrink = new ArrayList<>();
		ArrayList<CoffeeShop> listShop = new ArrayList<>();
		ArrayList<CoffeeShop> listSummerShop = new ArrayList<>();
		
		listDrinks = new ArrayList<>();
		searchKey = request.getParameter("searchKey");
		System.out.println(searchKey);
		listDrinks = drinkBO.getListAllDrinksByDrinkName(searchKey);

		HttpSession session = request.getSession();
		session.setAttribute("displayLoginForm", 1);
		request.setAttribute("listAllDrinks", listDrinks);
		switch (searchKey) {
		case "drink":
			System.out.println("alo");
			listDrink = drinkBO.searchDrink();
			for(int i=0; i<listDrink.size(); i++){
				System.out.println("Drink: "+listDrink.get(i).getName());
			}
			request.setAttribute("listDrink", listDrink);
			request.getRequestDispatcher("search30.jsp").forward(request, response);
			break;
		case "coffee shop":
			listShop = drinkBO.searchShop();
			for(int i=0; i<listShop.size(); i++){
				System.out.println("Coffee shop: "+listShop.get(i).getName());
			}
			request.setAttribute("listShop", listShop);
			request.getRequestDispatcher("search30.jsp").forward(request, response);
			break;
		case "hot":
			System.out.println("hot");
			listHotDrink = drinkBO.searchHotDrink();
			for(int i=0; i<listHotDrink.size(); i++){
				System.out.println("Drink: "+listHotDrink.get(i).getName());
			}
			request.setAttribute("listHotDrink", listHotDrink);
			request.getRequestDispatcher("search30.jsp").forward(request, response);
			break;
			
		case "summer shop":
			System.out.println("summer shop");
			listSummerShop = drinkBO.searchShop();
			for(int i=0; i<listSummerShop.size(); i++){
				System.out.println("Coffee shop: "+listSummerShop.get(i).getName());
			}
			request.setAttribute("listShop", listSummerShop);
			request.getRequestDispatcher("search30.jsp").forward(request, response);
			break;
		default:
			RequestDispatcher rd = request.getRequestDispatcher("search30.jsp");
			rd.forward(request, response);
			break;
		}
//		if(request.getParameter("search_btn")!=null){
//			
//			
//		}
//		else{
//			listDrinks = new ArrayList<>();
//			searchKey = request.getParameter("searchKey");
//			System.out.println(searchKey);
//			listDrinks = drinkBO.getListAllDrinksByDrinkName(searchKey);
//
//			HttpSession session = request.getSession();
//			session.setAttribute("displayLoginForm", 1);
//			request.setAttribute("listAllDrinks", listDrinks);
//			switch (searchKey) {
//			case "drink":
//				System.out.println("alo");
//				listDrink = drinkBO.searchDrink();
//				for(int i=0; i<listDrink.size(); i++){
//					System.out.println("Drink: "+listDrink.get(i).getName());
//				}
//				request.setAttribute("listDrink", listDrink);
//				request.getRequestDispatcher("search30.jsp").forward(request, response);
//				break;
//			case "coffee shop":
//				listShop = drinkBO.searchShop();
//				for(int i=0; i<listShop.size(); i++){
//					System.out.println("Coffee shop: "+listShop.get(i).getName());
//				}
//				request.setAttribute("listShop", listShop);
//				request.getRequestDispatcher("search30.jsp").forward(request, response);
//				break;
//			case "hot":
//				System.out.println("hot");
//				listHotDrink = drinkBO.searchHotDrink();
//				for(int i=0; i<listHotDrink.size(); i++){
//					System.out.println("Drink: "+listHotDrink.get(i).getName());
//				}
//				request.setAttribute("listHotDrink", listHotDrink);
//				request.getRequestDispatcher("search30.jsp").forward(request, response);
//				break;
//				
//			case "summer shop":
//				System.out.println("summer shop");
//				listSummerShop = drinkBO.searchShop();
//				for(int i=0; i<listSummerShop.size(); i++){
//					System.out.println("Coffee shop: "+listSummerShop.get(i).getName());
//				}
//				request.setAttribute("listShop", listSummerShop);
//				request.getRequestDispatcher("search30.jsp").forward(request, response);
//				break;
//			default:
//				RequestDispatcher rd = request.getRequestDispatcher("search30.jsp");
//				rd.forward(request, response);
//				break;
//			}
//			
			
			
//			String drinkID = request.getParameter("drinkID");
//			listDrinks = new ArrayList<>();
//			if (drinkID != null) {
//				listDrinks.add(drinkBO.getDrinkByDrinkID(drinkID));
//			} else {
//				searchKey = request.getParameter("searchKey");
//				System.out.println(searchKey);
//				listDrinks = drinkBO.getListAllDrinksByDrinkName(searchKey);
//			}
//			HttpSession session = request.getSession();
//			session.setAttribute("displayLoginForm", 1);
//			request.setAttribute("listAllDrinks", listDrinks);
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.forward(request, response);
//		}
	}

}
