package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.InvoiceBO;

/**
 * Servlet implementation class GetOrderAjaxServlet
 */
@WebServlet(name = "getorder", urlPatterns = { "/getorder" })
public class GetOrderAjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetOrderAjaxController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		InvoiceBO invoiceBO = new InvoiceBO();
		PrintWriter out = null;
		try {
			out = response.getWriter();
			String orderInfo = request.getParameter("orderInfo");
			System.out.println("Order Information: " + orderInfo);
			// System.out.println(orderInfo);
			String orderInfoArray[] = orderInfo.split(",");
			int sizeOfOrderInfoArray = orderInfoArray.length;
			int drinkID[] = new int[sizeOfOrderInfoArray - 1];
			int drinkQuantity[] = new int[sizeOfOrderInfoArray - 1];
			String invoiceID = orderInfoArray[0];
			for (int i = 1; i < sizeOfOrderInfoArray; i++) {
				drinkID[i - 1] = Integer.parseInt(orderInfoArray[i].split("-")[0]);
				drinkQuantity[i - 1] = Integer.parseInt(orderInfoArray[i].split("-")[1]);
				System.out.println(drinkQuantity[i - 1]);
			}
			for (int i = 0; i < sizeOfOrderInfoArray - 1; i++) {
				if (!invoiceBO.addDrink(invoiceID, drinkID[i], drinkQuantity[i])) {
					System.out.println("Error!");
					out.print(
							"Order failed due to an error in our system!\n"
							+ "Please press Order button again or call our waiter for help."
									+ " Thank you for coming and using our service!");
					return;
				}
			}
			System.out.println("Succeed!");
			if (invoiceBO.getListInvoice(invoiceID).size() > 0){
				out.print("Order succeeded!\n"
						+ "Please wait for about 10-15 minutes to get your drinks."
						+ " Thank you for coming and using our service!");
			} else {
				out.print("Please choose some our nice drinks to order, then press Order button!");
			}			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println(e.getMessage());
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
