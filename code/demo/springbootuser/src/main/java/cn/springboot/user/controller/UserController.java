package cn.springboot.user.controller;

import cn.springboot.user.pojo.User;
import cn.springboot.user.service.UserService;
import jdk.nashorn.internal.ir.IfNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("{id}")
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long id) {
        return this.userService.queryUserById(id);
    }

    @GetMapping("all")
    public String toUser(Model model){
        List<User> users=this.userService.queryUserAll();
        model.addAttribute("users",users);
        return "users";
    }

    @GetMapping("test")
    @ResponseBody
    public String test() {
        return "hello user!";
    }
}
