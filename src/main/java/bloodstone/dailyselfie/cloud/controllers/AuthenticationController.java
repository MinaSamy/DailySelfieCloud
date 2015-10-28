package bloodstone.dailyselfie.cloud.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bloodstone.dailyselfie.cloud.model.LoginResponse;
import bloodstone.dailyselfie.cloud.model.UserRegistration;

@Controller
public class AuthenticationController {

	private String[] users = new String[] { "user1@user.com", "user2@user.com", "user3@user.com" };

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public @ResponseBody LoginResponse login(@RequestParam String userName, @RequestParam String password) {
		LoginResponse response = new LoginResponse();
		if (userName != null && password != null) {
			for (int i = 0; i < users.length; i++) {
				if (users[i].equalsIgnoreCase(userName)) {
					response.setResult(true);
					response.setUserId("User " + String.valueOf(i));
					break;
				}
			}
		}
		return response;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public @ResponseBody boolean register(@RequestBody UserRegistration user) {
		boolean result = false;
		if (user.getUserName() != null && user.getPassowrd() != null && user.getDisplayName() != null) {
			result = true;
			for (int i = 0; i < users.length; i++) {
				if (users[i].equalsIgnoreCase(user.getUserName())) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
}
