package vn.its.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import vn.its.connect.DatabaseConnect;
import vn.its.model.User;

public class UserDAOImp implements UserDAO {
	
	private Connection conn;

	public UserDAOImp() {
		super();
		this.conn = DatabaseConnect.getConnection();
	}

	@Override
	public User login(String userEmail, String userPass) {
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			String login = "SELECT USERID, EMAIL, PASS, FIRSTNAME, LASTNAME, DOB FROM TUAN.USERS WHERE EMAIL = '" + userEmail
					+ "' AND PASS = '" + userPass + "'";
			pstm = conn.prepareStatement(login);
			rs = pstm.executeQuery();
			if (rs.next()) {
				int userID = rs.getInt("USERID");
				userEmail = rs.getString("EMAIL");
				userPass = rs.getString("PASS");
				String userLastName = rs.getString("LASTNAME");
				String userFirstName = rs.getString("FIRSTNAME");
				Date userDob = rs.getDate("DOB");
				User user = new User(userID, userEmail, userPass, userLastName, userFirstName, userDob);
				return user;
			}
		} catch (SQLException ex) {
			Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return null;
	}

	@Override
	public ArrayList<User> searchLikeLastName(String name) {
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			String searchLikeLastName = "SELECT USERID, EMAIL, PASS, LASTNAME, FIRSTNAME, DOB " + "FROM TUAN.USERS "
					+ "WHERE LASTNAME LIKE ?";
			pstm = conn.prepareStatement(searchLikeLastName);
			pstm.setString(1, "%" + name + "%");
			rs = pstm.executeQuery();
			ArrayList<User> list = new ArrayList<User>();
			while (rs.next()) {
				int userID = rs.getInt("USERID");
				String userEmail = rs.getString("EMAIL");
				String userPass = rs.getString("PASS");
				String userLastName = rs.getString("LASTNAME");
				String userFirstName = rs.getString("FIRSTNAME");
				Date userDob = rs.getDate("DOB");
				User user = new User(userID, userEmail, userPass, userLastName, userFirstName, userDob);
				list.add(user);
			}
			return list;
		} catch (SQLException ex) {
			Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			try {
				pstm.close();
			} catch (SQLException ex) {
				Logger.getLogger(UserDAOImp.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return null;
	}
}
