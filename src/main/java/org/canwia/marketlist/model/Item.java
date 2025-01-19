package org.canwia.marketlist.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private float quantity;
    private String type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "marketList")
    @JsonBackReference
    private MarketList marketList;

    public Item() {
    }

    public Item(Long id, String name, float quantity, String type, MarketList marketList) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.type = type;
        this.marketList = marketList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MarketList getMarketList() {
        return marketList;
    }

    public void setMarketList(MarketList marketList) {
        this.marketList = marketList;
    }
}
