package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.entity.Track;
import cn.edu.cqut.cat.se.nemu.entity.User;
import cn.edu.cqut.cat.se.nemu.mapper.UserMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.IUserService;
import cn.edu.cqut.cat.se.nemu.util.Md5Util;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

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

    @Override
    public DataResponse getAllUserInfo(Integer page, Integer limit, User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        if(user.getUserId()!=null||user.getUserName()!=null){
            qw.like("user_id", user.getUserId());
            qw.or();
            qw.like("user_name", user.getUserName()); //第一个参数是字段名
        }
        Page<User> userPage = baseMapper.selectAllUserInfo(new Page<>(page,limit),qw);


        return new DataResponse(userPage.getRecords(),userPage.getTotal());
    }

    @Override
    @Transactional
    public DataResponse delete(String ids) {
        String[] idss = ids.split(",");
        int j=0;
        try{
            //先判定数据是否存在
            for(String id:idss){
                User user= baseMapper.selectUser(id);
                if(user!=null){
                    baseMapper.deleteUser(id);
                    j++;
                }

            }
            return new DataResponse(j);


        }catch (Exception e){
            e.printStackTrace();
            //设置手动回滚
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new DataResponse(ResponseMessage.FAILURE);
        }

    }

    @Override
    public DataResponse add(User user) {
        if(user!=null){
            User user1 = baseMapper.selectUser(user.getUserId());
            if(user1==null) {
                Date time1 = new Date();
                user.setTime(time1);
                save(user);
                return new DataResponse();
            }
            else
            {
                return new DataResponse("000456","用户账号已存在");
            }
        }
        else
        {
            return new DataResponse(ResponseMessage.FAILURE);
        }

    }

    @Override
    @Transactional
    public DataResponse updateUser(User user) {
        try {
            User user1= baseMapper.selectUser(user.getUserId());
            //还需要加逻辑判定  -- 去学习正则表达式
            if(user1!=null){

              Integer i = baseMapper.updateUser(
                      user.getUserName(),
                      user.getUserDesc(),
                      user.getPassword(),
                      user.getRegion(),
                      user.getSex(),
                      user.getAge(),
                      user.getTime(),
                      user.getImage(),
                      user.getUserId()
              );
                if(i==0){
                    return new DataResponse(ResponseMessage.FAILURE);
                }else{
                    return new DataResponse(ResponseMessage.SUC);
                }
            }else {
                return new DataResponse("000407","请刷新以后在尝试！");
            }

        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new DataResponse(ResponseMessage.FAILURE);
        }

    }




}
