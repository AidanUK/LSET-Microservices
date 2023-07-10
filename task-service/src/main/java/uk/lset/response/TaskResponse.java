package uk.lset.response;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.lset.foreignmodel.User;
import uk.lset.model.Priority;

@Getter
@Setter
@NoArgsConstructor
public class TaskResponse {

	private String reponseCode;
	private String reponseMessage;

	private String taskid;
	private Long assignee;
	private User approver;
	private String description;
	private Integer sumissioncounter;
	private Date deadlinedate;
	private Priority priority;
}
