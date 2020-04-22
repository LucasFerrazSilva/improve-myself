package br.com.ferraz.improvemyself.finantial.expensepermonth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.finantial.expense.Expense;
import br.com.ferraz.improvemyself.finantial.expense.ExpenseRepository;
import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;
import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategoryRepository;

@Service
public class ExpensePerMonthService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseCategoryRepository categoryRepository;


	public List<ExpensePerMonth> buildExpensesPerMonthList(String yearAsString) {
        List<ExpensePerMonth> list = new ArrayList<>();

        int year = Integer.parseInt(yearAsString);

        Iterable<ExpenseCategory> categories = categoryRepository.findAll();

        categories.forEach(category -> {
            List<Expense> expenses = expenseRepository.findByCategoryAndYear(category, year);

            list.add(new ExpensePerMonth(category, expenses));
        });

        Collections.sort(list);

		return list;
	}

}