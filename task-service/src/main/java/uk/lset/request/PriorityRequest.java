package uk.lset.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriorityRequest {
	private Long priorityid;
	private Long priority;
	private String prioritydesc;
}
