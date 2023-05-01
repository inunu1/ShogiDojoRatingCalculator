package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/", "/login"})
    public String loginForm() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication.getName());
        if (authentication.getName().equals("anonymousUser")) {
            return "login";
        } else {
            return "redirect:Top";
        }
    }

//    @PostMapping("/login")
//    public String login(@RequestParam String username, @RequestParam String password) {
//        // ユーザー名とパスワードの検証処理を行う
//        if (!isValid(username, password)) {
//            System.out.println(username);
//            return "login?error=true";
//        }
//        return "Top";
//    }

    private boolean isValid(String username, String password) {
        // ユーザー名とパスワードの検証処理を実装する
        // ...
        if (username.equals("admin") && password.equals("admin")){
            return true;
        }else {
            return false;
        }

    }
}
