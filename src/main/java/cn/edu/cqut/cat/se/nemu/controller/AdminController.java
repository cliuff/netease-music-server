package cn.edu.cqut.cat.se.nemu.controller;


import cn.edu.cqut.cat.se.nemu.entity.Admin;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author CQUT CAT SE 2020
 * @since 2020-11-01
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    public IAdminService iAdminService;

    @PutMapping(value="/")
    public DataResponse updateAdminInfo(Admin admin){
        return iAdminService.updateAdminInfo(admin);
    }

    @PostMapping(value="/login")
    public DataResponse login(String adminId, String password){
        return iAdminService.login(adminId,password);
    }

}

