package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import ch.qos.logback.core.model.Model;
import com.Inunu1.ShogiDojoRatingCalculator.service.QrCodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class qrController {
    String text;
    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping(value = "/qr")
    public String generateQrCode(@RequestParam String text, Model model) throws Exception {
        // TODO 生成したQRコードをバイナリとしてDB保存すれば、対局ごとに一意にできそう
        byte[] imageBytes = qrCodeService.generateQrCode(text, 256, 256);
        //model.addAttribute("imageBytes", imageBytes);
        //model.addAttribute("message", "QRコードを生成しました!");

        return "misc";
    }

    @GetMapping("/imageBytes")
    @ResponseBody
    public byte[] getImage() throws IOException, WriterException {
        // URLではないので読み取っても何も起こりません
        String imageUrl = text;
        return qrCodeService.generateQrCode(text, 256, 256);
    }
}
