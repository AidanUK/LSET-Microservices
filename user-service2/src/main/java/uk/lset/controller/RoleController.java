package uk.lset.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uk.lset.model.Role;
import uk.lset.request.RoleRequest;
import uk.lset.response.RoleResponse;
import uk.lset.service.RoleService;

@RestController
@CrossOrigin
public class RoleController {
	@Autowired
	private RoleService roleService;

	@PostMapping(path = "/role/add", consumes = "application/json", produces = "application/json")
	private Role createRole(@RequestBody RoleRequest roleRequest) {
		return roleService.createRole(roleRequest);
	}

	@GetMapping(path = "/role/{roleid}", consumes = "application/json", produces = "application/json")
	private Optional<Role> getRole(@PathVariable("roleid") long roleid) {
		return roleService.getRoleByID(roleid);
	}

	@DeleteMapping(path = "/role/delete", consumes = "application/json", produces = "application/json")
	private void deleteRole(@RequestBody RoleRequest roleRequest) {
		roleService.deleteRole(roleRequest.getRoleid());
	}

	@GetMapping(path = "/role/all", consumes = "application/json", produces = "application/json")
	private List<Role> getAllRoles() {
		return roleService.getAllRoles();
	}

	@PutMapping(path = "/role/update", consumes = "application/json", produces = "application/json")
	private RoleResponse updateRole(@RequestBody RoleRequest roleRequest) {
		Role role = roleService.updateRole(roleRequest);

		RoleResponse roleResponse = new RoleResponse();

		if (role == null) {
			roleResponse.setReponseCode("500");
			roleResponse.setReponseMessage("Could not find Role");
		} else {
			roleResponse.setRoleid(role.getRoleid());
			roleResponse.setRole(role.getRole());
			roleResponse.setDescription(role.getDescription());
			roleResponse.setReponseMessage("Sucessfully updated role");
		}
		return roleResponse;
	}
}
