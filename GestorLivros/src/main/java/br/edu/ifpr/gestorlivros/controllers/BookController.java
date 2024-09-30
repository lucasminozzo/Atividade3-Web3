package br.edu.ifpr.gestorlivros.controllers;

import br.edu.ifpr.gestorlivros.models.Book;
import br.edu.ifpr.gestorlivros.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book criar(@RequestBody Book book) {
        Book livro = bookService.criar(book);
        return livro;
    }

    @GetMapping
    public List<Book> listar() {
        List<Book>bookList= bookService.listar();
        return bookList;
    }
    @GetMapping("/{id}")
    public Book buscarPorId(@PathVariable Long id) {
        Book book = bookService.buscarPorId(id);
        return book;
    }
    @PutMapping("/{id}/emprestar")
    public void emprestar(@PathVariable Long id) {
        bookService.emprestar(id);
    }
    @PutMapping("/{id}/devolver")
    public void devolver(@PathVariable Long id) {
        bookService.devolver(id);
    }
    @PutMapping("/{id}/remover")
    public void remover(@PathVariable Long id) {
        bookService.remover(id);
    }
}
