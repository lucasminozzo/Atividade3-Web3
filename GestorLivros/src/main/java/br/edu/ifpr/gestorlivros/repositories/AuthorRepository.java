package br.edu.ifpr.gestorlivros.repositories;

import br.edu.ifpr.gestorlivros.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
