package br.com.ferraz.improvemyself.finantial.expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;
import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategoryRepository;
import br.com.ferraz.improvemyself.defaults.DefaultService;

@Service
public class ExpenseService extends DefaultService<Expense> {

    private ExpenseRepository repository;
    
    @Autowired
    private ExpenseCategoryRepository categoryRepository;


    public ExpenseService(@Autowired ExpenseRepository repository) {
        super(repository, Expense.class);

        this.repository = repository;
    }

    
    public Page<Expense> list(String name, String amountAsString, String expenseDateAsString, String categoryId, Pageable pageable) {
        BigDecimal amount = null;
        LocalDate expenseDate = null;
        ExpenseCategory category = null;
        
        if (amountAsString != null && !amountAsString.isEmpty()) {
            try {
                amount = new BigDecimal(amountAsString);
            } catch (NumberFormatException e) {
                System.out.println("Unnable to convert " + amountAsString + " to BigDecimal");
            }
        }

        try {
            if (expenseDateAsString != null && !expenseDateAsString.isEmpty() && !expenseDateAsString.equals("undefined")) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                expenseDate = LocalDate.parse(expenseDateAsString, formatter);
            }
        } catch (DateTimeParseException e) {
            System.out.println("Unnable to convert " + expenseDateAsString + " to LocalDate");
        }

        if (categoryId != null && !categoryId.isEmpty() && !categoryId.equals("undefined")) {
            try {
                category = this.categoryRepository.findById(Integer.parseInt(categoryId)).orElse(null);
            } catch (NumberFormatException e) {
                System.out.println("Unnable to convert categoryId " + categoryId + " to Integer");
            }
        }

        return this.repository.findByFilters(name, amount, expenseDate, category, pageable);
    }

}