package com.Inunu1.ShogiDojoRatingCalculator.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlayerInsertComtroller {
    @RequestMapping(value = "/Player_Insert")
    String Top(){
        return "Player_Insert";
    }
}
