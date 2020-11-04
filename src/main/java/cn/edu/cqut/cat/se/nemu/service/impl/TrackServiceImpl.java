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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

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
                    return new DataResponse(ResponseMessage.SUCCESS);
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
}
