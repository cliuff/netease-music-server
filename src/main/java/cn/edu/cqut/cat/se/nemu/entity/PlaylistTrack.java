package cn.edu.cqut.cat.se.nemu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-03
 */
public class PlaylistTrack extends Model<PlaylistTrack> {

    private static final long serialVersionUID = 1L;

    private String trackCompId;

    private String playlist;

    private String track;


    public String getTrackCompId() {
        return trackCompId;
    }

    public void setTrackCompId(String trackCompId) {
        this.trackCompId = trackCompId;
    }

    public String getPlaylist() {
        return playlist;
    }

    public void setPlaylist(String playlist) {
        this.playlist = playlist;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    protected Serializable pkVal() {
        return this.trackCompId;
    }

    @Override
    public String toString() {
        return "PlaylistTrack{" +
        "trackCompId=" + trackCompId +
        ", playlist=" + playlist +
        ", track=" + track +
        "}";
    }
}
