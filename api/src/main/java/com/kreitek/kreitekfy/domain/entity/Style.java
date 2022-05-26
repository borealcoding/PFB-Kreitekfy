package com.kreitek.kreitekfy.domain.entity;


import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "style")
public class Style {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "style_sequence")
    @SequenceGenerator(name = "style_sequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    /*@OneToMany(mappedBy = "style")
    Set<Artist> artists;

    @OneToMany(mappedBy = "style")
    Set<Song> songs;

    @OneToMany(mappedBy = "style")
    Set<Album> albums;*/


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

    /*public Set<Artist> getArtists() {
        return artists;
    }

    public void setArtists(Set<Artist> artists) {
        this.artists = artists;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Style style = (Style) o;
        return id.equals(style.id) && name.equals(style.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
