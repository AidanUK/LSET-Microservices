package uk.lset.request;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TaskRequest {
	private Long taskid;
	private Long assignee;
	private Long approver;
	private String description;
	private Integer sumissioncounter;
	private Date deadlinedate;
	private Long priority;
}
