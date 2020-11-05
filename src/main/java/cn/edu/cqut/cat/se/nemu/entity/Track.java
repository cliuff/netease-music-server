package cn.edu.cqut.cat.se.nemu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-03
 */
public class Track extends Model<Track> {

    private static final long serialVersionUID = 1L;

    private String trackId;

    private String trackName;

    private String artist;

    private String album;

    private Long length;

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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
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

    @Override
    protected Serializable pkVal() {
        return this.trackId;
    }

    @Override
    public String toString() {
        return "Track{" +
        "trackId=" + trackId +
        ", trackName=" + trackName +
        ", artist=" + artist +
        ", album=" + album +
        ", length=" + length +
        ", cover=" + cover +
        ", time=" + time +
        ", genre=" + genre +
        ", region=" + region +
        ", trackDesc=" + trackDesc +
        ", lyrics=" + lyrics +
        "}";
    }
}
