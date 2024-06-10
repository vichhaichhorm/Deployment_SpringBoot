package com.mfi.love_microfinance.controller;

import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.entity.Stuff;
import com.mfi.love_microfinance.models.StuffModel;
import com.mfi.love_microfinance.service.StuffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stuff")
public class StuffController {


    private final StuffService stuffService;

    public StuffController(StuffService stuffService) {
        this.stuffService = stuffService;
    }


    @GetMapping
    private List<StuffModel> getAllStuff(){
        return  stuffService.getAllStuff();
    }

    @GetMapping("/{id}")
    public StuffModel getStuff(@PathVariable Integer id){
        return  stuffService.getStuffById(id);
    }

    @PostMapping
    public  StuffModel createStuff(@RequestBody StuffModel stuff){
        return  stuffService.createStuff(stuff);
    }

    @PutMapping("/{id}")
    public  StuffModel updateStuff(@PathVariable Integer id,@RequestBody StuffModel stuffDetails){
        return stuffService.updateStuff(id,stuffDetails);
    }

    @DeleteMapping("{id}")
    public  void deleteStuff(@PathVariable Integer id){
        stuffService.deleteStuff(id);
    }
}
