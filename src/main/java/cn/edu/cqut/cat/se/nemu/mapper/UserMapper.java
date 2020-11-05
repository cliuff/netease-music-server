package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.entity.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select user_id,password from user where user_id=#{userId}")
    public User login(String userId);
    @Select("SELECT user_id,user_name,user_desc,region,sex,age,time,image FROM `user` where user_id=#{userId}")
    public User selectUserInfo(String userId);

    @Select("select user_id,user_name,password,region,user_desc,sex,age,time,image from user ${ew.customSqlSegment}")
    public Page<User>  selectAllUserInfo(
            Page<User> page,
            @Param(Constants.WRAPPER)QueryWrapper<User> queryWrapper

    );

}
