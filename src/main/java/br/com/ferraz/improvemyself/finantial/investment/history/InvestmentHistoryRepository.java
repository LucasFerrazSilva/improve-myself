package br.com.ferraz.improvemyself.finantial.investment.history;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.ferraz.improvemyself.finantial.investment.Investment;

public interface InvestmentHistoryRepository extends PagingAndSortingRepository<InvestmentHistory, Integer> {

    @Query(
        " select i from InvestmentHistory i where "
        + " (i.month = :month or :month is null) "
        + " and (i.year = :year or :year is null) "
        + " and (i.investment.id = :investmentId or :investmentId is null) "
    )
    Page<InvestmentHistory> findByFilters(Integer month, Integer year, Integer investmentId, Pageable pageable);

}