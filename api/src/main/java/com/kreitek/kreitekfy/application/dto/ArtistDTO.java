package com.kreitek.kreitekfy.application.dto;

import com.kreitek.kreitekfy.domain.entity.Style;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class ArtistDTO implements Serializable {

    private Long id;
    private String name;

    private Long styleId;
    private String styleName;
/*
    List<SongDTO> songs;

    List<AlbumDTO> album;

    /*private Long albumId;
    private String albumName;*/

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

   public Long getStyleId() {
        return styleId;
    }

    public void setStyleId(Long styleId) {
        this.styleId = styleId;
    }

    public String getStyleName() {
        return styleName;
    }

    public void setStyleName(String styleName) {
        this.styleName = styleName;
    }
/*
    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
    }

    public List<AlbumDTO> getAlbum() {
        return album;
    }

    public void setAlbum(List<AlbumDTO> album) {
        this.album = album;
    }
*/

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
