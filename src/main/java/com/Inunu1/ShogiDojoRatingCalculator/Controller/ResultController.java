package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.model.TtGameResult;
import com.Inunu1.ShogiDojoRatingCalculator.model.UserData;
import com.Inunu1.ShogiDojoRatingCalculator.service.ResultService;
import com.Inunu1.ShogiDojoRatingCalculator.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping(value = "/result")
    String addResult(@ModelAttribute ResultData resultData, Model model) {
        resultService.saveResult(resultData);
        return "redirect:/result";


    }

    @GetMapping(value = "/result")
    String getResult() {
        return "Result";
    }
}
