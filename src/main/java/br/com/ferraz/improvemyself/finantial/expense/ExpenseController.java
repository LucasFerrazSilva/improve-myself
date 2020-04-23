package br.com.ferraz.improvemyself.finantial.expense;

import java.time.Month;
import java.time.Year;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferraz.improvemyself.defaults.DefaultController;

@RestController
@RequestMapping("/expense")
public class ExpenseController extends DefaultController<Expense, ExpenseDto> {
    
    private ExpenseService service;


    public ExpenseController(@Autowired ExpenseService service) {
        super(service);

        this.service = service;
    }
    

    @GetMapping("/")
    public Page<Expense> list(@RequestParam("name") String name, @RequestParam("amount") String amountAsString, 
                                @RequestParam("expenseDate") String expenseDateAsString, @RequestParam("categoryId") String categoryId,
                                @RequestParam("expenseDateYear") Year expenseDateYear, @RequestParam("expenseDateMonth") Month expenseDateMonth,
                                Pageable pageable) {
        return this.service.list(name, amountAsString, expenseDateAsString, categoryId, expenseDateYear, expenseDateMonth, pageable);
    }
    
}