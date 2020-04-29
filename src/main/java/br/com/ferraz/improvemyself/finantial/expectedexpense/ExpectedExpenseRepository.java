package br.com.ferraz.improvemyself.finantial.expectedexpense;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ExpectedExpenseRepository extends PagingAndSortingRepository<ExpectedExpense, Integer> {

    @Query(
        "select e from ExpectedExpense e"
    )
    Page<ExpectedExpense> findByFilters(Pageable pageable);

}