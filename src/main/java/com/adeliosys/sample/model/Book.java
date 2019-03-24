package com.adeliosys.sample.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Book {

    @Id
    private Long id;

    private String title;

    @Enumerated(EnumType.STRING)
    private Language language;

    private String isbn;

    private Date date;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    private Editor editor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }
}
