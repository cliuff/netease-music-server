package cn.edu.cqut.cat.se.nemu.dto;

import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

public class PlaylistDto extends Model<Playlist> {
    private static final long serialVersionUID = 1L;

    private String playlistId;

    private String playlistName;

    private String author;

    private String cover;

    private Integer viewCounts;

    private Integer trackCounts;


    public Integer getTrackCounts() {
        return trackCounts;
    }

    public void setTrackCounts(Integer trackCounts) {
        this.trackCounts = trackCounts;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

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

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(Integer viewCounts) {
        this.viewCounts = viewCounts;
    }
}


