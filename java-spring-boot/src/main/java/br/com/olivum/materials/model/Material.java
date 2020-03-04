package br.com.olivum.materials.model;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "material")
public class Material {
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

    private String name;

    private int type;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
