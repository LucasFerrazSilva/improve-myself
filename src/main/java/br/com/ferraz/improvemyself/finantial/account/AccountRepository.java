package br.com.ferraz.improvemyself.finantial.account;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AccountRepository extends PagingAndSortingRepository<Account, Integer> {
    
    @Query(
        " select a from Account a where "
        + " (a.name like '%' || :name || '%' or :name is null) "
    )
    Page<Account> findByFilters(String name, Pageable pageable);
    
}