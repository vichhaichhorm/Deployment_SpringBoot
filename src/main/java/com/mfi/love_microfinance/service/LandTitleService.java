package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Acount;
import com.mfi.love_microfinance.entity.LandTitle;
import com.mfi.love_microfinance.models.LandTitleModel;
import com.mfi.love_microfinance.repository.AcountRepository;
import com.mfi.love_microfinance.repository.LanTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
