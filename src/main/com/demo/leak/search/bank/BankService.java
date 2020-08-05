package main.com.demo.leak.search.bank;

import main.com.demo.leak.search.bank.model.Balance;
import main.com.demo.leak.search.bank.model.Client;
import main.com.demo.leak.search.bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    @Autowired
    private BankPostgresRepository repository;

    public Client newClient(Integer balance) {
        Client client = repository.createClient(new Client(0, "", "", ""));
        repository.createTransaction(new Transaction(0,0, client.getId(), balance));
        return client;
    }

    public Transaction newTransaction(Transaction transaction) {
        return repository.createTransaction(transaction);
    }

    public Balance getBalance(Integer clientId) {
        return repository.getBalance(clientId);
    }
}
