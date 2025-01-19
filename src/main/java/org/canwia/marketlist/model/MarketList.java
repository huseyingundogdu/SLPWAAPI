package org.canwia.marketlist.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import java.util.List;


@Entity
public class MarketList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "marketList_id")
    private Long id;

    private String title;

    @OneToMany(mappedBy = "marketList", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Item> items;

    private LocalDateTime createdAt = LocalDateTime.now();


    public MarketList() {
    }

    public MarketList(Long id, String title, List<Item> items, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.items = items;
        this.createdAt = createdAt;
    }

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

