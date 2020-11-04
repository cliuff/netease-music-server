package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.dto.TrackInfoDto;
import cn.edu.cqut.cat.se.nemu.entity.Track;
import cn.edu.cqut.cat.se.nemu.util.SqlMapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface TrackMapper extends BaseMapper<Track> {

    @Select("SELECT genre FROM `track` group by genre having count(*) >1")
    public List<String>  getCategary();

   @SelectProvider(type= SqlMapper.class,method="selectTrackInfo")
    public Page<TrackInfoDto> selectTrackList(
            Page<TrackInfoDto> page,
            @Param("artistName")String artistName,
            @Param("trackName")String trackName

    );

}
