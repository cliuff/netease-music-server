package cn.edu.cqut.cat.se.nemu.service;

import cn.edu.cqut.cat.se.nemu.entity.User;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
public interface IUserService extends IService<User> {
    public DataResponse login(HttpServletRequest request,String userId,String password);

    DataResponse getUserInfo(String userId);

    DataResponse getAllUserInfo(Integer page,Integer limit,User user);

    DataResponse delete(String ids);

    DataResponse add(User user);

    DataResponse updateUser(User user);
}
