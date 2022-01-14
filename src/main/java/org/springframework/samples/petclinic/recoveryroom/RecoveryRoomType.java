package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_room_types")
public class RecoveryRoomType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@NotEmpty
	@Size(min = 5, max = 50)
	@Column(unique = true)
    private String name;
}
