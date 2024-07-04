package com.mfi.love_microfinance.controller;

import com.mfi.love_microfinance.models.LandTitleModel;
import com.mfi.love_microfinance.service.LandTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/landtitle")
public class LandTitleController {
    @Autowired
    private LandTitleService landTitleService;
    @PostMapping
    public LandTitleModel createLandTitle(@RequestBody LandTitleModel landTitleModel){
        return  landTitleService.createLandTitle(landTitleModel);
    }
    @GetMapping
    public List<LandTitleModel> getAllLandTitle(){
        return  landTitleService.getAllLandTitle();
    }
    @GetMapping("/{id}")
    public  LandTitleModel getLandTitleById(@PathVariable Integer id){
        return  landTitleService.getLandTitleById(id);
    }
    @PutMapping("/{id}")
    public LandTitleModel updateLandTitle(@PathVariable Integer id,@RequestBody LandTitleModel landTitleModel){
       System.out.println("Land title controller update ..... ID "+id.toString());
       if(landTitleModel ==null){
           System.out.println("Land title Controller null  ");

       }
        return  landTitleService.updateLandTitle(id,landTitleModel);
    }
    @DeleteMapping("/{id}")
    public  void deleteLandTitle(@PathVariable Integer id){
        landTitleService.deleteLandTitle(id);
    }

}
