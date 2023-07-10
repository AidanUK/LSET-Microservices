package uk.lset.response;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.lset.model.Task;

@Getter
@Setter
@NoArgsConstructor
public class TaskCommentResponse {
	
	private String reponseCode;
	private String reponseMessage;
	
	private String taskcommentid;
	private Task task;
	private Long userid;
	private String comment;
	private Date date;
	private Long taskstatus;
}
