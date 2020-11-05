package cn.edu.cqut.cat.se.nemu.service;

import cn.edu.cqut.cat.se.nemu.dto.TrackDto;
import cn.edu.cqut.cat.se.nemu.dto.TrackInfoDto;
import cn.edu.cqut.cat.se.nemu.entity.Track;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface ITrackService extends IService<Track> {


    DataResponse getTrackList(Integer page, Integer limit, String artistName, String trackName);

    DataResponse delete(String ids);

    DataResponse updateTrack(TrackInfoDto trackInfoDto);

    DataResponse add(TrackInfoDto trackInfoDto);
    DataResponse updateTrack1(TrackInfoDto trackInfoDto);
    DataResponse trackAndlyric();

    DataResponse trackAndlyric1(String trackId);
}
