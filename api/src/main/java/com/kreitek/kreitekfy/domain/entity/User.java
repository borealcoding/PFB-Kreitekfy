package com.kreitek.kreitekfy.domain.entity;


import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @SequenceGenerator(name = "user_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 20, nullable = false)
    private String name;

     @Column(name = "rol", length = 20, nullable = false)
    private String rol;

    //TODO añadir relación MANY_TO_MANY user -> user_songs
    //TODO añadir relación MANY_TO_MANY user -> user_styles
    //TODO añadir getters & setters para relaciones

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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
