package flores.angel.GameShop.service;

import flores.angel.GameShop.models.Juego;
import flores.angel.GameShop.repository.JuegoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class JuegoService {
    @Autowired
    private JuegoRepository juegoRepository;

    public List<Juego> listarTodos() {
        return juegoRepository.findAll();
    }

    public void guardarJuego(Juego juego, MultipartFile portada) {
        String urlImagen = "default.png";
        if(!portada.isEmpty()){
            //change the url of the given img
        }

        juego.setPortadaUrl(urlImagen);
        juegoRepository.save(juego);
    }

    public Juego buscarPorId(Long id) {
        return juegoRepository.findById(id).orElse(null);
    }

    public List<Juego> buscarPorTitulo(String palabra){
        if(palabra == null || palabra.trim().isEmpty()){
            return listarTodos();
        }

        return juegoRepository.findByTituloContainingIgnoreCase(palabra);
    }
}
