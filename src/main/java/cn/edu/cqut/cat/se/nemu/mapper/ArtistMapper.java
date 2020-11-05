package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.entity.Artist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface ArtistMapper extends BaseMapper<Artist> {


    @Select("SELECT count(track_id) as trackCounts from track")
    public Integer selectTrackCounts();

    @Select("SELECT count(artist_id) as artistCounts from artist")
    public Integer selectArtistCounts();

    @Select("SELECT count(user_id) as userCounts from user")
    public Integer selectUserCounts();

    @Select("SELECT count(album_id) as albumCounts from album")
    public Integer selectAlbumCounts();



}
