package uk.lset.request;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.lset.model.Task;

@Getter
@Setter
@NoArgsConstructor
public class TaskCommentRequest {
	private Long taskcommentid;
	private Task task;
	private Long userid;
	private String comment;
	private Date date;
	private Long taskstatus;
}
