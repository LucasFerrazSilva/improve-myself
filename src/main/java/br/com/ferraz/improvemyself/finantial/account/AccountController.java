package br.com.ferraz.improvemyself.finantial.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferraz.improvemyself.defaults.DefaultController;

@RestController
@RequestMapping("/account")
public class AccountController extends DefaultController<Account, AccountDto> {

    AccountService service;


    public AccountController(@Autowired AccountService service) {
        super(service);

        this.service = service;
    }

    @GetMapping("/")
    public Page<Account> list(@RequestParam("name") String name, Pageable pageable) {
        return this.service.list(name, pageable);
    }

    @GetMapping("/find-all")
    public List<Account> findAll() {
        return this.service.findAll();
    }
    
}