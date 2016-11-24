/**
 * 
 */
package model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BEAN.Member;

/**
 * @author Quang Ngo TP
 *
 */
public class MemberDAO extends Database{
	private PreparedStatement preparedStatement = null;
	
	public Member getMemberByMemberID(String memberIDInput){
		Member member = null;
		String sql = "SELECT * FROM member WHERE MemberID=?";
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, memberIDInput);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()){
				String memberID = resultSet.getString(1);
				String password = resultSet.getString(2);
				String fullName = resultSet.getString(3);
				String dateOfBirth = resultSet.getString(4);
				int gender = resultSet.getInt(5);
				String address = resultSet.getString(6);
				String phoneNumber = resultSet.getString(7);
				String career = resultSet.getString(8);
				String email = resultSet.getString(9);
				String avatar = resultSet.getString(10);
				int accumulatedPoint = resultSet.getInt(11);
				int bonusPoint = resultSet.getInt(12);
				member = new Member(memberID, password, fullName, dateOfBirth, address, phoneNumber, career, email, avatar, gender, accumulatedPoint, bonusPoint);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}

}
