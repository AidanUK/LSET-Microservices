package uk.lset.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uk.lset.model.User;
import uk.lset.request.UserRequest;
import uk.lset.response.TaskUserResponse;
import uk.lset.response.UserResponse;
import uk.lset.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/user/all")
	private List<User> getAllUsers() {
		return userService.getAllUsers();
	}

	@GetMapping(path = "/user/{userid}", consumes = "application/json", produces = "application/json")
	private User getUser(@PathVariable("userid") long userid) {
		return userService.getUser(userid);
	}

	@GetMapping(path = "/taskuser/{userid}", consumes = "application/json", produces = "application/json")
	private TaskUserResponse getTaskUser(@PathVariable("userid") long userid) {
		User user = userService.getUser(userid);
		TaskUserResponse taskUserResponse = new TaskUserResponse();
		if (user != null) {
			taskUserResponse.setUserid(user.getUserid());
			taskUserResponse.setName(user.getName());
		}
		return taskUserResponse;
	}

	@PostMapping(path = "/user/add", consumes = "application/json", produces = "application/json")
	private User createUser(@RequestBody UserRequest userRequest) {
		return userService.createUser(userRequest);
	}

	@PutMapping(path = "/user/update", consumes = "application/json", produces = "application/json")
	private UserResponse updateUser(@RequestBody UserRequest userRequest) {

		User user = userService.updateUser(userRequest);

		UserResponse userResponse = new UserResponse();

		if (user == null) {
			userResponse.setReponseCode("500");
			userResponse.setReponseMessage("Could not find User");
		} else {
			userResponse.setUserid(user.getUserid());
			userResponse.setName(user.getName());
			userResponse.setPhone(user.getPhone());
			userResponse.setEmail(user.getEmail());
			userResponse.setStatusid(user.getStatus().getStatusid());
			userResponse.setRoles(user.getUser_roles());
			userResponse.setReponseMessage("Sucessfully updated user");
		}
		return userResponse;
	}
}
