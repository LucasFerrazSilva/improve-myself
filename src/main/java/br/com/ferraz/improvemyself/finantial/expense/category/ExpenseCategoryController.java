package br.com.ferraz.improvemyself.finantial.expense.category;

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
@RequestMapping("/expense-category")
public class ExpenseCategoryController extends DefaultController<ExpenseCategory, ExpenseCategoryDto> {

    private ExpenseCategoryService service;


    public ExpenseCategoryController(@Autowired ExpenseCategoryService service) {
        super(service);

        this.service = service;
    }

    
    @GetMapping("/")
    public Page<ExpenseCategory> list(@RequestParam("name") String name, Pageable pageable) {
        return this.service.list(name, pageable);
    }

    @GetMapping("/find-all")
    public List<ExpenseCategory> findAll() {
        return this.service.findAll();
    }

}