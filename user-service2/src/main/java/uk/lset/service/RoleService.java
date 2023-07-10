package uk.lset.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.lset.model.Role;
import uk.lset.repository.RoleRepository;
import uk.lset.request.RoleRequest;

@Service
public class RoleService {

	@Autowired
	private RoleRepository roleRepository;

	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	public Role createRole(RoleRequest roleRequest) {
		Role role = new Role();
		role.setRole(roleRequest.getRole());
		role.setDescription(roleRequest.getDescription());
		return roleRepository.save(role);
	}

	public Optional<Role> getRoleByID(Long roleID) {
		return roleRepository.findById(roleID);
	}

	public List<Role> getRole(String role) {
		return roleRepository.findByRole(role);
	}

	public void deleteRole(Long roleID) {
		roleRepository.deleteById(roleID);
	}

	public Role updateRole(RoleRequest roleRequest) {
		Role role = getRoleByID(roleRequest.getRoleid()).get();
		if (role == null) {
			return null;
		}
		if (roleRequest.getDescription() != null && !roleRequest.getDescription().isBlank()) {
			role.setDescription(roleRequest.getDescription());
		}
		if (roleRequest.getRole() != null) {
			role.setRole(roleRequest.getRole());
		}

		return roleRepository.save(role);
	}
}
