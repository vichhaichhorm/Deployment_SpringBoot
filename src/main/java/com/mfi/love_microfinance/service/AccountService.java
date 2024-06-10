package com.mfi.love_microfinance.service;

import com.mfi.love_microfinance.entity.Client;
import com.mfi.love_microfinance.entity.Stuff;
import com.mfi.love_microfinance.repository.AcountRepository;
import com.mfi.love_microfinance.repository.ClientRepository;
import com.mfi.love_microfinance.repository.StuffRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private StuffRepository stuffRepository;

    @Autowired
    private AcountRepository acountRepository;


}
