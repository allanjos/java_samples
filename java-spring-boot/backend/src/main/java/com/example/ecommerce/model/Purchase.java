package com.example.ecommerce.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "purchase")
public class Purchase {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @GenericGenerator (
            name = "native",
            strategy = "native"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private long id;

    @OneToMany(mappedBy = "purchase")
    private List<PurchaseItem> items = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void addItem(PurchaseItem item) {
        items.add(item);
    }
}
