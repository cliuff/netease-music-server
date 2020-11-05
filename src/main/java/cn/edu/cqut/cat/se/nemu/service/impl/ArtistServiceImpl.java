package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.dto.CountDto;
import cn.edu.cqut.cat.se.nemu.entity.Artist;
import cn.edu.cqut.cat.se.nemu.mapper.ArtistMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.service.IArtistService;
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
public class ArtistServiceImpl extends ServiceImpl<ArtistMapper, Artist> implements IArtistService {


    @Override
    public DataResponse getSortCounts() {


        CountDto countDto = new CountDto();
        Integer  AlbumCounts = baseMapper.selectAlbumCounts();
                countDto.setAlbumCounts(baseMapper.selectAlbumCounts());
                countDto.setArtistCounts(baseMapper.selectArtistCounts());
                countDto.setTrackCounts(baseMapper.selectTrackCounts());
                countDto.setUserCounts(baseMapper.selectUserCounts());

        return new DataResponse(countDto);
    }

    @Override
    public DataResponse getCountByMonth() {

        List<CountDto> countDto = baseMapper.selectAlbumCountByMonth();
        List<CountDto> trackcountDto = baseMapper.selectTrackCountByMonth();
        List<CountDto> usercountDto = baseMapper.selectUserCountByMonth();

        for(int i=0;i<12;i++){
            countDto.get(i).setUserCounts(usercountDto.get(i).getUserCounts());
            countDto.get(i).setTrackCounts(trackcountDto.get(i).getTrackCounts());
        }

        return new DataResponse(countDto);
    }

    @Override
    public DataResponse getCountBySex() {
        Integer maleCounts = baseMapper.selectMaleCounts();
        Integer femaleCounts = baseMapper.selectFemaleCounts();
        CountDto countDto = new CountDto();
        countDto.setNanCounts(maleCounts);
        countDto.setNvCounts(femaleCounts);
        return new DataResponse(countDto);
    }
}
