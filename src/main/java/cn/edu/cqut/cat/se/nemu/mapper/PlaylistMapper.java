package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.entity.Playlist;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
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

    @Select("SELECT playlist_id, playlist_name,cover,view_counts FROM `playlist` order by view_counts desc limit 0,8")
    public List<Playlist> getPlayList();

    @Select("SELECT genre FROM `playlist` group by genre having count(*) >1")
    public List<String> getCategary();

    @Select("SELECT playlist_name,author,cover,view_counts FROM `playlist` ${ew.customSqlSemgment}")
    public Page<Playlist> selectPlaylistsByGenre(
            Page<Playlist> page,
            @Param(Constants.WRAPPER)QueryWrapper<Playlist> queryWrapper);
}
