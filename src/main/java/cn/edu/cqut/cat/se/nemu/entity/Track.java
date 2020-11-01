package cn.edu.cqut.cat.se.nemu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public class Track extends Model<Track> {

    private static final long serialVersionUID = 1L;

    private String trackId;

    private String name;

    private String artist;

    private String album;

    private Long length;

    private String cover;

    private LocalDateTime time;

    private String genre;

    private String region;

    private String desc;

    private String lyrics;


    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
        ", name=" + name +
        ", artist=" + artist +
        ", album=" + album +
        ", length=" + length +
        ", cover=" + cover +
        ", time=" + time +
        ", genre=" + genre +
        ", region=" + region +
        ", desc=" + desc +
        ", lyrics=" + lyrics +
        "}";
    }
}
