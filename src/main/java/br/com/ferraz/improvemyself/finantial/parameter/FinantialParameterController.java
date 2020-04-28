package br.com.ferraz.improvemyself.finantial.parameter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferraz.improvemyself.defaults.DefaultController;

@RestController
@RequestMapping("/finantial-parameter")
public class FinantialParameterController extends DefaultController<FinantialParameter, FinantialParameterDto> {

    FinantialParameterService service;

    public FinantialParameterController(@Autowired FinantialParameterService service) {
        super(service);
        this.service = service;
    }

    @GetMapping("/")
    public Page<FinantialParameter> list(@RequestParam("name") String name, Pageable pageable) {
        return this.service.list(name, pageable);
    }

}