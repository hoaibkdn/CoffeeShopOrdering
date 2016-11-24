/**
 * 
 */
package model.BEAN;

/**
 * @author Hoai Truong
 *
 */
public class Drink30 {
	private int DrinkID;
	private String Avatar;
	private String Name;
	private String Detail;
	public int getDrinkID() {
		return DrinkID;
	}
	public void setDrinkID(int drinkID) {
		DrinkID = drinkID;
	}
	public String getAvatar() {
		return Avatar;
	}
	public void setAvatar(String avatar) {
		Avatar = avatar;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDetail() {
		return Detail;
	}
	public void setDetail(String detail) {
		Detail = detail;
	}
	public Drink30(int drinkID, String avatar, String name, String detail) {
		super();
		DrinkID = drinkID;
		Avatar = avatar;
		Name = name;
		Detail = detail;
	}
	
	
}
