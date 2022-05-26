package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class StyleDTO implements Serializable {

    private Long id;
    private String name;
    List<ArtistDTO> artists;
    List<SongDTO> songs;
    List<AlbumDTO> albums;

    public StyleDTO() {
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

    public List<ArtistDTO> getArtists() {
        return artists;
    }

    public void setArtists(List<ArtistDTO> artists) {
        this.artists = artists;
    }

    public List<SongDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongDTO> songs) {
        this.songs = songs;
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
        StyleDTO styleDTO = (StyleDTO) o;
        return id.equals(styleDTO.id) &&
                name.equals(styleDTO.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "StyleDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
