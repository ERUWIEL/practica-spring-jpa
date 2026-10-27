package flores.angel.GameShop.controllers;

import flores.angel.GameShop.models.Juego;
import flores.angel.GameShop.service.JuegoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GameController {
    @Autowired
    JuegoService juegoService;

    @GetMapping()
    public String detalleJuego(@PathVariable Long id, Model model) {
        Juego juego = juegoService.buscarPorId(id);

        if (juego == null) {
            return "redirect:/juegos";
        }

        return "detalleJuego";
    }
}
