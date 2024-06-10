package com.mfi.love_microfinance.controller;


import com.mfi.love_microfinance.entity.Client;
import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.models.ClientModel;
import com.mfi.love_microfinance.service.ClientService;
import com.mfi.love_microfinance.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    private List<ClientModel> getAllClient(){
        return  clientService.getAllClient();
    }

    @GetMapping("/{id}")
    public  ClientModel getClient(@PathVariable Integer id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public  ClientModel createClient(@RequestBody ClientModel client){
        return  clientService.createClient(client);
    }

    @PutMapping("/{id}")
    public  ClientModel updateClient(@PathVariable Integer id,@RequestBody ClientModel client){
        return clientService.updateClient(id,client);
    }

    @DeleteMapping("{id}")
    public  void deleteClient(@PathVariable Integer id){
        clientService.deleteClient(id);
    }

}
