package br.com.ferraz.improvemyself.finantial.expensepermonth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses-per-month")
public class ExpensePerMonthController {

    @Autowired
    private ExpensePerMonthService service;

    @GetMapping("/{year}")
    public List<ExpensePerMonth> list(@PathVariable("year") String year) {
        return service.buildExpensesPerMonthList(year);
    }

}