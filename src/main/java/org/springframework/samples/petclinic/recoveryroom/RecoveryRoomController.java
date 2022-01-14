package org.springframework.samples.petclinic.recoveryroom;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetType;
import org.springframework.samples.petclinic.pet.exceptions.DuplicatedPetNameException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {

	private static final String VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

	private RecoveryRoomService recoveryRoomService;

	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomService) {
		this.recoveryRoomService = recoveryRoomService;
	}

	@GetMapping(value = "/recoveryroom/create")
	public String initCreationForm(ModelMap model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		List<RecoveryRoomType> listRoomTypes = recoveryRoomService.getAllRecoveryRoomTypes();
		model.put("recoveryRoom", recoveryRoom);
		model.put("types", listRoomTypes);
		return VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			List<RecoveryRoomType> listRoomTypes = recoveryRoomService.getAllRecoveryRoomTypes();
			model.put("recoveryRoom", recoveryRoom);
			model.put("types", listRoomTypes);
			return VIEWS_RECOVERY_ROOMS_CREATE_OR_UPDATE_FORM;
		} else {
			this.recoveryRoomService.save(recoveryRoom);
			return "welcome";
		}
	}
}
