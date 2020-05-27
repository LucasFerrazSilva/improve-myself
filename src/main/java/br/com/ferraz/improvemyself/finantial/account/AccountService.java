package br.com.ferraz.improvemyself.finantial.account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.defaults.DefaultService;

@Service
public class AccountService extends DefaultService<Account> {

    AccountRepository repository;


    public AccountService(@Autowired AccountRepository repository) {
        super(repository, Account.class);

        this.repository = repository;
    }


	public Page<Account> list(String name, Pageable pageable) {
        return this.repository.findByFilters(name, pageable);
	}

    public List<Account> findAll() {
        Iterable<Account> iterable = this.repository.findAll();

        List<Account> list = new ArrayList<>();

        iterable.forEach(list::add);

        Collections.sort(list);

        return list;
    }

    
}