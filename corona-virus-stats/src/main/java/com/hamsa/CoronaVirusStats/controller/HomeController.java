package com.hamsa.CoronaVirusStats.controller;

import com.hamsa.CoronaVirusStats.dataservices.CoronaVirusDataServices;
import com.hamsa.CoronaVirusStats.model.CoronaVirusLiveDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping; 

import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    CoronaVirusDataServices coronaVirusDataServices;

    @GetMapping("/")
    public String home(Model model) throws IOException, InterruptedException {
        List<CoronaVirusLiveDetails> coronaVirusLiveDetailsList = coronaVirusDataServices.getAllCoronaVirus();
        int totalCases = coronaVirusLiveDetailsList.stream().mapToInt(CoronaVirusLiveDetails::getDeathCount).sum();

        model.addAttribute("locationStats", coronaVirusLiveDetailsList);
        model.addAttribute("totalCoronaCount", totalCases);

        return "home";
    }
}
