package formation.sopra.formationSrpingBoot.controllers.rest;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSrpingBoot.entities.Formateur;
import formation.sopra.formationSrpingBoot.exceptions.FormateurInvalidException;
import formation.sopra.formationSrpingBoot.repositories.FormateurRepository;

@RestController
@RequestMapping("/api/formateur")
public class FormateurRestController {

	@Autowired
	private FormateurRepository formateurRepository;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Formateur> getAllFormateur() {
		return formateurRepository.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Formateur getFormateur(@PathVariable("id") Integer id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new FormateurInvalidException();
		}
	}

	@GetMapping("/{id}/referent")
	@JsonView(Views.FormateurAvecFormationReferent.class)
	public Formateur getFormateurAvecFormationEnReferent(@PathVariable("id") Integer id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new FormateurInvalidException();
		}
	}

	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	@JsonView(Views.Common.class)
	public Formateur addFormateur(@Valid @RequestBody Formateur formateur, BindingResult br) {
		if (br.hasErrors()) {
			throw new FormateurInvalidException();
		}
		return formateurRepository.save(formateur);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Formateur update(@Valid @RequestBody Formateur formateur, BindingResult br, @PathVariable("id") Integer id) {
		if (br.hasErrors()) {
			throw new FormateurInvalidException();
		}
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent()) {
			formateur.setId(id);
			formateur.setVersion(opt.get().getVersion());
			return formateurRepository.save(formateur);
		}
		throw new FormateurInvalidException();
	}

	@JsonView(Views.Common.class)
	@PatchMapping("/{id}")
	public Formateur update(@RequestBody Map<String, Object> fields, @PathVariable("id") Integer id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent()) {
			Formateur formateur = opt.get();
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Formateur.class, key);
				ReflectionUtils.makeAccessible(field);
				ReflectionUtils.setField(field, formateur, value);
			});
			return formateurRepository.save(formateur);
		}
		throw new FormateurInvalidException();
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		Optional<Formateur> opt = formateurRepository.findById(id);
		if (opt.isPresent()) {
			formateurRepository.deleteById(id);
		} else {
			throw new FormateurInvalidException();
		}
	}
}
