package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import com.Inunu1.ShogiDojoRatingCalculator.service.QrCodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class qrController {
    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping(value = "/qr")
    public String generateQrCode(@RequestParam String qrText, Model model) throws Exception {
        byte[] imageBytes = qrCodeService.generateQrCode(qrText, 256, 256);
        model.addAttribute("qrText", qrText);
        return "misc";
    }

    @GetMapping("/imageBytes/{qrText}")
    @ResponseBody
    public byte[] getImage(@PathVariable String qrText) throws IOException, WriterException {
        // URLではないので読み取っても何も起こりません
        return qrCodeService.generateQrCode(qrText, 256, 256);
    }
}
