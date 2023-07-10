package uk.lset.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class StatusRequest {
	private Long statusid;
	private String name;
}
