package cn.edu.cqut.cat.se.nemu.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public class Artist extends Model<Artist> {

    private static final long serialVersionUID = 1L;

    private String artistId;

    private String name;

    private String region;

    private String desc;


    public String getArtistId() {
        return artistId;
    }

    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return this.artistId;
    }

    @Override
    public String toString() {
        return "Artist{" +
        "artistId=" + artistId +
        ", name=" + name +
        ", region=" + region +
        ", desc=" + desc +
        "}";
    }
}
