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
public class Artist extends Model<Artist> {

    private static final long serialVersionUID = 1L;

    private String artistId;

    private String artistName;

    private String region;

    private String artistDesc;


    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getArtistDesc() {
        return artistDesc;
    }

    public void setArtistDesc(String artistDesc) {
        this.artistDesc = artistDesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.artistId;
    }

    @Override
    public String toString() {
        return "Artist{" +
        "artistId=" + artistId +
        ", artistName=" + artistName +
        ", region=" + region +
        ", artistDesc=" + artistDesc +
        "}";
    }
}
