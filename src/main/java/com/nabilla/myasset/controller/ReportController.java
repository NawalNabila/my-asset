package com.nabilla.myasset.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myasset/report")
public class ReportController {

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
}
