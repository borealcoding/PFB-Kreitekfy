package com.kreitek.kreitekfy.domain.entity;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "artistSequence")
    @SequenceGenerator(name = "artistSequence")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "styleId", nullable = false)
    private Style style;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    Set<Song> songs;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL)
    Set<Album> album;

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

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Set<Song> getSongs() {
        return songs;
    }

    public void setSongs(Set<Song> songs) {
        this.songs = songs;
    }

    public Set<Album> getAlbum() {
        return album;
    }

    public void setAlbum(Set<Album> album) {
        this.album = album;
    }
}
