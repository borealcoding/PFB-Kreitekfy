package com.kreitek.kreitekfy.application.dto;

import com.kreitek.kreitekfy.domain.entity.Style;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ArtistDTO implements Serializable {

    private Long id;
    private String name;
    private Style styleId;
    private Style styleName;
    List<SongDTO> songs;
    List<AlbumDTO> albums;

    public ArtistDTO() {
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

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
    }

    public Style getStyleId() {
        return styleId;
    }

    public void setStyleId(Style styleId) {
        this.styleId = styleId;
    }

    public Style getStyleName() {
        return styleName;
    }

    public void setStyleName(Style styleName) {
        this.styleName = styleName;
    }

    public List<AlbumDTO> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumDTO> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArtistDTO artistDTO = (ArtistDTO) o;
        return id.equals(artistDTO.id) && name.equals(artistDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
