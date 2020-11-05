package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.dto.CountDto;
import cn.edu.cqut.cat.se.nemu.entity.Artist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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

    @Select("SELECT MONTH(user.time) as 'month',count(user_id) as userCounts \n" +
            "FROM user\n" +
            "GROUP BY  MONTH(user.time) \n" +
            "ORDER BY  MONTH(user.time) ")
    public List<CountDto> selectUserCountByMonth();

    @Select("SELECT MONTH(track.time) as 'month',count(track_id) as trackCounts \n" +
            "FROM track\n" +
            "GROUP BY  MONTH(track.time) \n" +
            "ORDER BY  MONTH(track.time) ")
    public List<CountDto> selectTrackCountByMonth();

    @Select("SELECT MONTH(album.time) as 'month',count(album_id) as albumCounts \n" +
            "FROM album\n" +
            "GROUP BY  MONTH(album.time) \n" +
            "ORDER BY  MONTH(album.time) ")
    public List<CountDto> selectAlbumCountByMonth();

   @Select("SELECT count(user_id) as maleCounts from user where sex ='男' ")
    public Integer selectMaleCounts();

    @Select("SELECT count(user_id) as femaleCounts from user where sex ='女' ")
    public Integer selectFemaleCounts();


}
