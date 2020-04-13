package br.com.ferraz.improvemyself.finantial.expense;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseRepository repository;

    @GetMapping("/")
    public Page<Expense> list(@RequestParam("name") String name, @RequestParam("amount") String amountAsString, Pageable pageable) {
        BigDecimal amount = null;
        
        try {
            amount = new BigDecimal(amountAsString);
        } catch (NumberFormatException e) {
            if (amountAsString != null && !amountAsString.isEmpty())
                System.out.println("Unnable to convert " + amountAsString + " to BigDecimal");
        }

        return this.repository.findByFilters(name, amount, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        try {
            Expense object = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));

            return new ResponseEntity<>(object, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody ExpenseDto dto) {
        try {
            Expense expense = new Expense(dto);

            this.repository.save(expense);

            return new ResponseEntity<>("Expense saved!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unnable to save expense", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}