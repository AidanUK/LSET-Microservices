package uk.lset.model;

import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Parameter;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "statusupdate")
@Getter
@Setter
@NoArgsConstructor
public class StatusUpdate {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
	@JdbcTypeCode(SqlTypes.UUID)
	@Column(name = "statusupdate_id")
	private UUID statusupdateid;

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Status fromstatus;
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Status tostatus;

	private Date changedate;
	//@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Long changebyuser;
	private String comment;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id")
	private Task task;

}
