package br.com.ferraz.improvemyself.finantial.investment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvestmentRepository extends PagingAndSortingRepository<Investment, Integer> {

    @Query(
        " select i from Investment i where "
        + " (i.name like '%' || :name || '%' or :name is null) "
    )
    Page<Investment> findByFilters(String name, Pageable pageable);

    Investment findByName(String name);
    
}