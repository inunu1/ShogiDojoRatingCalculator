package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import com.Inunu1.ShogiDojoRatingCalculator.model.ResultData;
import com.Inunu1.ShogiDojoRatingCalculator.service.CalcRateService;
import com.Inunu1.ShogiDojoRatingCalculator.service.ResultManageService;
import com.Inunu1.ShogiDojoRatingCalculator.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ResultController {
    @Autowired
    private ResultService resultService;
    @Autowired
    private ResultManageService resultManageService;
    @Autowired
    private CalcRateService calcRateService;

    @PostMapping(value = "/result-manage")
    String addResult(@ModelAttribute ResultData resultData, Model model) {
        resultService.saveResult(resultData);
        calcRateService.calcRate(resultData.getWinnerId(),resultData.getLoserId());
        return "redirect:/result-manage";
    }

    @GetMapping(value = "/result-manage")
    String getResult(Model model) {
        List<ResultData> resultData = resultManageService.findAllResult(); // ResultManageServiceのインスタンスをDIしてからメソッドを呼び出す
        model.addAttribute("resultData", resultData); // モデルに属性を追加する際に属性名を指定する
        System.out.println(resultData);
        return "Result";
    }
}