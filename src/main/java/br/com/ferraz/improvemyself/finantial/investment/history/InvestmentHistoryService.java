package br.com.ferraz.improvemyself.finantial.investment.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.defaults.DefaultService;

@Service
public class InvestmentHistoryService extends DefaultService<InvestmentHistory> {

    private InvestmentHistoryRepository repository;


    public InvestmentHistoryService(@Autowired InvestmentHistoryRepository repository) {
        super(repository, InvestmentHistory.class);

        this.repository = repository;
    }
    

	public Page<InvestmentHistory> list(Integer year, Integer month, Integer investmentId, Pageable pageable) {
        return this.repository.findByFilters(year, month, investmentId, pageable);
	}
    
}