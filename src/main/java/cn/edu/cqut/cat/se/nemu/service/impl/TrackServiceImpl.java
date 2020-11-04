package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.dto.TrackDto;
import cn.edu.cqut.cat.se.nemu.dto.TrackInfoDto;
import cn.edu.cqut.cat.se.nemu.entity.Track;
import cn.edu.cqut.cat.se.nemu.mapper.TrackMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.ITrackService;
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
public class TrackServiceImpl extends ServiceImpl<TrackMapper, Track> implements ITrackService {


    @Override
    public DataResponse getTrackList(Integer page, Integer limit, String artistName, String trackName) {

        Page<TrackInfoDto> trackDtoPage = baseMapper.selectTrackList(new Page<>(page,limit),artistName,trackName);
        return new DataResponse(ResponseMessage.SUCCESS,trackDtoPage.getRecords(),trackDtoPage.getTotal());
    }
}
