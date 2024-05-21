package com.nabilla.myasset.controller;

import com.nabilla.myasset.model.Asset;
import com.nabilla.myasset.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/report")
public class AssetController {

    @Autowired
    AssetService assetService;

    public static String TYPE = "text/csv";

    public static boolean hasCSVFormat(MultipartFile file) {
        return TYPE.equals(file.getContentType());
    }

    @GetMapping("/")
    public String showReportPage(Model model) {
        List<Asset> assets = assetService.getList();
        model.addAttribute("list", assets);

        return "asset-report";
    }

    @GetMapping("/download")
    public String showDownloadPage() {
        return "asset-report";
    }

    @GetMapping("/upload")
    public String showUploadPage(Model model) {

        return "upload-asset";
    }

    @PostMapping("/save")
    public String saveReport(
            @RequestParam("file") MultipartFile file,
            Model model) {
        String message = "";

        if (hasCSVFormat(file)) {
            try {
                assetService.save(file);

                message = "Records [" + file.getOriginalFilename() + "] are saved successfully!";
                model.addAttribute("message", message);

                return "redirect:/report/";
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                model.addAttribute("message", message);

                return "redirect:/report/";
            }
        }

        message = "Please upload csv format only!";
        model.addAttribute("message", message);

        return "redirect:/report/";
    }
}
