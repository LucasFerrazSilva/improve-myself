package br.com.ferraz.improvemyself.finantial.expectedexpense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.defaults.DefaultService;

@Service
public class ExpectedExpenseService extends DefaultService<ExpectedExpense> {

    ExpectedExpenseRepository repository;


    public ExpectedExpenseService(@Autowired ExpectedExpenseRepository repository) {
        super(repository, ExpectedExpense.class);
        this.repository = repository;
    }


    public Page<ExpectedExpense> findByFilters(Pageable pageable) {
        return this.repository.findByFilters(pageable);
    }

}