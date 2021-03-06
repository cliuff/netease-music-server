package cn.edu.cqut.cat.se.nemu.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class TrackInfoDto {
    private String trackId;
    private String  trackName;
    private Long length;
    private String artistName;
    private String albumName;
    private String cover;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private String genre;
    private String region;
    private String trackDesc;
    private String lyrics;

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getTrackName() {
        return trackName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTrackDesc() {
        return trackDesc;
    }

    public void setTrackDesc(String trackDesc) {
        this.trackDesc = trackDesc;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        this.lyrics = lyrics;
    }
}
