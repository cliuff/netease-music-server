package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface PlaylistMapper extends BaseMapper<Playlist> {

    @Select("SELECT name,cover,view_counts FROM `playlist` order by view_counts desc limit 0,8")
    public List<Playlist> getPlayList();

}
