package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.dto.TrackDto;
import cn.edu.cqut.cat.se.nemu.dto.TrackInfoDto;
import cn.edu.cqut.cat.se.nemu.entity.Album;
import cn.edu.cqut.cat.se.nemu.entity.Artist;
import cn.edu.cqut.cat.se.nemu.entity.Track;
import cn.edu.cqut.cat.se.nemu.util.SqlMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface TrackMapper extends BaseMapper<Track> {

    @Select("SELECT genre FROM `track` group by genre having count(*) >1")
    public List<String>  getCategary();

   @SelectProvider(type= SqlMapper.class,method="selectTrackInfo")
    public Page<TrackInfoDto> selectTrackList(
            Page<TrackInfoDto> page,
            @Param("artistName")String artistName,
            @Param("trackName")String trackName

    );

   @Select("select track_id from track where track_id=#{trackId}")
   public Track selectTrack(String trackId);

   @Delete("delete from track where track_id=#{trackId}")
    public Integer deleteTrack(String trackId);

   @Update("update track set cover=#{cover},genre=#{genre},region=#{region},track_desc=#{trackDesc} where track_id=#{trackId}")
    public Integer updateTrack(
            @Param("cover") String cover,
            @Param("genre")String genre,
            @Param("region")String region,
            @Param("trackDesc")String trackDesc,
            @Param("trackId")String trackId);

    @Select("SELECT artist_id FROM `artist` where artist_name=#{artistName}")
    public String selectArtistByName(String artistName);

    @Select("select album_id from album where album_name=#{albumName}")
    public String selectAlbumByName(String albumName);

    @Insert("insert into artist (artist_id,artist_name) values(#{artistId},#{artistName}) ")
    public Integer insertArtist(String artistId,String artistName);
    @Insert("insert into album (album_id,album_name) values(#{albumId},#{albumName})")
    public Integer insertAlbum(String albumId,String albumName);


}
