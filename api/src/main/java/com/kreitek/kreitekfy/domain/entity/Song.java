package com.kreitek.kreitekfy.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "songSequence")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "albumId", nullable = false)
    private Album album;

    @ManyToOne
    @JoinColumn(name = "styleId", nullable = false)
    private Style style;

    @ManyToOne
    @JoinColumn(name = "albumId", nullable = false)
    private Artist artist;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }
}
