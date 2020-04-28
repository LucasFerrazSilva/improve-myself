package br.com.ferraz.improvemyself.finantial.parameter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FinantialParameterRepository extends PagingAndSortingRepository<FinantialParameter, Integer> {

    @Query(
        " select p from FinantialParameter p where "
        + " (p.name like '%' || :name || '%' or :name is null) "
    )
    Page<FinantialParameter> findByFilters(String name, Pageable pageable);

}