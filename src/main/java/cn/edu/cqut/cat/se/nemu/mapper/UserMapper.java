package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

}
