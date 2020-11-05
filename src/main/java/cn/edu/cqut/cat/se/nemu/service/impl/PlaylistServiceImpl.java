package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.dto.Carousel;
import cn.edu.cqut.cat.se.nemu.dto.PlaylistDto;
import cn.edu.cqut.cat.se.nemu.dto.TrackDto;
import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import cn.edu.cqut.cat.se.nemu.mapper.PlaylistMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.IPlaylistService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

        List<PlaylistDto> playlists = baseMapper.getPlayList();

        if (playlists != null) {

            return new DataResponse(ResponseMessage.SUCCESS, playlists);

        } else {
            return new DataResponse(ResponseMessage.DATA_NULL);

        }

    }

    @Override
    public DataResponse getLunbo() {
        Carousel[] carousels = new Carousel[] {
                new Carousel("media/images/lun1.jpg", "#794e47"),
                new Carousel("media/images/lun2.jpg", "#fffdf1"),
                new Carousel("media/images/lun3.jpg", "#23100a"),
                new Carousel("media/images/lun4.jpg", "#252c34"),
                new Carousel("media/images/lun5.jpg", "#11140d"),
                new Carousel("media/images/lun6.jpg", "#aabbc2"),
                new Carousel("media/images/lun7.jpg", "#091336"),
                new Carousel("media/images/lun8.jpg", "#dadbdd")
        };
        return new DataResponse(ResponseMessage.SUCCESS, carousels);
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

             Page<PlaylistDto> playlistPage = baseMapper.selectPlaylistsByGenre(new Page<>(page,limit),qw);

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
            return new DataResponse(ResponseMessage.SUCCESS,playlistPage.getRecords());

        }
        else{
            return new DataResponse(ResponseMessage.FAILURE);

        }


    }

    @Override
    public DataResponse getPlaylistByAuthor(String author) {
       if(author!=null){

           List<PlaylistDto> playlistDtos = baseMapper.selectPlaylistByAuthor(author);

           return new DataResponse(ResponseMessage.SUCCESS,playlistDtos);

       }
       else{
           return new DataResponse(ResponseMessage.FAILURE);
       }

    }

    @Override
    public DataResponse getTracksByPlaylistId(String playlistId) {

           if(playlistId!=null){
               List<TrackDto>  trackDtoList = baseMapper.selectTracksByPlaylistId(playlistId);

               return new DataResponse(ResponseMessage.SUCCESS,trackDtoList);


           }else{
               return new DataResponse(ResponseMessage.FAILURE);
           }

    }

    @Override
    public DataResponse getInfoById(String playlistId) {
        if(playlistId!=null){
            Playlist playlist= baseMapper.selectInfo(playlistId);

            return new DataResponse(ResponseMessage.SUCCESS,playlist);

        }
        else{
            return new DataResponse(ResponseMessage.FAILURE);
        }


    }


}