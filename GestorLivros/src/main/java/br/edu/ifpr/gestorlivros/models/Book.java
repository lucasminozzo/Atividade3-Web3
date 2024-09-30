package br.edu.ifpr.gestorlivros.models;

import jakarta.persistence.*;

import java.time.LocalDate;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private LocalDate dataCadastro;

    private LocalDate dataUltimoEmprestimo;

    @Enumerated
    private BookStatus status;

    @ManyToOne
    private Author author;

    public Book() {}

    public LocalDate getDataUltimoEmprestimo() {
        return dataUltimoEmprestimo;
    }

    public void setDataUltimoEmprestimo(LocalDate dataUltimoEmprestimo) {
        this.dataUltimoEmprestimo = dataUltimoEmprestimo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
