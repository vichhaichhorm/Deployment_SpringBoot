package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Acount;
import com.mfi.love_microfinance.entity.LandTitle;
import com.mfi.love_microfinance.models.LandTitleModel;
import com.mfi.love_microfinance.repository.AcountRepository;
import com.mfi.love_microfinance.repository.LanTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LandTitleService {
    @Autowired
    private LanTitleRepository lanTitleRepository;
    @Autowired
    private AcountRepository acountRepository;
    public LandTitleModel createLandTitle(LandTitleModel landTitleModel){
        LandTitle landTitle=new LandTitle();
        landTitle.setType(landTitleModel.getType());
        landTitle.setArea(landTitleModel.getArea());
        landTitle.setConfirmBy(landTitleModel.getConfirmBy());
        landTitle.setAddress(landTitleModel.getAddress());
        landTitle.setFirstOwner(landTitleModel.getFirstOwner());
        landTitle.setSecondOwner(landTitleModel.getSecondOwner());

        Acount acount=new Acount();
        acount=acountRepository.findById(landTitleModel.getAccountId()).orElse(null);
        if(acount!=null){
            landTitle.setAccount(acount);
            landTitle=lanTitleRepository.save(landTitle);
            landTitleModel.setId(landTitle.getId());
            return  landTitleModel;
        }
        return  null;
    }

    public  LandTitleModel updateLandTitle(Integer id,LandTitleModel landTitleModel){
        LandTitle landTitle= lanTitleRepository.findById(id).orElse(null);
        if(landTitle!=null){
            System.out.println("land Title is not null from repo");
            landTitle.setType(landTitleModel.getType());
            landTitle.setArea(landTitleModel.getArea());
            landTitle.setConfirmBy(landTitleModel.getConfirmBy());
            landTitle.setAddress(landTitleModel.getAddress());
            landTitle.setFirstOwner(landTitleModel.getFirstOwner());
            landTitle.setSecondOwner(landTitleModel.getSecondOwner());
            landTitle.setId(id);

            Acount acount=acountRepository.findById(landTitleModel.getAccountId()).orElse(null);
            if(acount!=null){

                System.out.println("account is not null from repo");
                landTitle.setAccount(acount);
               lanTitleRepository.save(landTitle);
                landTitleModel.setId(landTitle.getId());
                return  landTitleModel;
            }
        }

        return  null;
    }

    public List<LandTitleModel> getAllLandTitle(){
        List<LandTitleModel> landTitleModels=new ArrayList<>();
        List<LandTitle> landTitles=lanTitleRepository.findAll();
        for (LandTitle lanTitle:landTitles
             ) {
            LandTitleModel landTitleModel=new LandTitleModel();
            landTitleModel.setId(lanTitle.getId());
            landTitleModel.setAddress(lanTitle.getAddress());
            landTitleModel.setConfirmBy(lanTitle.getConfirmBy());
            landTitleModel.setArea(lanTitle.getArea());
            landTitleModel.setFirstOwner(lanTitle.getFirstOwner());
            landTitleModel.setSecondOwner(lanTitle.getSecondOwner());
            landTitleModel.setType(lanTitle.getType());
            landTitleModel.setAccountId(lanTitle.getAccount().getId());
            landTitleModel.setAccountName(lanTitle.getAccount().getClient1().getName());
            landTitleModels.add(landTitleModel);
        }

        return  landTitleModels;
    }
        public void  deleteLandTitle(Integer id){lanTitleRepository.deleteById(id);}

    public  LandTitleModel getLandTitleById(Integer id){
        LandTitleModel landTitleModel=new LandTitleModel();
        LandTitle landTitle=lanTitleRepository.findById(id).orElse(null);

        landTitleModel.setId(landTitle.getId());
        landTitleModel.setAddress(landTitle.getAddress());
        landTitleModel.setConfirmBy(landTitle.getConfirmBy());
        landTitleModel.setArea(landTitle.getArea());
        landTitleModel.setFirstOwner(landTitle.getFirstOwner());
        landTitleModel.setSecondOwner(landTitle.getSecondOwner());
        landTitleModel.setType(landTitle.getType());
        landTitleModel.setAccountId(landTitle.getAccount().getId());
        landTitleModel.setAccountName(landTitle.getAccount().getClient1().getName());
        return  landTitleModel;
    }

}
