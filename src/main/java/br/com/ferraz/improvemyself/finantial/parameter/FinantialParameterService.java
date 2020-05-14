package br.com.ferraz.improvemyself.finantial.parameter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public List<FinantialParameter> findAll() {
        Iterable<FinantialParameter> iterable = this.repository.findAll();

        List<FinantialParameter> list = new ArrayList<>();

        iterable.forEach(list::add);

        Collections.sort(list);

        return list;
    }

}