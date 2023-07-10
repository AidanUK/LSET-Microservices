package uk.lset.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatusResponse {

	private String reponseCode;
	private String reponseMessage;
	private String name;

}
