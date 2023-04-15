package com.Inunu1.ShogiDojoRatingCalculator.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    
}
