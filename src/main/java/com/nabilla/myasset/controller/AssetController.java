package com.nabilla.myasset.controller;

import com.nabilla.myasset.helper.CSVHelper;
import com.nabilla.myasset.service.AssetService;
import com.opencsv.exceptions.CsvException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.MultipartFilter;

import java.io.IOException;

@Controller
@RequestMapping("/assets")
public class AssetController {

    @Autowired
    AssetService assetService;

    @Bean
    @Order(0)
    public MultipartFilter multipartFilter() {
        MultipartFilter multipartFilter = new MultipartFilter();
        multipartFilter.setMultipartResolverBeanName("multipartReso‌​lver");
        return multipartFilter;
    }

    @GetMapping("/")
    public String showReportPage() {
        return "asset-report";
    }

    @GetMapping("/download")
    public String showDownloadPage() {
        return "asset-report";
    }

    @GetMapping("/upload")
    public String showUploadPage() {
        return "upload-asset";
    }

    @PostMapping("/save")
    public String saveReport(
            @RequestParam("file") MultipartFile file,
            Model model) throws IOException, CsvException {
        assetService.saveCSVData(file);
        String message = "Records ["+ file.getOriginalFilename() +"] are saved successfully!";
        model.addAttribute("message", message);
        return "role";
    }
}
