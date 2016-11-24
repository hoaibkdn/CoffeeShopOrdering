/**
 * 
 */
package model.BEAN;

/**
 * @author Quang Ngo TP
 *
 */
public class Drink {
	private int drinkID, drinkTypeID;
	private String name, image, dateAdded, detail;
	private double price;

	public Drink(int drinkID, int drinkTypeID, String name, String image, String dateAdded, String detail,
			double price) {
		this.drinkID = drinkID;
		this.drinkTypeID = drinkTypeID;
		this.name = name;
		this.image = image;
		this.dateAdded = dateAdded;
		this.detail = detail;
		this.price = price;
	}

	public Drink() {
	}

	public int getDrinkID() {
		return drinkID;
	}

	public void setDrinkID(int drinkID) {
		this.drinkID = drinkID;
	}

	public int getDrinkTypeID() {
		return drinkTypeID;
	}

	public void setDrinkTypeID(int drinkTypeID) {
		this.drinkTypeID = drinkTypeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
