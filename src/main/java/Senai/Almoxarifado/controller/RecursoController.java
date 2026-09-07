package Senai.Almoxarifado.controller;

import Senai.Almoxarifado.Dtos.EpisDto;
import Senai.Almoxarifado.Dtos.FerramentaDto;
import Senai.Almoxarifado.Dtos.InsumoDto;
import Senai.Almoxarifado.Services.RecursoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RecursoController {

    private final RecursoService recursoService;

    public RecursoController(RecursoService recursoService) {
        this.recursoService = recursoService;
    }

    @PostMapping("/RecursoCadastrar")
    public String cadastrarRecurso(@Valid @ModelAttribute("recurso") EpisDto episDto, BindingResult bindingResult, @ModelAttribute FerramentaDto ferramentaDto, @ModelAttribute InsumoDto insumoDto, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "RecursoCadastrar";
        }

        recursoService.cadastrarRecurso(episDto, ferramentaDto, insumoDto);

        redirectAttributes.addFlashAttribute("mensagem", "Recurso cadastrado com sucesso!");

        return "redirect:/ListaRecurso";
    }
}