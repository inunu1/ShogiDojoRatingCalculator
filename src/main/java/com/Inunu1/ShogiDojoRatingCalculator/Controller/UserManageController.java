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
	
//    record User(String id, String type, String name, String grade, String rate, String join_date,String update_date){}
//    private List<User> userList = new ArrayList<>();
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
//        String id = UUID.randomUUID().toString().substring(0,8);
//        User user = new User(id,type,name,grade,rate,join_date,update_date);
//        userList.add(user);
    	userManageService.saveUser(userData);
        return "redirect:/user-list";
    }
    
}
