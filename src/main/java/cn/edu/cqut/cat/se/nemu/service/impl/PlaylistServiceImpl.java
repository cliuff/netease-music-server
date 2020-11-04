package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import cn.edu.cqut.cat.se.nemu.mapper.PlaylistMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.IPlaylistService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
@Service
public class PlaylistServiceImpl extends ServiceImpl<PlaylistMapper, Playlist> implements IPlaylistService {

    @Override
    public DataResponse getPlaylists() {

        List<Playlist> playlists = baseMapper.getPlayList();

        if (playlists != null) {

            return new DataResponse(ResponseMessage.SUCCESS, playlists);

        } else {
            return new DataResponse(ResponseMessage.DATA_NULL);

        }

    }

    @Override
    public DataResponse getLunbo() {

        List<String> lunboList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {

            lunboList.add("media/images/lun" + (i + 1) + ".jpg");

        }

        return new DataResponse(ResponseMessage.SUCCESS, lunboList);
    }

    @Override
    public DataResponse getCategary() {
        List<String> categaryList = baseMapper.getCategary();

        if (categaryList != null) {

            return new DataResponse(ResponseMessage.SUCCESS, categaryList);

        } else {
            return new DataResponse(ResponseMessage.FAILURE);

        }

    }

    @Override
    public DataResponse getPlaylistByGenre(Integer page,Integer limit,String genre) {

         if(genre!=null){

             QueryWrapper qw = new QueryWrapper();
             qw.eq("genre",genre);

             Page<Playlist> playlistPage = baseMapper.selectPlaylistsByGenre(new Page<>(page,limit),qw);

             if(playlistPage!=null){

                 return new DataResponse(ResponseMessage.SUCCESS,playlistPage.getRecords(),playlistPage.getTotal());

             }
             else{
                 return new DataResponse(ResponseMessage.FAILURE);
             }
         }
         else{
             return new DataResponse(ResponseMessage.DATA_NULL);
         }

    }

    @Override
    public DataResponse getPlaylist(Integer page, Integer limit) {
        Page<Playlist> playlistPage = this.page(new Page<>(page,limit));


        if(playlistPage!=null){
            System.out.println("count"+playlistPage.getTotal());
            return new DataResponse(ResponseMessage.SUCCESS,playlistPage.getRecords(),playlistPage.getTotal());

        }
        else{
            return new DataResponse(ResponseMessage.FAILURE);

        }


    }



}