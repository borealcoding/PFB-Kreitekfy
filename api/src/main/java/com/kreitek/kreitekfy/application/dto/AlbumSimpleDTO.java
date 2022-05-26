package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class AlbumSimpleDTO implements Serializable {
    private Long id;
    private String name;
    private byte[] image;

    public AlbumSimpleDTO() {
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumSimpleDTO that = (AlbumSimpleDTO) o;
        return id.equals(that.id) && name.equals(that.name) && Arrays.equals(image, that.image);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, name);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }

    @Override
    public String toString() {
        return "AlbumSimpleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + Arrays.toString(image) +
                '}';
    }
}
