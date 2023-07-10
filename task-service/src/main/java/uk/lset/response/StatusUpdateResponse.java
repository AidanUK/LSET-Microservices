package uk.lset.response;

import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.lset.model.Status;
import uk.lset.model.Task;

@Getter
@Setter
@NoArgsConstructor
public class StatusUpdateResponse {
	private String statusupdateid;
	private Status fromstatus;
	private Status tostatus;
	private Date changedate;
	private Long changebyuser;
	private String comment;
	private Task task;
	private String reponseCode;
	private String reponseMessage;
}
