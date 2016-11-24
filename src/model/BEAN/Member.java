/**
 * 
 */
package model.BEAN;

/**
 * @author Quang Ngo TP
 *
 */
public class Member {
	private String memberID, password, fullName, dateOfBirth, address, phoneNumber, career, email, avatar;
	private int gender, accumulatedPoint, bonusPoint;

	public Member() {
	}

	public Member(String memberID, String password, String fullName, String dateOfBirth, String address,
			String phoneNumber, String career, String email, String avatar, int gender, int accumulatedPoint,
			int bonusPoint) {
		this.memberID = memberID;
		this.password = password;
		this.fullName = fullName;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.career = career;
		this.email = email;
		this.avatar = avatar;
		this.gender = gender;
		this.accumulatedPoint = accumulatedPoint;
		this.bonusPoint = bonusPoint;
	}

	public String getMemberID() {
		return memberID;
	}

	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getAccumulatedPoint() {
		return accumulatedPoint;
	}

	public void setAccumulatedPoint(int accumulatedPoint) {
		this.accumulatedPoint = accumulatedPoint;
	}

	public int getBonusPoint() {
		return bonusPoint;
	}

	public void setBonusPoint(int bonusPoint) {
		this.bonusPoint = bonusPoint;
	}
}
