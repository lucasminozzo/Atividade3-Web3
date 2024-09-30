package br.edu.ifpr.gestorlivros.services;

import br.edu.ifpr.gestorlivros.models.Author;
import br.edu.ifpr.gestorlivros.models.Book;
import br.edu.ifpr.gestorlivros.models.BookStatus;
import br.edu.ifpr.gestorlivros.repositories.AuthorRepository;
import br.edu.ifpr.gestorlivros.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public Book criar(Book book) {
        Optional<Author> authorExistente = authorRepository.findById(book.getAuthor().getId());
        if(authorExistente.isPresent()) {
            book.setAuthor(authorExistente.get());
        }else {
            authorRepository.save(book.getAuthor());
        }
        book.setDataCadastro(LocalDate.now());
        book.setStatus(BookStatus.DISPONIVEL);

        book= bookRepository.save(book);
        return book;
    }

    public List<Book> listar() {
        return bookRepository.findAll();
    }
    public Book buscarPorId(Long id) {
        return bookRepository.findById(id).orElseThrow((() -> new IllegalArgumentException("O id do livro não existe.")));
    }
    public void emprestar(Long id) {
        Book book;
        Optional<Book> bOptional = bookRepository.findById(id);
        if (bOptional.isPresent()) {
            book = bOptional.get();
            book.setStatus(BookStatus.EMPRESTADO);
            book.setDataUltimoEmprestimo(LocalDate.now());
            bookRepository.save(book);
        }
    }
    public void devolver(Long id) {
        Book book;
        Optional<Book> bOptional = bookRepository.findById(id);
        if (bOptional.isPresent()) {
            book = bOptional.get();
            book.setStatus(BookStatus.DISPONIVEL);
            bookRepository.save(book);
        }
    }
    public void remover(Long id) {
        Book book;
        Optional<Book> bOptional = bookRepository.findById(id);
        if (bOptional.isPresent()) {
            book = bOptional.get();
            book.setStatus(BookStatus.INDISPONIVEL);
            bookRepository.save(book);

        }
    }
}
