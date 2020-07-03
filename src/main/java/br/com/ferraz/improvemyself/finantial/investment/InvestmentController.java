package br.com.ferraz.improvemyself.finantial.investment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferraz.improvemyself.defaults.DefaultController;

@RestController
@RequestMapping("/investment")
public class InvestmentController extends DefaultController<Investment, InvestmentDto> {

    private InvestmentService service;


    public InvestmentController(@Autowired InvestmentService service) {
        super(service);

        this.service = service;
    }


    @GetMapping("/")
    public Page<Investment> list(@RequestParam("name") String name, Pageable pageable) {
        return this.service.list(name, pageable);
    }

    @GetMapping("/find-by-name/{name}")
    public Investment findByName(@PathVariable String name) {
        return this.service.findByName(name);
    }
    
}