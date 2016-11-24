package model.BEAN;

public class CoffeeShop {
	private int ShopID;
	private String Name;
	private String Detail;
	public int getShopID() {
		return ShopID;
	}
	public void setShopID(int shopID) {
		ShopID = shopID;
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
	public CoffeeShop(int shopID, String name, String detail) {
		super();
		ShopID = shopID;
		Name = name;
		Detail = detail;
	}
	
	
}
