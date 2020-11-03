package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import cn.edu.cqut.cat.se.nemu.mapper.PlaylistMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.IPlaylistService;
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

        List<Playlist> playlists = baseMapper.getPlayList();

        if(playlists!=null){

            return new DataResponse(ResponseMessage.SUCCESS,playlists);

        }
        else{
            return new DataResponse(ResponseMessage.DATA_NULL);

        }

    }
}
