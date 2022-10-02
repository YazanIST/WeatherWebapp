package com.atypon.analytics_service.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AnalysisController {
    private final AnalysisService analysisService;

    @Autowired
    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @Scheduled(fixedRate = 10000)
    @GetMapping("/*")
    @ResponseBody
    public List<AnalyzedData> postAnalysis() {
        analysisService.update();
        return analysisService.getAll();
    }
}
