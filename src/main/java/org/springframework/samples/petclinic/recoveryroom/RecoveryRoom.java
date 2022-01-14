package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms")
public class RecoveryRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	
	@NotNull
	@Size(min = 3, max = 50)
    private String name;
	
	@PositiveOrZero
    private double size;
	
	@NotNull
    private boolean secure;
    
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name="room_type")
    private RecoveryRoomType roomType;
}
