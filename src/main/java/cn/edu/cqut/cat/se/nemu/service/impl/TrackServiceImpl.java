package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.dto.TrackDto;
import cn.edu.cqut.cat.se.nemu.dto.TrackInfoDto;
import cn.edu.cqut.cat.se.nemu.entity.Album;
import cn.edu.cqut.cat.se.nemu.entity.Artist;
import cn.edu.cqut.cat.se.nemu.entity.Track;
import cn.edu.cqut.cat.se.nemu.mapper.TrackMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.ITrackService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
@Service
public class TrackServiceImpl extends ServiceImpl<TrackMapper, Track> implements ITrackService {


    @Override
    public DataResponse getTrackList(Integer page, Integer limit, String artistName, String trackName) {

        Page<TrackInfoDto> trackDtoPage = baseMapper.selectTrackList(new Page<>(page,limit),artistName,trackName);
        return new DataResponse(ResponseMessage.SUC,trackDtoPage.getRecords(),trackDtoPage.getTotal());
    }

    @Override
    @Transactional
    public DataResponse delete(String[] ids) {
        int j=0;
        try{
            //先判定数据是否存在
            for(String id:ids){
                Track track = baseMapper.selectTrack(id);
                if(track!=null){
                    baseMapper.deleteTrack(id);
                    j++;
                }

            }
            return new DataResponse(j);


        }catch (Exception e){
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new DataResponse(ResponseMessage.FAILURE);
        }

    }

    @Override
    @Transactional
    public DataResponse updateTrack(TrackInfoDto trackInfoDto) {

        try {
           Track track = baseMapper.selectTrack(trackInfoDto.getTrackId());
            //还需要加逻辑判定  -- 去学习正则表达式
            if(track!=null){
                Integer i =  baseMapper.updateTrack(trackInfoDto.getCover(),trackInfoDto.getGenre(),trackInfoDto.getRegion(),trackInfoDto.getTrackDesc(),trackInfoDto.getTrackId());
                if(i==0){
                    return new DataResponse(ResponseMessage.FAILURE);
                }else{
                    return new DataResponse(ResponseMessage.SUC);
                }
            }else {
                return new DataResponse("000407","请刷新以后在尝试！");
            }

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new DataResponse(ResponseMessage.FAILURE);
        }

    }

    @Override
    public DataResponse add(TrackInfoDto trackInfoDto) {

        String trackId = UUID.randomUUID().toString().replace("_", "").substring(0, 4);
        Track track = new Track();
        if(trackInfoDto!=null){
            if(trackInfoDto.getAlbumName()!=null && trackInfoDto.getArtistName()!=null){
                Artist artist= baseMapper.selectArtistByName(trackInfoDto.getArtistName());
                Album album = baseMapper.selectAlbumByName(trackInfoDto.getAlbumName());

                if(artist.getArtistId()!=null){
                    track.setArtist(artist.getArtistId());
                }
                else{
                    String artistId = UUID.randomUUID().toString().replace("_", "").substring(0, 4);
                    track.setArtist(artistId);
                    Artist artist1 = new Artist();
                    artist1.setArtistId(artistId);
                    artist1.setArtistName(trackInfoDto.getArtistName());
                    new ArtistServiceImpl().save(artist1);//添加新歌手
                }
                if(album.getAlbumId()!=null){
                    track.setAlbum(album.getAlbumId());
                }
                else{
                    String albumId = UUID.randomUUID().toString().replace("_", "").substring(0, 4);
                    track.setAlbum(albumId);
                    Album album1= new Album();
                    album1.setAlbumId(albumId);
                    album1.setAlbumName(trackInfoDto.getAlbumName());
                    new AlbumServiceImpl().save(album1);//添加专辑信息
                }
               /* track.setTrackId();*/

            }

        }
        else
        {
            return new DataResponse(ResponseMessage.DATA_NULL);
        }
        return null;
    }
}
