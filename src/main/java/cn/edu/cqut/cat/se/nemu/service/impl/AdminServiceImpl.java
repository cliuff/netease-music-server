package cn.edu.cqut.cat.se.nemu.service.impl;

import cn.edu.cqut.cat.se.nemu.entity.Admin;
import cn.edu.cqut.cat.se.nemu.entity.User;
import cn.edu.cqut.cat.se.nemu.mapper.AdminMapper;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.result.ResponseMessage;
import cn.edu.cqut.cat.se.nemu.service.IAdminService;
import cn.edu.cqut.cat.se.nemu.util.Md5Util;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public DataResponse updateAdminInfo(Admin admin) {
        try {
           Admin admin1= baseMapper.selectAdmin(admin.getAdminId());
            //还需要加逻辑判定  -- 去学习正则表达式
            if(admin1!=null){

                Integer i = baseMapper.updateAdmin(
                        admin.getAdminName(),
                        admin.getPassword(),
                        admin.getImage(),
                        admin.getAdminId()
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

    @Override
    public DataResponse login(String adminId, String password) {
        //密码：123456
      Admin admin = baseMapper.login(adminId);
        String pwdEn = Md5Util.getMd5(adminId,password);
        System.out.println("mima"+pwdEn);
        if(admin!=null && admin.getPassword().equalsIgnoreCase(pwdEn)){
            Admin admin1 = new Admin();
            admin1.setAdminId(admin.getAdminId());
            admin1.setImage(admin.getImage());
            return new DataResponse(admin1);//返回账号和头像路径
        }else{
            return new DataResponse("000407","用户名或者密码错误",null);
        }
    }
}
