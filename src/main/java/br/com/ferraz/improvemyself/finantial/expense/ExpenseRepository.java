package br.com.ferraz.improvemyself.finantial.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Integer> {

    @Query(
        "select e from Expense e where "
        + " (e.name like '%' || :name || '%' or :name = '') "
        + " and (e.amount = :amount or :amount is null) "
        + " and (e.expenseDate = :expenseDate or :expenseDate is null) "
        + " and (e.category = :category or :category is null) "
    )
    Page<Expense> findByFilters(String name, BigDecimal amount, LocalDate expenseDate, ExpenseCategory category, Pageable pageable);
    
}