package com.example.demo.controller;

import com.example.demo.pojo.Result;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import com.example.demo.untils.JwtUtil;
import com.example.demo.untils.ThreadLocalUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.DigestUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){
        User u = userService.findByUsername(username);
        System.out.println(u);
        System.out.println(username+"-and-"+password);
//        if(username!=null&&username.length()>=5&&username.length()<=16
//        &&password!=null&&password.length()>=5&&password.length()<=16){
            if(u==null){
                userService.register(username,password);
                return Result.success();
            }
            else {
                return Result.error("用户名已经被占用");
            }
//        }
//        else {
//            return Result.error("输入不合法");
//        }
    }

    @PostMapping("/login")  //新增用postmapper
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username,@Pattern(regexp = "^\\S{5,16}$") String password){
        User user = userService.findByUsername(username);
        System.out.println(username);
        if(user == null){
            return Result.error("用户名不存在");
        }
        if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",user.getId());
            claims.put("username",user.getUsername());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }
        else {
            return Result.error("密码错误");
        }
    }

    @GetMapping("/userInfo")
    public Result<User> userInfo(/*@RequestHeader(name = "Authorization") String token*/){
       /* Map<String,Object> map = JwtUtil.parseToken(token);
        String username = (String) map.get("username");*/
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User user = userService.findByUsername(username);
        return Result.success(user);
    }

    @PutMapping("/update")  //修改用putmapper
    public Result update(@RequestBody @Validated User user){    //前端传json，且参数实体类，用requestBody
        userService.update(user);                         //@RequestParam用于前端名字和后端参数不一样的情况
        return Result.success("更新成功");
    }

    @PatchMapping("/updateAvatar")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){    //@URL判断是否是URL
        userService.updateAvatar(avatarUrl);
        return Result.success("yes change");
    }


}

