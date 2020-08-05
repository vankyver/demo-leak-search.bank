package main.com.demo.leak.search.bank;

import main.com.demo.leak.search.bank.model.Balance;
import main.com.demo.leak.search.bank.model.Client;
import main.com.demo.leak.search.bank.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

    @Autowired
    private BankService service;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String healthCheck(){
        return "{\"status\":\"Ok\"}";
    }

    @PostMapping("/client/new/{balance}")
    public Client newClient(@PathVariable Integer balance){
        return service.newClient(balance);
    }

    @PostMapping("/transaction")
    public Transaction newTransaction(@RequestBody Transaction transaction){
        return service.newTransaction(transaction);
    }

    @GetMapping("/client/{id}/balance")
    public Balance getBalance(@PathVariable Integer id){
        return service.getBalance(id);
    }

}
