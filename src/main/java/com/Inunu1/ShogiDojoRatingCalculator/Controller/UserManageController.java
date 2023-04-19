package com.Inunu1.ShogiDojoRatingCalculator.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.Inunu1.ShogiDojoRatingCalculator.model.UserData;
import com.Inunu1.ShogiDojoRatingCalculator.service.UserManageService;

@Controller
public class UserManageController {
	
	@Autowired
	private UserManageService userManageService;

    @RequestMapping(value = "/user-manage")
    String user(){
        return "user-manage";
    }
    @GetMapping(value = "/user-list")
    String users(Model model){
    	List<UserData> userList = userManageService.findAllUser();
        model.addAttribute("userList", userList);
        return "user-manage";
    }
    @PostMapping(value = "/user-insert")
    String useradd(@ModelAttribute UserData userData, Model model){
    	userManageService.saveUser(userData);
        return "redirect:/user-list";
    }

    //ユーザー検索処理
    @GetMapping(value = "/user-search")
    String userSearch(@RequestParam String name,Model model){
        List<UserData> userList = userManageService.searchUser(name);
        model.addAttribute("userList",userList);
        return "user-manage";
    }
    
}
