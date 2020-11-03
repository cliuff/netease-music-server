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
 * @since 2020-11-03
 */
public class Playlist extends Model<Playlist> {

    private static final long serialVersionUID = 1L;

    private String playlistId;

    private String playlistName;

    private String author;

    private String playlistDesc;

    private String cover;

    private LocalDateTime time;

    private Integer viewCounts;

    private String genre;


    public String getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(String playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPlaylistDesc() {
        return playlistDesc;
    }

    public void setPlaylistDesc(String playlistDesc) {
        this.playlistDesc = playlistDesc;
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

    public Integer getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(Integer viewCounts) {
        this.viewCounts = viewCounts;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    protected Serializable pkVal() {
        return this.playlistId;
    }

    @Override
    public String toString() {
        return "Playlist{" +
        "playlistId=" + playlistId +
        ", playlistName=" + playlistName +
        ", author=" + author +
        ", playlistDesc=" + playlistDesc +
        ", cover=" + cover +
        ", time=" + time +
        ", viewCounts=" + viewCounts +
        ", genre=" + genre +
        "}";
    }
}
