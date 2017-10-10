package vn.its.dao;

import java.util.ArrayList;

import vn.its.model.User;

public interface UserDAO {

	User login(String userEmail, String userPass);
	
	ArrayList<User> searchLikeLastName(String userLastName);
}
