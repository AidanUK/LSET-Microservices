package uk.lset.foreignmodel;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Role {

	private Long roleid;
	private String role;
	private String description;
	private Set<User> user;

}
