package is.hi.quiz.Controllers;

import is.hi.quiz.Persistance.Entities.Account;
import is.hi.quiz.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {

    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/accounts")
    public List<Account> getAccounts() {
        List<Account> accounts = accountService.findAll();
        return accounts;
    }

    //login
    @RequestMapping(value = "loginAPI", method = RequestMethod.POST)
    public Account loginPost(@RequestBody Account account) {
        Account exists = accountService.login(account);
        if (exists != null) {
            return account;
        }
        else return null;
    }

    // save account
    @PostMapping("/signup")
    Account newAccount(@RequestBody Account newAccount) {
        Account exists = accountService.findByUsername(newAccount.getUsername());
        if (exists == null) {
            return accountService.save(newAccount);
        }
        else return null;
    }




}
