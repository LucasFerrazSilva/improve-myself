package br.com.ferraz.improvemyself.finantial.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.ferraz.improvemyself.defaults.DefaultService;

@Service
public class FinantialParameterService extends DefaultService<FinantialParameter> {

    FinantialParameterRepository repository;


    public FinantialParameterService(@Autowired FinantialParameterRepository repository) {
        super(repository, FinantialParameter.class);
        this.repository = repository;
    }


	public Page<FinantialParameter> list(String name, Pageable pageable) {
        return this.repository.findByFilters(name, pageable);
	}

}