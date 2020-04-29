package br.com.ferraz.improvemyself.finantial.expectedexpense;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferraz.improvemyself.defaults.DefaultController;

@RestController
@RequestMapping("/expected-expense")
public class ExpectedExpenseController extends DefaultController<ExpectedExpense, ExpectedExpenseDto> {

    ExpectedExpenseService service;


    public ExpectedExpenseController(@Autowired ExpectedExpenseService service) {
        super(service);
        this.service = service;
    }


    @GetMapping("/")
    public Page<ExpectedExpense> list(Pageable pageable) {
        return this.service.findByFilters(pageable);
    }

}