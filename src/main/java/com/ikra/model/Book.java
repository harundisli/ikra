package com.ikra.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true)
    private long bookID;

    @Column(name = "title")
    private String title;

    @Column(name = "authors")
    private String author;

    @Column(name = "average_rating")
    private float avarageRaiting;

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "isbn13", unique = true)
    private long isbn13;

    @Column(name = "language_code")
    private  String languageCode;

    @Column(name = "num_pages")
    private int numPages;

    @Column(name = "ratings_count")
    private int raitingCount;

    @Column(name = "text_reviews_count")
    private int textReviewCount;

    @Column(name = "publication_date")
    private LocalDateTime publicationDate;

    @Column(name = "publisher")
    private String publisher;

    /*public Book(long bookID, String title, String author, String isbn) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }*/

    public long getBookID() {
        return bookID;
    }

    public void setBookID(long bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public float getAvarageRaiting() {
        return avarageRaiting;
    }

    public void setAvarageRaiting(float avarageRaiting) {
        this.avarageRaiting = avarageRaiting;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public long getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(long isbn13) {
        this.isbn13 = isbn13;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public int getRaitingCount() {
        return raitingCount;
    }

    public void setRaitingCount(int raitingCount) {
        this.raitingCount = raitingCount;
    }

    public int getTextReviewCount() {
        return textReviewCount;
    }

    public void setTextReviewCount(int textReviewCount) {
        this.textReviewCount = textReviewCount;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
