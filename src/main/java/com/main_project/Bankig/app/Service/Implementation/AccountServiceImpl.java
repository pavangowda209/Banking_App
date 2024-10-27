package com.main_project.Bankig.app.Service.Implementation;

import com.main_project.Bankig.app.Dto.AccountDto;
import com.main_project.Bankig.app.Entity.Account;
import com.main_project.Bankig.app.Mapper.AccountMapper;
import com.main_project.Bankig.app.Repository.AccountRepository;
import com.main_project.Bankig.app.Service.AccountService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    // Creating dependecy Injection of AccountRepository
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto addAccount(AccountDto accountDto) {
        Account account = AccountMapper.maptoAccount(accountDto);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exists"));
        return AccountMapper.maptoAccountDto(account);
    }

    @Override
    public AccountDto depositAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't exists"));
        double total = account.getBalance() + amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdrawAmount(Long id, double amount) {
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't exists"));

        // check the account balance if the balance is exceeded the amount withdraw then terminate this loop
        if(account.getBalance() < amount) {
            throw new RuntimeException("Amount in the bank account is lesser than the amount of withdraw");
        }
        Double total = account.getBalance() - amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.maptoAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> GetallAccounts() {
        List<Account> accounts = accountRepository.findAll();
        // By using lambda expressions we can change the account into accountdto
        return accounts.stream().map((account) -> AccountMapper.maptoAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void DeleteAccountById(Long id) {
        // check the account by id if it exist or not
        Account account = accountRepository.findById(id).orElseThrow(()-> new RuntimeException("Account doesn't exists"));
        accountRepository.deleteById(id);
    }
}
