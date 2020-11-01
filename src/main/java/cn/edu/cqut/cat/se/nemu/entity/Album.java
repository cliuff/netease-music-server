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
public class Album extends Model<Album> {

    private static final long serialVersionUID = 1L;

    private String albumId;

    private String name;

    private String artist;

    private String cover;

    private LocalDateTime time;

    private String genre;

    private String region;

    private String desc;


    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
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

    @Override
    protected Serializable pkVal() {
        return this.albumId;
    }

    @Override
    public String toString() {
        return "Album{" +
        "albumId=" + albumId +
        ", name=" + name +
        ", artist=" + artist +
        ", cover=" + cover +
        ", time=" + time +
        ", genre=" + genre +
        ", region=" + region +
        ", desc=" + desc +
        "}";
    }
}
