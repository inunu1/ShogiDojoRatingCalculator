package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopController {
    @RequestMapping(value = "/Top")
    String Top(){
        return "Top";
    }
}
