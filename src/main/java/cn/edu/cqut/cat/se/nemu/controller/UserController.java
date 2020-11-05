package cn.edu.cqut.cat.se.nemu.controller;


import cn.edu.cqut.cat.se.nemu.entity.User;
import cn.edu.cqut.cat.se.nemu.result.DataResponse;
import cn.edu.cqut.cat.se.nemu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping(value="/")
    public DataResponse login(HttpServletRequest request,String userId,String password){
        return iUserService.login(request,userId,password);
    }
@GetMapping(value="/userInfo")
    public DataResponse getUserInfo(String userId){
        return iUserService.getUserInfo(userId);
}

@PostMapping(value="/allUserInfo")
    public DataResponse getAllUserInfo(Integer page, Integer limit, User user){
        return iUserService.getAllUserInfo(page,limit,user);
}
    @DeleteMapping(value="/" ,consumes = "application/json")
    public DataResponse delete(@RequestBody String ids){

        return iUserService.delete(ids);


    }
    @PostMapping(value = "/add")
    public DataResponse add(User user){
        return iUserService.add(user);
    }
    @PutMapping(value = "/")
    public DataResponse update(User user){
        return iUserService.updateUser(user);
    }
}

