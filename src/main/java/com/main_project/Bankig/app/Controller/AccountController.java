package com.main_project.Bankig.app.Controller;

import com.main_project.Bankig.app.Dto.AccountDto;
import com.main_project.Bankig.app.Entity.Account;
import com.main_project.Bankig.app.Service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    // Create a dependency injection of AccountService
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    //add account api
    @PostMapping("/account")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.addAccount(accountDto), HttpStatus.CREATED);
    }

    // get account api
    @RequestMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountByid(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.getAccountById(id),HttpStatus.CREATED);
    }
    //deposit amount into bank account
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmount(@PathVariable Long id, @RequestBody Map<String,Double>Request) {
        Double amount = Request.get("amount");
        AccountDto accountDto = accountService.depositAmount(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    // Withdraw amount Api
    @PutMapping("{id}/Withdraw")
    public ResponseEntity<AccountDto> WithdrawAmount(@PathVariable Long id,@RequestBody Map<String,Double> Request) {
        Double amount = Request.get("amount");
        AccountDto accountDto = accountService.withdrawAmount(id,amount);
        return ResponseEntity.ok(accountDto);
    }
    // Get all accounts RestApi
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.GetallAccounts();
        return ResponseEntity.ok(accounts);
    }
    // Delete account by id RestApi
    @DeleteMapping("/{id}/Delete")
    public ResponseEntity<String>deleteAccountById(@PathVariable Long id) {
        accountService.DeleteAccountById(id);
        return ResponseEntity.ok("Account is deleted Successfully...");
    }
}

