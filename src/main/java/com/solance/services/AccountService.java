package com.solance.services;

import com.solance.entities.AccountEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {

    // HashMap will act as repository
    Map<String, AccountEntity> accountMap = new HashMap<>();

    public String AddAccountEntry(AccountEntity accountEntity){
        accountMap.put(accountEntity.getAccountId(),accountEntity);
        return "Account added successfully";
    }

    public AccountEntity GetAccountById(String accountId){
        return accountMap.get(accountId);
    }

    public List<AccountEntity> GetAllAccounts(){
        return new ArrayList<AccountEntity>(accountMap.values());
    }

    public String UpdateAccount(AccountEntity accountEntity){
        accountMap.put(accountEntity.getAccountId(),accountEntity);
        return "Account updated successfully";
    }

    public String DeleteAccount(String accountId){
        accountMap.remove(accountId);
        return "Account deleted successfully";
    }


    public String CreateAllAccountEntries(List<AccountEntity> accountEntities){
        for(AccountEntity entry : accountEntities) {
            accountMap.put(entry.getAccountId(), entry);
        }
        return "Accounts Added successfully";
    }



}
