package flores.angel.GameShop.repository;

import flores.angel.GameShop.models.Juego;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepository extends JpaRepository<Juego,Long> {
    List<Juego> findByTituloContainingIgnoreCase(String titulo);
    List<Juego> findByDescripcionContainingIgnoreCase(String descripcion);
    List<Juego> findByTituloStartingWithIgnoreCase(String letra);

    @Query("SELECT j FROM Juegos j WHERE j.precio< :precioComparacion" +
            " AND LOWER(j.titulo) LIKE ")
    List<Juego> buscarPrecioMenorAQueEmpiecePor(@Param("precioComparacion") Double precioComparacion, @Param("letra")  String letra);
}
