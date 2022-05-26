package com.kreitek.kreitekfy.application.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class SongDTO implements Serializable {
    private Long id;
    private String name;
    private Integer duration;
    private Integer likes;
    private Date releaseDate;
    private Integer playedTimes;

    private Long albumId;
    private String albumName;

    public SongDTO() {
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

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getPlayedTimes() {
        return playedTimes;
    }

    public void setPlayedTimes(Integer playedTimes) {
        this.playedTimes = playedTimes;
    }

    public Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SongDTO)) return false;
        SongDTO songDTO = (SongDTO) o;
        return Objects.equals(getId(), songDTO.getId()) &&
                Objects.equals(getName(), songDTO.getName()) &&
                Objects.equals(getDuration(), songDTO.getDuration()) &&
                Objects.equals(getLikes(), songDTO.getLikes()) &&
                Objects.equals(getReleaseDate(), songDTO.getReleaseDate()) &&
                Objects.equals(getPlayedTimes(), songDTO.getPlayedTimes());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDuration(), getLikes(), getReleaseDate(), getPlayedTimes());
    }
}

