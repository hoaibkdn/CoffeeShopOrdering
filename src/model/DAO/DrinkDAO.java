/**
 * 
 */
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.*;

import model.BEAN.*;
import model.DAO.OpenOWL;

/**
 * @author Quang Ngo TP
 *
 */
public class DrinkDAO extends Database {
	PreparedStatement preparedStatement = null;

	public ArrayList<Drink> getListDrinks(String typeID) {
		String sql = "SELECT * FROM drink";
		ArrayList<Drink> listDrinks = null;
		if ("".equals(typeID)) {
			try {
				preparedStatement = connection.prepareStatement(sql);
				ResultSet resultSet = preparedStatement.executeQuery();
				listDrinks = new ArrayList<>();
				while (resultSet.next()) {
					int drinkID = resultSet.getInt(1);
					int drinkTypeID = resultSet.getInt(2);
					String name = resultSet.getString(3);
					String image = resultSet.getString(4);
					String dateAdded = resultSet.getString(5);
					double price = resultSet.getDouble(6);
					String detail = resultSet.getString(7);
					listDrinks.add(new Drink(drinkID, drinkTypeID, name, image, dateAdded, detail, price));
				}
				// Utilities.closeAfterQueried(preparedStatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			sql = sql + " WHERE DrinkTypeID=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, typeID);
				ResultSet resultSet = preparedStatement.executeQuery();
				listDrinks = new ArrayList<>();
				while (resultSet.next()) {
					int drinkID = resultSet.getInt(1);
					int drinkTypeID = resultSet.getInt(2);
					String name = resultSet.getString(3);
					String image = resultSet.getString(4);
					String dateAdded = resultSet.getString(5);
					double price = resultSet.getDouble(6);
					String detail = resultSet.getString(7);
					listDrinks.add(new Drink(drinkID, drinkTypeID, name, image, dateAdded, detail, price));
				}
				// Utilities.closeAfterQueried(preparedStatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listDrinks;
	}

	public static void main(String[] args) {
		DrinkDAO drinkDAO = new DrinkDAO();
		ArrayList<Drink> listDrinks = drinkDAO.getListDrinks("");
		for (Drink drink : listDrinks) {
			System.out.println(drink.getName() + "\t" + drink.getDrinkTypeID());
		}
	}

	/**
	 * @param searchKey
	 * @return
	 */
	public ArrayList<Drink> getListAllDrinksByDrinkName(String searchKey) {
		ArrayList<Drink> listDrinks = null;
		String sql = "SELECT * FROM drink WHERE Name LIKE '%" + searchKey + "%'";
		try {
			preparedStatement = connection.prepareStatement(sql);
			// preparedStatement.setString(1, searchKey);
			ResultSet resultSet = preparedStatement.executeQuery();
			listDrinks = new ArrayList<>();
			while (resultSet.next()) {
				int drinkID = resultSet.getInt(1);
				int drinkTypeID = resultSet.getInt(2);
				String name = resultSet.getString(3);
				String image = resultSet.getString(4) == null ? "" : resultSet.getString(4);
				String dateAdded = resultSet.getString(5);
				float price = resultSet.getFloat(6);
				String detail = resultSet.getString(7);
				listDrinks.add(new Drink(drinkID, drinkTypeID, name, image, dateAdded, detail, price));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return listDrinks;
	}

	/**
	 * @param drinkID
	 * @return
	 */
	public Drink getDrinkByDrinkID(String drinkID) {
		String sql = "SELECT * FROM drink WHERE DrinkID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, drinkID);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				int drinkID1 = resultSet.getInt(1);
				int drinkTypeID = resultSet.getInt(2);
				String name = resultSet.getString(3);
				String image = resultSet.getString(4) == null ? "" : resultSet.getString(4);
				String dateAdded = resultSet.getString(5);
				float price = resultSet.getFloat(6);
				String detail = resultSet.getString(7);
				return new Drink(drinkID1, drinkTypeID, name, image, dateAdded, detail, price);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	//search 3.0
	OpenOWL openOWL = new OpenOWL();
	//Fuseki
	//search
	 public ArrayList<Drink30> searchDink(){
		 String query="PREFIX cf: <http://www.semanticweb.org/hoaitruong/ontologies/2016/9/coffeeshop#> "
		 		+ "SELECT ?Name WHERE {?HighLand cf:Name ?Name} Group by ?Name";
		 System.out.println(query);
		 com.hp.hpl.jena.query.ResultSet results = openOWL.ExecSparQl(query);
		ArrayList<Drink30> listDrink = new ArrayList<Drink30>();
			System.out.println("excute query");
			String x = "^^http://www.w3.org/2001/XMLSchema#string";
			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				String name = soln.get("Name").toString();
				String[] nameCut = name.split("^^");
				String subName = name.substring(0, name.length()-x.length());
				// test --
				System.out.println("Name of Drink: " + subName);
				Drink30 a_Drink = new Drink30(1, null, subName, null);
				
				listDrink.add(a_Drink);
			}
		 return listDrink;
	 }
	 
	 //search drink hot
	 public ArrayList<Drink30> searchHotDink(){
		 String query="PREFIX cf: <http://www.semanticweb.org/hoaitruong/ontologies/2016/9/coffeeshop#> "
		 		+ "SELECT ?Name WHERE { ?Name cf:HowToUse ?Hot } group by ?Name";
		 System.out.println(query);
		 com.hp.hpl.jena.query.ResultSet results = openOWL.ExecSparQl(query);
		 ArrayList<Drink30> listDrink = new ArrayList<Drink30>();
			System.out.println("excute query");
			String x = "http://www.semanticweb.org/hoaitruong/ontologies/2016/9/coffeeshop#";
			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				String name = soln.get("Name").toString();
				String[] nameCut = name.split("#");
				System.out.println("Name of hot drink: " + nameCut[1]);
				Drink30 a_Drink = new Drink30(1, null, nameCut[1], null);
				if("Hot".equalsIgnoreCase(nameCut[1]) || "Cold".equalsIgnoreCase(nameCut[1])){
					System.out.println("Cut: "+nameCut[1]);
//					listDrink.add(a_Drink);
				}else listDrink.add(a_Drink);
			}
		 return listDrink;
	 }
	 
	 public ArrayList<CoffeeShop> searchShop(){
		 String query="PREFIX cf: <http://www.semanticweb.org/hoaitruong/ontologies/2016/9/coffeeshop#> "
		 		+ "SELECT ?Name "
		 		+ "WHERE {?HighLand cf:Savour ?Name} "
		 		+ "Group by ?Name";
		 System.out.println(query);
		 com.hp.hpl.jena.query.ResultSet results = openOWL.ExecSparQl(query);
		ArrayList<CoffeeShop> listShop = new ArrayList<CoffeeShop>();
			System.out.println("excute query");
			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				String name = soln.get("Name").toString();
				String[] nameCut = name.split("#");
				System.out.println("Name of shop: " + nameCut[1]);
				
				// test --
				System.out.println("Name of Shop: " + nameCut[1]);
				CoffeeShop a_Shop = new CoffeeShop(0, nameCut[1], null);
				
				listShop.add(a_Shop);
			}
		 return listShop;
	 }
	 
	 //search summer shop
	 public ArrayList<CoffeeShop> searchSummerShop(){
		 String query="PREFIX cf: <http://www.semanticweb.org/hoaitruong/ontologies/2016/9/coffeeshop#> "
		 		+ "SELECT ?Name WHERE { ?Summer cf:Weather ?Name } group by ?Name";
		 System.out.println(query);
		 com.hp.hpl.jena.query.ResultSet results = openOWL.ExecSparQl(query);
		ArrayList<CoffeeShop> listShop = new ArrayList<CoffeeShop>();
			System.out.println("excute query");
			while (results.hasNext()) {
				QuerySolution soln = results.nextSolution();
				String name = soln.get("Name").toString();
				String[] nameCut = name.split("#");
				System.out.println("Name of shop: " + nameCut[1]);
				
				// test --
				System.out.println("Name of Shop: " + nameCut[1]);
				CoffeeShop a_Shop = new CoffeeShop(0, nameCut[1], null);
				
				listShop.add(a_Shop);
			}
		 return listShop;
	 }
}
