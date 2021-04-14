package formation.controller;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import formation.entity.Formation;
import formation.repositories.FormateurRepository;
import formation.repositories.FormationRepository;
import formation.repositories.ModuleRepository;

@Controller
@RequestMapping("/formation")
public class FormationController {
	@Autowired
	private FormationRepository formationRepository;
	@Autowired
	private FormateurRepository formateurRepository;
	@Autowired
	private ModuleRepository moduleRepository;

	@GetMapping({ "", "/" })
	public ModelAndView list() {
		return new ModelAndView("formation/list", "formations", formationRepository.findAll());
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam Integer id) {
		formationRepository.deleteById(id);
		return new ModelAndView("redirect:/formation");
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goForm(new Formation());
	}

	private ModelAndView goForm(Formation formation) {
		formation.setDateFormation(LocalDate.now());
		ModelAndView modelAndView = new ModelAndView("formation/add", "formation", formation);
		modelAndView.addObject("formateurs", formateurRepository.findAll());
		return modelAndView;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute Formation formation, BindingResult br) {
		if (br.hasErrors()) {
			return goForm(formation);
		}
		System.out.println(formation.getDateFormation());
		formationRepository.save(formation);
		return new ModelAndView("redirect:/formation");
	}

	@GetMapping("/details")
	public ModelAndView details(@RequestParam Integer id) {
		ModelAndView modelAndView = new ModelAndView("formation/details");
		// probleme
		modelAndView.addObject("formation", formationRepository.findByIdWithModules(id).get());
		modelAndView.addObject("formateurs", formateurRepository.findAll());
		modelAndView.addObject("modules", moduleRepository.findAll());
		return modelAndView;

	}
}
