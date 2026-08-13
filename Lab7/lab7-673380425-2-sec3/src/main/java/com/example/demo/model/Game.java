package com.example.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String genre;
    private String platform;
    private double rating;
    private LocalDate releaseDate;
    private double price;
    private String discountType;
    @Transient
    private double finalPrice;
    @Transient
    private String discountName;

    public Game() {
    }

    public Game(Long id, String title, String genre, String platform, double rating, LocalDate releaseDate,
            double price, String discountType) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.price = price;
        this.discountType = discountType;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public double getRating() {
        return rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public double getPrice() {
        return price;
    }

    public String getDiscountType() {
        return discountType;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }
}
