package br.com.ferraz.improvemyself.finantial.expense.category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpenseCategoryRepository extends PagingAndSortingRepository<ExpenseCategory, Integer> {

    @Query(
        "select e from ExpenseCategory e where "
        + " (e.name like '%' || :name || '%' or :name = '') "
    )
    Page<ExpenseCategory> findByFilters(String name, Pageable pageable);
    
}