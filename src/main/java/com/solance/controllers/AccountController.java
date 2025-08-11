package com.solance.controllers;

import com.solance.entities.AccountEntity;
import com.solance.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private AccountService accountService;

    @GetMapping
    public List<AccountEntity> getAllAccount() {
        //Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //String username = authentication.getName();
        return accountService.GetAllAccounts();
    }

    @PostMapping
    public String CreateAccount(@RequestBody AccountEntity account) {
        return accountService.AddAccountEntry(account);
    }

    @PutMapping(("/Id/{Id}"))
    public String UpdateAccount(@RequestBody AccountEntity account) {
        return accountService.UpdateAccount(account);
    }

    @DeleteMapping("/Id/{Id}")
    public String DeleteAccount(@PathVariable String Id) {
        return accountService.DeleteAccount(Id);
    }

    @GetMapping("/Id/{Id}")
    public AccountEntity GetAccountById(@PathVariable String Id) {
        return accountService.GetAccountById(Id);
    }


    @PostMapping("all")
    public String createAllAccountEntries(@RequestBody List<AccountEntity> entry) {
        return accountService.CreateAllAccountEntries(entry);
    }


}
