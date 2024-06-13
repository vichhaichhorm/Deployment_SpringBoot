package com.mfi.love_microfinance.controller;

import com.mfi.love_microfinance.models.LandTitleModel;
import com.mfi.love_microfinance.service.LandTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/landtitle")
public class LandTitleController {
    @Autowired
    private LandTitleService landTitleService;
    @PostMapping
    public LandTitleModel createLandTitle(@RequestBody LandTitleModel landTitleModel){
        return  landTitleService.createLandTitle(landTitleModel);
    }
}
