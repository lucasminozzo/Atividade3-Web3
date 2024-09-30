package br.edu.ifpr.gestorlivros.repositories;

import br.edu.ifpr.gestorlivros.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
