package br.com.ferraz.improvemyself.finantial.expensepermonth;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.finantial.expectedexpense.ExpectedExpense;
import br.com.ferraz.improvemyself.finantial.expectedexpense.ExpectedExpenseRepository;
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

    @Autowired
    private ExpectedExpenseRepository expectedExpenseRepository;


	public List<ExpensePerMonth> buildExpensesPerMonthList(String yearAsString) {
        List<ExpensePerMonth> list = new ArrayList<>();

        int year = Integer.parseInt(yearAsString);

        Iterable<ExpenseCategory> categories = categoryRepository.findAll();

        categories.forEach(category -> {
            List<Expense> expenses = expenseRepository.findByCategoryAndYear(category, year);
            Optional<ExpectedExpense> expectedExpense = expectedExpenseRepository.findFirstByCategory(category);

            list.add(new ExpensePerMonth(category, expenses, expectedExpense));
        });

        Collections.sort(list);

		return list;
	}

}