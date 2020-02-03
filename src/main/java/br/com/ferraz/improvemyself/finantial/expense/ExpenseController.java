package br.com.ferraz.improvemyself.finantial.expense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseRepository repository;

    @GetMapping("/")
    public Page<Expense> list(Pageable pageable) {
        return this.repository.findAll(pageable);
    }
    
}