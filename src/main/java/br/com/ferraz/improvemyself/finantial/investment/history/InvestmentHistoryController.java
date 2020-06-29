package br.com.ferraz.improvemyself.finantial.investment.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ferraz.improvemyself.defaults.DefaultController;

@RestController
@RequestMapping("/investment/history")
public class InvestmentHistoryController extends DefaultController<InvestmentHistory, InvestmentHistoryDto> {

    private InvestmentHistoryService service;


    public InvestmentHistoryController(@Autowired InvestmentHistoryService service) {
        super(service);
        this.service = service;
    }

    
    @GetMapping("/")
    public Page<InvestmentHistory> list(@RequestParam("year") Integer year, @RequestParam("month") Integer month, 
                                            @RequestParam("investmentId") Integer investmentId, Pageable pageable) {
        return this.service.list(year, month, investmentId, pageable);
    }
    
}