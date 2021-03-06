package br.com.ferraz.improvemyself.finantial.expectedexpense;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;

public interface ExpectedExpenseRepository extends PagingAndSortingRepository<ExpectedExpense, Integer> {

    @Query(
        " select e from ExpectedExpense e where "
        + " (e.category.id = :categoryId or :categoryId is null) "
    )
    Page<ExpectedExpense> findByFilters(Integer categoryId, Pageable pageable);

    Optional<ExpectedExpense> findFirstByCategory(ExpenseCategory category);

}