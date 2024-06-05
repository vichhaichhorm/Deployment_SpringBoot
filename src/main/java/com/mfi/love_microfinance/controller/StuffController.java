package com.mfi.love_microfinance.controller;

import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.entity.Stuff;
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
    private List<Stuff> getAllStuff(){
        return  stuffService.getAllStuff();
    }

    @GetMapping("/{id}")
    public Stuff getStuff(@PathVariable Integer id){
        return  stuffService.getStuffById(id);
    }

    @PostMapping
    public  Stuff createStuff(@RequestBody Stuff stuff){
        return  stuffService.createStuff(stuff);
    }

    @PutMapping("/{id}")
    public  Stuff updateStuff(@PathVariable Integer id,@RequestBody Stuff stuffDetails){
        return stuffService.updateStuff(id,stuffDetails);
    }

    @DeleteMapping("{id}")
    public  void deleteStuff(@PathVariable Integer id){
        stuffService.deleteStuff(id);
    }
}
