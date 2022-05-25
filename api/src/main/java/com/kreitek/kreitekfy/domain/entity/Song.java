package com.kreitek.kreitekfy.domain.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "songSequence")
    @SequenceGenerator(name="songSequence")
    private Long id;

    @Column(nullable=false, length = 100)
    @Size(min =3,max = 100)
    private String name;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "likes")
    private Integer likes;

    @Column(name="release_date")
    private Date releaseDate;

    @Column(name = "played_times")
    private Integer PlayedTimes;

    public Song() {
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
        return PlayedTimes;
    }

    public void setPlayedTimes(Integer playedTimes) {
        PlayedTimes = playedTimes;
    }
}