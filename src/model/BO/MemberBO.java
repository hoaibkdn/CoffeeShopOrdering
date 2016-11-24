/**
 * 
 */
package model.BO;

import model.BEAN.Member;
import model.DAO.MemberDAO;

/**
 * @author Quang Ngo TP
 *
 */
public class MemberBO {
	MemberDAO memberDAO = new MemberDAO();
	
	public Member getMemberByMemberID(String memberIDInput){
		return memberDAO.getMemberByMemberID(memberIDInput);
	}

}
