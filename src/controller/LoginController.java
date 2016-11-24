package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BEAN.Member;
import model.BO.MemberBO;

/**
 * Servlet implementation class LoginAjaxController
 */
@WebServlet(name = "login", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberBO memberBO = new MemberBO();
		String memberID = request.getParameter("memberID");
		String password = request.getParameter("password");
		String act = request.getParameter("act");
		if (act == null) {
			act = "";
		}
		Member member = memberBO.getMemberByMemberID(memberID);
		switch (act) {
		case "loginByQRCode":
			request.getRequestDispatcher("/WEB-INF/QRCodeScanner.jsp").include(request, response);
			break;
		case "loginByMemberAccount":
			if (password.equals(member.getPassword())) {
				session.setAttribute("memberLogined", member);
				response.sendRedirect("index.jsp");
			} else {
				String message = "Login failed! Please try again or call our waiter to get help!";
				session.setAttribute("message", message);
				response.sendRedirect("index.jsp");
			}
			break;
		default:
			request.getRequestDispatcher("index.jsp").include(request, response);
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
