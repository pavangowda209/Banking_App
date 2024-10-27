package com.main_project.Bankig.app.Mapper;

import com.main_project.Bankig.app.Dto.AccountDto;
import com.main_project.Bankig.app.Entity.Account;

public class AccountMapper {
    public static AccountDto maptoAccountDto(Account account) {
        AccountDto dto = new AccountDto(account.getId(),account.getAccountHolderName(),account.getBalance());
        return  dto;
    }
    public static Account maptoAccount(AccountDto accountDto) {
        Account account = new Account(accountDto.getId(),accountDto.getAccountHolderName(),accountDto.getBalance());
        return account;
    }
}
