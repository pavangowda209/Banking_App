package com.main_project.Bankig.app.Service;

import com.main_project.Bankig.app.Dto.AccountDto;

import java.util.List;

public interface AccountService {
    // Create account
    AccountDto addAccount(AccountDto accountDto);
    //get account by id
    AccountDto getAccountById(Long id);
    // deposite amount
    AccountDto depositAmount(Long id, double amount);
    //Withdraw amount from the account
    AccountDto withdrawAmount(Long id,double amount);
    //Get all accounts
    List<AccountDto> GetallAccounts();
    //Delete account by using Id
    void DeleteAccountById(Long id);
}
