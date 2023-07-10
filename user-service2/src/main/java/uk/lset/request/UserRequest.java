package uk.lset.request;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRequest {
	private Long userid;
	private String name;
	private String email;
	private String phone;
	private Long statusid;

	private List<Long> roleids;
	

}
