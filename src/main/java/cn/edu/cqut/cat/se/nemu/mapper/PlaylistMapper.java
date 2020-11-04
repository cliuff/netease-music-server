package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.dto.PlaylistDto;
import cn.edu.cqut.cat.se.nemu.dto.TrackDto;
import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
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
public interface PlaylistMapper extends BaseMapper<Playlist> {

    @Select("SELECT playlist_id, playlist_name,cover,view_counts FROM `playlist` order by view_counts desc limit 0,8")
    public List<PlaylistDto> getPlayList();

    @Select("SELECT genre FROM `playlist` group by genre having count(*) >1")
    public List<String> getCategary();

    @Select("SELECT playlist_id,playlist_name,author,cover,view_counts FROM `playlist` ${ew.customSqlSegment}")
    public Page<PlaylistDto> selectPlaylistsByGenre(
            Page<PlaylistDto> page,
            @Param(Constants.WRAPPER)QueryWrapper<Playlist> queryWrapper);

    @Select("SELECT playlist.playlist_id,playlist_name,playlist.cover,count(playlist_track.track) as trackCounts   FROM `playlist` left join playlist_track on \n" +
            " playlist.playlist_id = playlist_track.playlist\n" +
            " where author =#{author}\n" +
            " GROUP BY playlist.playlist_id")
    public List<PlaylistDto> selectPlaylistByAuthor(String author);

    @Select("SELECT track_id as trackId,track_name as trackName,length,artist_name as artistName,album_name as albumName \n" +
            "from track,playlist_track,playlist,artist,album\n" +
            "where playlist.playlist_id = playlist_track.playlist \n" +
            "and track.track_id = playlist_track.track\n" +
            "and artist.artist_id = track.artist\n" +
            "and album.album_id = track.album\n" +
            "and playlist_id =#{playlistId}")
    public List<TrackDto> selectTracksByPlaylistId(String playlistId);

    @Select("SELECT * from playlist")
    public List<Playlist> selectAllPlaylistInfo();
}
