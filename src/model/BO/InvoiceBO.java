/**
 * 
 */
package model.BO;

import java.util.ArrayList;

import model.BEAN.Invoice;
import model.DAO.InvoiceDAO;

/**
 * @author Quang Ngo TP
 *
 */
public class InvoiceBO {
	InvoiceDAO invoiceDAO = new InvoiceDAO();
	public boolean addDrink(String invoiceID, int drinkID, int quantity){
		return invoiceDAO.addDrink(invoiceID, drinkID, quantity);
	}
	
	public ArrayList<Invoice> getListInvoice(String invoiceID){
		return invoiceDAO.getInvoiceByInvoiceID(invoiceID);
	}
}
