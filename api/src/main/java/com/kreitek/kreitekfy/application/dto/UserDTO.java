package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;

public class UserDTO  implements Serializable {

    private Long id;
    private String name;
    private String rol;

    public UserDTO() {
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

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}



