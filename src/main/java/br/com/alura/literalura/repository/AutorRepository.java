package br.com.alura.literalura.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.literalura.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

    Optional<Autor> findByAutor(String autor);

    @Query("SELECT a FROM Autor a WHERE :ano BETWEEN a.anoNascimento AND COALESCE(a.anoFalecimento, :ano)")
    List<Autor> findAutoresVivosEmAno(@Param("ano") String ano);

    
}
