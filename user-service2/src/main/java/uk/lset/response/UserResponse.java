package uk.lset.response;

import java.util.Set;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.lset.model.Role;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
	private UUID userid;
	private String name;
	private String email;
	private String phone;
	private UUID statusid;

	private Set<Role> roles;
	
	private String reponseCode;
	private String reponseMessage;
	
}
