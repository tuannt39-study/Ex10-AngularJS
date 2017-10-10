package vn.its.resource;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import vn.its.dao.UserDAOImp;
import vn.its.model.User;

@Path("user")
public class UserResource {

	private UserDAOImp userDAOImp = new UserDAOImp();

	// http://localhost:8080/Ex10/webresources/user
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getIt() {
		return "Got it user!";
	}

	// http://localhost:8080/Ex10/webresources/user/check?usermail=tuan@gmail.com&userpass=1234
	@GET
	@Path("check")
	@Produces(MediaType.APPLICATION_JSON)
	public String check(@QueryParam("usermail") String usermail, @QueryParam("userpass") String userpass) {
		boolean result = (userDAOImp.login(usermail, userpass) != null);
		if (result) {
			return "true";
		}
		return "false";
	}

	// http://localhost:8080/Ex10/webresources/user/searchLastName?name=uy
	@GET
	@Path("searchLastName")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<User> searchLastName(@QueryParam("name") String name) {
		ArrayList<User> result = userDAOImp.searchLikeLastName(name);
		return result;
	}
}
