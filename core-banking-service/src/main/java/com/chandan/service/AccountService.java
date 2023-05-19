package com.chandan.service;

import com.chandan.exception.EntityNotFoundException;
import com.chandan.model.dto.BankAccount;
import com.chandan.model.dto.UtilityAccount;
import com.chandan.model.entity.BankAccountEntity;
import com.chandan.model.entity.UtilityAccountEntity;
import com.chandan.model.mapper.BankAccountMapper;
import com.chandan.model.mapper.UtilityAccountMapper;
import com.chandan.repository.BankAccountRepository;
import com.chandan.repository.UtilityAccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {

    private BankAccountMapper bankAccountMapper = new BankAccountMapper();
    private UtilityAccountMapper utilityAccountMapper = new UtilityAccountMapper();

    private final BankAccountRepository bankAccountRepository;
    private final UtilityAccountRepository utilityAccountRepository;

    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity entity = bankAccountRepository.findByNumber(accountNumber).orElseThrow(EntityNotFoundException::new);
        return bankAccountMapper.convertToDto(entity);
    }

    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).orElseThrow(EntityNotFoundException::new);
        return utilityAccountMapper.convertToDto(utilityAccountEntity);
    }

    public UtilityAccount readUtilityAccount(Long id){
        return utilityAccountMapper.convertToDto(utilityAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new));
    }

}
