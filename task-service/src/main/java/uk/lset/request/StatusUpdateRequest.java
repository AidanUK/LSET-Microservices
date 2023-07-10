package uk.lset.request;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.lset.model.Status;
import uk.lset.model.Task;

@Getter
@Setter
@NoArgsConstructor
public class StatusUpdateRequest {
	private Long statusupdateid;
	private Status fromstatus;
	private Status tostatus;
	private Date changedate;
	private Long changebyuser;
	private String comment;
	private Task task;

}
