/**
 * 
 */
package model.BO;

import java.util.ArrayList;

import model.BEAN.Drink;
import model.DAO.DrinkDAO;
import model.BEAN.*;

/**
 * @author Quang Ngo TP
 *
 */
public class DrinkBO {
	DrinkDAO drinkDAO = new DrinkDAO();
	
	public ArrayList<Drink> getListAllDrinks(){
		return drinkDAO.getListDrinks("");
	}
	
	public ArrayList<Drink> getListAllDrinksOfType(String typeID){
		return drinkDAO.getListDrinks(typeID);
	}

	/**
	 * @param searchKey
	 * @return
	 */
	public ArrayList<Drink> getListAllDrinksByDrinkName(String searchKey) {
		return drinkDAO.getListAllDrinksByDrinkName(searchKey);
	}

	/**
	 * @param drinkID
	 * @return
	 */
	public Drink getDrinkByDrinkID(String drinkID) {
		return drinkDAO.getDrinkByDrinkID(drinkID);
	}
	
	public ArrayList<Drink30> searchDrink() {
		return drinkDAO.searchDink();
	}
	
	public ArrayList<CoffeeShop> searchShop() {
		return drinkDAO.searchShop();
	}
	
	public ArrayList<Drink30> searchHotDrink(){
		return drinkDAO.searchHotDink();
	}
	
	public ArrayList<CoffeeShop> searchSummerShop(){
		return drinkDAO.searchSummerShop();
	}
}
