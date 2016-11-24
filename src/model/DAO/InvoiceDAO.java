/**
 * 
 */
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.BEAN.Invoice;
import utilities.Utilities;

/**
 * @author Quang Ngo TP
 *
 */
public class InvoiceDAO extends Database {
	PreparedStatement preparedStatement = null;

	public ArrayList<Invoice> getInvoiceByInvoiceID(String invoiceIDInput) {
		ArrayList<Invoice> invoiceList = null;
		String sql = "SELECT * FROM invoice WHERE InvoiceID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, invoiceIDInput);
			ResultSet resultSet = preparedStatement.executeQuery();
			invoiceList = new ArrayList<>();
			while (resultSet.next()) {
				int indexID = resultSet.getInt(1);
				String invoiceID = resultSet.getString(2);
				int drinkID = resultSet.getInt(3);
				int quantity = resultSet.getInt(4);
				int isPaid = resultSet.getInt(5);
				invoiceList.add(new Invoice(indexID, drinkID, quantity, invoiceID, isPaid == 0 ? false : true));
//				Utilities.closeAfterQueried(preparedStatement);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return invoiceList;
	}
	
	public Invoice getInvoiceByInvoiceIDAndDrinkID(String invoiceIDInput, int drinkIDInput) {
		String sql = "SELECT * FROM invoice WHERE InvoiceID=? AND DrinkID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, invoiceIDInput);
			preparedStatement.setInt(2, drinkIDInput);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int indexID = resultSet.getInt(1);
				String invoiceID = resultSet.getString(2);
				int drinkID = resultSet.getInt(3);
				int quantity = resultSet.getInt(4);
				int isPaid = resultSet.getInt(5);
//				Utilities.closeAfterQueried(preparedStatement);
				return new Invoice(indexID, drinkID, quantity, invoiceID, isPaid == 0 ? false : true);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean addDrink(String invoiceID, int drinkID, int quantity) {
		if (quantity == 0){
			Invoice invoice = getInvoiceByInvoiceIDAndDrinkID(invoiceID, drinkID);
			if (invoice == null){
				return true;
			}
			int indexID = invoice.getIndexID();
			String sqlDelete = "DELETE FROM invoice WHERE IndexID=?";
			try {
				preparedStatement = connection.prepareStatement(sqlDelete);
				preparedStatement.setInt(1, indexID);
				return preparedStatement.executeUpdate() > 0 ? true : false;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}		
		}
		String sql = "SELECT * FROM invoice WHERE InvoiceID = ? AND DrinkID = ?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, invoiceID);
			preparedStatement.setInt(2, drinkID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				preparedStatement = connection.prepareStatement("UPDATE invoice SET Quantity='" + quantity
						+ "' WHERE InvoiceID='" + invoiceID + "' AND DrinkID='" + drinkID + "'");
				return preparedStatement.executeUpdate() > 0 ? true : false;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		sql = "INSERT INTO invoice(InvoiceID, DrinkID, Quantity) VALUES (?,?,?)";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, invoiceID);
			preparedStatement.setInt(2, drinkID);
			preparedStatement.setInt(3, quantity);
			return preparedStatement.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean changePaymentStatus(String invoiceID){
		String sql = "UPDATE invoice SET IsPaid=1 WHERE InvoiceID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, invoiceID);
			return preparedStatement.executeUpdate() > 0 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
