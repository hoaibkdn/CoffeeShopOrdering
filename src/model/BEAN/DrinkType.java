/**
 * 
 */
package model.BEAN;

/**
 * @author Quang Ngo TP
 *
 */
public class DrinkType {
	private int drinkTypeID;
	private String drinkTypeName;

	public DrinkType(int drinkTypeID, String drinkTypeName) {
		this.drinkTypeID = drinkTypeID;
		this.drinkTypeName = drinkTypeName;
	}

	public DrinkType() {
	}

	public int getDrinkTypeID() {
		return drinkTypeID;
	}

	public void setDrinkTypeID(int drinkTypeID) {
		this.drinkTypeID = drinkTypeID;
	}

	public String getDrinkTypeName() {
		return drinkTypeName;
	}

	public void setDrinkTypeName(String drinkTypeName) {
		this.drinkTypeName = drinkTypeName;
	}
}
