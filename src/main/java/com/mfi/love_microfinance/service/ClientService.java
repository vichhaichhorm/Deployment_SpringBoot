package com.mfi.love_microfinance.service;


import com.mfi.love_microfinance.entity.Client;
import com.mfi.love_microfinance.entity.Department;
import com.mfi.love_microfinance.models.ClientModel;
import com.mfi.love_microfinance.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<ClientModel> getAllClient(){
       List<Client> clients= clientRepository.findAll();
       List<ClientModel> clientModels = new ArrayList<>();
        for (Client client :
             clients) {
            ClientModel clientModel= new  ClientModel();
            clientModel.setId(client.getId());
            clientModel.setName(client.getName());
            clientModel.setSex(client.getSex());
            clientModel.setDob(client.getDob());
            clientModel.setAddress(client.getAddress());
            clientModel.setCid(client.getCid());
            clientModel.setSalary(client.getSalary());
            clientModel.setStatus(client.getStatus());
            clientModel.setEducation(client.getEducation());
            clientModel.setJob(client.getJob());
            clientModel.setPhone(client.getPhone());

            clientModel.setHaveAccount(!client.getAcount1().isEmpty() || !client.getAcount2().isEmpty());
            clientModels.add(clientModel);
        }
        return  clientModels;
    }

    public ClientModel getClientById(Integer id){
       Client client= clientRepository.findById(id).orElse(null);
        ClientModel clientModel= new  ClientModel();
        clientModel.setId(client.getId());
        clientModel.setName(client.getName());
        clientModel.setSex(client.getSex());
        clientModel.setDob(client.getDob());
        clientModel.setAddress(client.getAddress());
        clientModel.setCid(client.getCid());
        clientModel.setSalary(client.getSalary());
        clientModel.setStatus(client.getStatus());
        clientModel.setEducation(client.getEducation());
        clientModel.setJob(client.getJob());
        clientModel.setPhone(client.getPhone());
        clientModel.setHaveAccount(!client.getAcount1().isEmpty() || !client.getAcount2().isEmpty());
        return  clientModel;
    }

    public  ClientModel createClient(ClientModel clientDetails){
Client client=new Client();

        client.setName(clientDetails.getName());
        client.setSex(clientDetails.getSex());
        client.setDob(clientDetails.getDob());
        client.setCid(clientDetails.getCid());
        client.setAddress(clientDetails.getAddress());
        client.setJob(clientDetails.getJob());
        client.setSalary(clientDetails.getSalary());
        client.setEducation(clientDetails.getEducation());
        client.setStatus(clientDetails.getStatus());
        client.setPhone(clientDetails.getPhone());
     Client saveClient=   clientRepository.save(client);
     clientDetails.setId(saveClient.getId());
        return clientDetails;
    }

    public  ClientModel updateClient(Integer id, ClientModel clientDetails){
        Client client=clientRepository.findById(id).orElse(null);
        if(client!=null){
            client.setName(clientDetails.getName());
            client.setSex(clientDetails.getSex());
            client.setDob(clientDetails.getDob());
            client.setCid(clientDetails.getCid());
            client.setAddress(clientDetails.getAddress());
            client.setJob(clientDetails.getJob());
            client.setSalary(clientDetails.getSalary());
            client.setEducation(clientDetails.getEducation());
            client.setStatus(clientDetails.getStatus());
            client.setPhone(clientDetails.getPhone());
            clientRepository.save(client);
            clientDetails.setId(id);

            return  clientDetails;
        }
        return  null;
    }

    public  void deleteClient(Integer id){
        clientRepository.deleteById(id);
    }
}
