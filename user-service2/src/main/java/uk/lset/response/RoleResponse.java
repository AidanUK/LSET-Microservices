package uk.lset.response;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleResponse {
	private String role;
	private String description;
	private UUID roleid;
	
	private String reponseCode;
	private String reponseMessage;
}
