package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.entity.User;
import cn.edu.cqut.cat.se.nemu.mapper.UserMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.IUserService;
import cn.edu.cqut.cat.se.nemu.util.Md5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {


    @Override
    public DataResponse login(HttpServletRequest request, String userId, String password) {
          //密码：123
        User user = baseMapper.login(userId);
        String pwdEn = Md5Util.getMd5(userId,password);
        if(user!=null && user.getPassword().equalsIgnoreCase(pwdEn)){
            request.getSession().setAttribute("userId",user.getUserId());
            return new DataResponse(ResponseMessage.SUCCESS);
        }else{
            return new DataResponse("000407","用户名或者密码错误",null);
        }

    }

    @Override
    public DataResponse getUserInfo(String userId) {
        if(userId!=null) {
            User user = baseMapper.selectUserInfo(userId);
            if(user!=null){
                return new DataResponse(ResponseMessage.SUCCESS,user);
            }else{
                return new DataResponse(ResponseMessage.FAILURE);
            }
        }
        else{
            return new DataResponse(ResponseMessage.DATA_NULL);
        }



    }

    /*Meizzuowan*/
    @Override
    public DataResponse getAllUserInfo(Integer page, Integer limit, User user) {

        QueryWrapper<User> qw = new QueryWrapper<>();

        if(user.getUserId()!=null){
            qw.like("user_id",user.getUserId());

            if(user.getUserName()!=null){
                qw.or();
                qw.like("user_name",user.getUserName());
            }
        }
        else
        {

            if(user.getUserName()!=null){
                qw.like("user_name",user.getUserName());
            }
        }
        Page<User> userPage = baseMapper.selectAllUserInfo(new Page<>(page,limit),qw);


        return new DataResponse(userPage.getRecords(),userPage.getTotal());
    }


}
