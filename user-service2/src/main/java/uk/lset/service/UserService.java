package uk.lset.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.lset.model.Role;
import uk.lset.model.User;
import uk.lset.repository.RoleRepository;
import uk.lset.repository.StatusRepository;
import uk.lset.repository.UserRepository;
import uk.lset.request.UserRequest;

@Service
public class UserService {
	// private static final Logger logger =
	// LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private StatusRepository statusRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User createUser(UserRequest userRequest) {

		User user = new User();
		user.setName(userRequest.getName());
		user.setPhone(userRequest.getPhone());
		user.setEmail(userRequest.getEmail());

		user.setStatus(statusRepository.findById(userRequest.getStatusid()).orElse(null));

		Set<Role> userroles = new HashSet<Role>();
		for (Long roleid : userRequest.getRoleids()) {
			userroles.add(roleRepository.findById(roleid).orElse(null));
		}
		user.setUser_roles(userroles);
		return userRepository.save(user);
	}

	public User getUser(Long userID) {
		return userRepository.findById(userID).orElse(null);

	}

	public User updateUser(UserRequest userRequest) {
		User user = getUser(userRequest.getUserid());
		if (user == null) {
			return null;
		}

		if (userRequest.getName() != null && !userRequest.getName().isBlank()) {
			user.setName(userRequest.getName());
		}
		if (userRequest.getPhone() != null) {
			user.setPhone(userRequest.getPhone());
		}
		if (userRequest.getEmail() != null) {
			user.setEmail(userRequest.getEmail());
		}

		if (userRequest.getStatusid() != null) {
			user.setStatus(statusRepository.findById(userRequest.getStatusid()).orElse(null));
		}

		if (userRequest.getRoleids() != null) {
			Set<Role> userroles = new HashSet<Role>();
			for (Long roleid : userRequest.getRoleids()) {
				userroles.add(roleRepository.findById(roleid).orElse(null));
			}
			user.setUser_roles(userroles);
		}

		return userRepository.save(user);

	}

}
