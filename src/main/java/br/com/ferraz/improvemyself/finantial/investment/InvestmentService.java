package br.com.ferraz.improvemyself.finantial.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.defaults.DefaultService;

@Service
public class InvestmentService extends DefaultService<Investment> {

    private InvestmentRepository repository;


    public InvestmentService(@Autowired InvestmentRepository repository) {
        super(repository, Investment.class);
        
        this.repository = repository;
    }
    

	public Page<Investment> list(String name, Pageable pageable) {
        return this.repository.findByFilters(name, pageable);
	}
    
}