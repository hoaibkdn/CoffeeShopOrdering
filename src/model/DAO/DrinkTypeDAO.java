/**
 * 
 */
package model.DAO;

import java.sql.*;
import java.util.ArrayList;

import model.BEAN.DrinkType;
import utilities.Utilities;

/**
 * @author Quang Ngo TP
 *
 */
public class DrinkTypeDAO extends Database{
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;
	
	public ArrayList<DrinkType> getDrinkTypeByID(String drinkTypeIDInput){
		String sql = "SELECT * FROM DrinkType";
		ArrayList<DrinkType> listDrinkTypes = null;;
		if ("all".equals(drinkTypeIDInput)){
			try {
				preparedStatement = connection.prepareStatement(sql);
				resultSet = preparedStatement.executeQuery();
				listDrinkTypes = new ArrayList<>();
				while (resultSet.next()){
					int drinkTypeID = resultSet.getInt(1);
					String drinkTypeName = resultSet.getString(2);
					listDrinkTypes.add(new DrinkType(drinkTypeID, drinkTypeName));
				}
//				Utilities.closeAfterQueried(preparedStatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			sql = sql + " WHERE DrinkTypeID=?";
			try {
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, drinkTypeIDInput);
				resultSet = preparedStatement.executeQuery();
				listDrinkTypes = new ArrayList<>();
				if (resultSet.next()){
					int drinkTypeID = resultSet.getInt(1);
					String drinkTypeName = resultSet.getString(2);
					listDrinkTypes.add(new DrinkType(drinkTypeID, drinkTypeName));
				}
//				Utilities.closeAfterQueried(preparedStatement);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listDrinkTypes;
	}
}
