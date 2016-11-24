/**
 * 
 */
package model.BEAN;

/**
 * @author Quang Ngo TP
 *
 */
public class Invoice {
	private int indexID, drinkID, quantity;
	private String invoiceID;
	private boolean isPaid;

	public Invoice(int indexID, int drinkID, int quantity, String invoiceID, boolean isPaid) {
		this.indexID = indexID;
		this.drinkID = drinkID;
		this.quantity = quantity;
		this.invoiceID = invoiceID;
		this.isPaid = isPaid;
	}

	public Invoice() {
	}

	public int getindexID() {
		return indexID;
	}

	public void setindexID(int indexID) {
		this.indexID = indexID;
	}

	public int getDrinkID() {
		return drinkID;
	}

	public void setDrinkID(int drinkID) {
		this.drinkID = drinkID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getInvoiceID() {
		return invoiceID;
	}

	public void setInvoiceID(String invoiceID) {
		this.invoiceID = invoiceID;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}

	public int getIndexID() {
		return indexID;
	}

}
