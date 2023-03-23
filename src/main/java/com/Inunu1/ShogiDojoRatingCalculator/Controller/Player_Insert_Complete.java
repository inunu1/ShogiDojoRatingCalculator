package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Player_Insert_Complete {
    @PostMapping(value = "Player_Insert_Complete")
    String Top(){
        return "Player_Insert_Complete";
    }
}
