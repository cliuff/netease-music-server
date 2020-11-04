package cn.edu.cqut.cat.se.nemu.service;

import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface IPlaylistService extends IService<Playlist> {

    DataResponse getPlaylists();

    DataResponse getLunbo();
    DataResponse getCategary();

    DataResponse getPlaylistByGenre(Integer page,Integer limit,String genre);

    DataResponse getPlaylist(Integer page, Integer limit);

    DataResponse getPlaylistByAuthor(String author);

    DataResponse getTracksByPlaylistId(String playlistId);
}
