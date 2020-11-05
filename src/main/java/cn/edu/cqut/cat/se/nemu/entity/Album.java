package cn.edu.cqut.cat.se.nemu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-03
 */
public class Album extends Model<Album> {

    private static final long serialVersionUID = 1L;

    private String albumId;

    private String albumName;

    private String artist;

    private String cover;

    @DateTimeFormat(pattern = "yyy-MM-dd hh:mm:ss")
    private LocalDateTime time;

    private String genre;

    private String region;

    private String albumDesc;


    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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

    public String getAlbumDesc() {
        return albumDesc;
    }

    public void setAlbumDesc(String albumDesc) {
        this.albumDesc = albumDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.albumId;
    }

    @Override
    public String toString() {
        return "Album{" +
        "albumId=" + albumId +
        ", albumName=" + albumName +
        ", artist=" + artist +
        ", cover=" + cover +
        ", time=" + time +
        ", genre=" + genre +
        ", region=" + region +
        ", albumDesc=" + albumDesc +
        "}";
    }
}
