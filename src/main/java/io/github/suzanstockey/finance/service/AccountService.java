package io.github.suzanstockey.finance.service;

import io.github.suzanstockey.finance.model.Account;
import io.github.suzanstockey.finance.model.User;
import io.github.suzanstockey.finance.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public List<Account> getAllAccountsByUser(User user) {
        return accountRepository.findByUser(user);
    }

    public Optional<Account> getAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account updateAccount(Long id, Account accountDetails){
        Account account = accountRepository.findById(id).orElseThrow(() -> new RuntimeException("Account not found. ID: " + id + ". Update failed."));
        account.setName(accountDetails.getName());
        account.setType(accountDetails.getType());
        account.setUser(accountDetails.getUser());
        account.setValue(accountDetails.getValue());

        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
