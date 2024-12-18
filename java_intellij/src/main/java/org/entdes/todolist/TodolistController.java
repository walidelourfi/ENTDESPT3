package org.entdes.todolist;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TodolistController {
    private final GestorTasques gestor = new GestorTasques();

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/tasques")
    public String getTasques(Model model) {
        model.addAttribute("tasques", gestor.llistarTasques());
        return "tasques";
    }

    @PostMapping("/tasques")
    public String addTasca(@RequestParam String descripcio, Model model) {
        
        if (descripcio.trim().isEmpty()) {
            model.addAttribute("errorMessage", "La descripció no pot estar buida.");
            return "index";
        }
        gestor.afegirTasca(descripcio);
        return "redirect:/tasques";
    }

    @PostMapping("/tasques/update/{descripcio}")
    public String updateTasca(@PathVariable String descripcio) {
        gestor.marcarCompletada(descripcio);
        return "redirect:/tasques";
    }

    @PostMapping("/tasques/delete/{descripcio}")
    public String deleteTasca(@PathVariable String descripcio) {
        gestor.eliminarTasca(descripcio);
        return "redirect:/tasques";
    }
}