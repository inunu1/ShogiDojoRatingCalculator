package com.Inunu1.ShogiDojoRatingCalculator.Controller;

import ch.qos.logback.core.model.Model;
import com.Inunu1.ShogiDojoRatingCalculator.service.QrCodeService;
import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.List;
import java.awt.image.BufferedImage;

@Controller
public class QrTestController {
    @Autowired
    private QrCodeService qrCodeService;

    @GetMapping(value = "/qr")
    public String generateQrCode(Model model) throws Exception {
        // TODO 生成したQRコードをバイナリとしてDB保存すれば、対局ごとに一意にできそう
        String imageText = "Sample Text";
        byte[] imageBytes = qrCodeService.generateQrCode(imageText, 256, 256);
        //model.addAttribute("imageBytes", imageBytes);
        //model.addAttribute("message", "QRコードを生成しました!");

        return "misc";
    }

    @GetMapping("/imageBytes")
    @ResponseBody
    public byte[] getImage() throws IOException, WriterException {
        // URLではないので読み取っても何も起こりません
        String imageUrl = "Hello Inunu1";
        return qrCodeService.generateQrCode(imageUrl, 256, 256);
    }
}
