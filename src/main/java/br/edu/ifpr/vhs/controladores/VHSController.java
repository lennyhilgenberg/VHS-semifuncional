package br.edu.ifpr.vhs.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ifpr.vhs.VhsApplication;
import br.edu.ifpr.vhs.entidades.VHS;
import br.edu.ifpr.vhs.repositorios.VHSRepository;
import br.edu.ifpr.vhs.servicos.VHSService;

@Controller
@RequestMapping("/vhs")
public class VHSController {

    private final VhsApplication vhsApplication;

    @Autowired
    VHSService vhsService;

    @Autowired
    VHSRepository vhsRepository;

    VHSController(VhsApplication vhsApplication) {
        this.vhsApplication = vhsApplication;
    }

    @GetMapping
    public String findAll(Model model) {
        List<VHS> vhsList = vhsService.findAll();
        model.addAttribute("vhsList", vhsList);

        return "vhs-list";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Long id, Model model) {

        VHS vhs = vhsRepository.findById(id).get();

        model.addAttribute("vhs", vhs);

        return "vhs-edit";
    }

    @PostMapping("/editar")
    public String editTask(VHS vhs) {

        vhsRepository.save(vhs);

        return "redirect:/vhs  ";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("vhs", new VHS());
        return "vhs-list";
    }

    @PostMapping("/create")
    public String createVHS(VHS vhs) {
        vhsRepository.save(vhs);

        return "redirect:/vhs";
    }

    @GetMapping("/remove/{id}")
    public String removeTask(@PathVariable Long id) {
        vhsRepository.deleteById(id);
        return "redirect:/vhs";
    }

}