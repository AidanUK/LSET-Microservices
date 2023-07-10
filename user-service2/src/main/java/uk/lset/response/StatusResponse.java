package uk.lset.response;

import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatusResponse {
	private UUID statusid;
	private String name;
	
	private String reponseCode;
	private String reponseMessage;
}
