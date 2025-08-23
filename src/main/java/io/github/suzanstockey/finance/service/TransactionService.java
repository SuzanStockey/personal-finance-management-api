package io.github.suzanstockey.finance.service;

import io.github.suzanstockey.finance.model.Account;
import io.github.suzanstockey.finance.model.Transaction;
import io.github.suzanstockey.finance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> getAllTransactionsByAccount(Account account) {
        return transactionRepository.findByAccount(account);
    }

    public Optional<Transaction> getTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction updateTransaction(Long id, Transaction transactionDetails){
        Transaction transaction = transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found. ID: " + id + ". Update failed."));
        transaction.setDescription(transactionDetails.getDescription());
        transaction.setType(transactionDetails.getType());
        transaction.setAccount(transactionDetails.getAccount());
        transaction.setDate(transactionDetails.getDate());
        transaction.setAmount(transactionDetails.getAmount());

        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }
}
