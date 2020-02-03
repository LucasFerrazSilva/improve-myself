package br.com.ferraz.improvemyself.finantial.expense;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpenseRepository extends PagingAndSortingRepository<Expense, Integer> {

    
}