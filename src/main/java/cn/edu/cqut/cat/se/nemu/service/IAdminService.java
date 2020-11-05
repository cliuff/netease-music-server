package cn.edu.cqut.cat.se.nemu.service;

import cn.edu.cqut.cat.se.nemu.entity.Admin;
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
public interface IAdminService extends IService<Admin> {

    DataResponse updateAdminInfo(Admin admin);

    DataResponse login(String adminId, String password);

    DataResponse getInfoById(String adminId);
}
