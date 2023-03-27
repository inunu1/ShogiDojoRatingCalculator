package com.Inunu1.ShogiDojoRatingCalculator.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import java.text.SimpleDateFormat;

import java.util.*;

@Controller
public class UserManageController {
    record User(String id, String type, String name, String grade, String rate, String join_date,String update_date){}
    private List<User> userList = new ArrayList<>();
    @RequestMapping(value = "/user-manage")
    String user(){
        return "user-manage";
    }
    @GetMapping(value = "/user-list")
    String users(Model model){
        model.addAttribute("userList", userList);
        return "user-manage";
    }
    @PostMapping(value = "/user-insert")
    String useradd(@RequestParam("type") String type,
                   @RequestParam("name") String name,
                   @RequestParam("grade") String grade,
                   @RequestParam("rate") String rate,
                   @RequestParam("join_date") String join_date,
                   @RequestParam("update_date") String update_date){
        String id = UUID.randomUUID().toString().substring(0,8);
        User user = new User(id,type,name,grade,rate,join_date,update_date);
        userList.add(user);
        return "redirect:/user-list";
    }
}
