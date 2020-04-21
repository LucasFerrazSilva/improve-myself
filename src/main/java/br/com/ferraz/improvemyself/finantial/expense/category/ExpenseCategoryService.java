package br.com.ferraz.improvemyself.finantial.expense.category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.defaults.DefaultService;

@Service
public class ExpenseCategoryService extends DefaultService<ExpenseCategory> {

    private ExpenseCategoryRepository repository;


    public ExpenseCategoryService(@Autowired ExpenseCategoryRepository repository) {
        super(repository, ExpenseCategory.class);

        this.repository = repository;
    }

    
    public Page<ExpenseCategory> list(String name, Pageable pageable) {
        return this.repository.findByFilters(name, pageable);
    }

    public List<ExpenseCategory> findAll() {
        Iterable<ExpenseCategory> iterable = this.repository.findAll();

        List<ExpenseCategory> list = new ArrayList<>();

        iterable.forEach(list::add);

        Collections.sort(list);

        return list;
    }

}