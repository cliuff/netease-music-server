package cn.edu.cqut.cat.se.nemu.mapper;

import cn.edu.cqut.cat.se.nemu.entity.Admin;
import cn.edu.cqut.cat.se.nemu.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("select admin_id from admin where admin_id=#{adminId}")
   public Admin selectAdmin(String adminId);

    @Update("update admin set admin_name=#{adminName},password=#{password},image=#{image} where admin_id=#{adminId}")
    Integer updateAdmin(String adminName, String password, String image, String adminId);

    @Select("select admin_id,password,image from admin where admin_id=#{adminId}")
    public Admin login(String adminId);
}
