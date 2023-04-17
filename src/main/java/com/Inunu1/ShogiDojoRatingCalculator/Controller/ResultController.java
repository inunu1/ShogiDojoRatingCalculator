package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ResultController {
    @Autowired
    private ResultService resultService;

    @PostMapping(value = "/result-manage")
    String addResult(@ModelAttribute ResultData resultData, Model model) {
        resultService.saveResult(resultData);
        return "redirect:/result-manage";
    }

    @GetMapping(value = "/result-manage")
    String getResult() {
        return "Result";
    }
}
