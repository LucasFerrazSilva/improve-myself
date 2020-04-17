package br.com.ferraz.improvemyself.finantial.expense.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expense-category")
public class ExpenseCategoryController {

    @Autowired
    private ExpenseCategoryRepository repository;

    
    @GetMapping("/")
    public Page<ExpenseCategory> list(@RequestParam("name") String name, Pageable pageable) {
        return this.repository.findByFilters(name, pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        try {
            ExpenseCategory category = this.repository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid id"));

            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody ExpenseCategoryDto dto) {
        try {
            ExpenseCategory category = new ExpenseCategory(dto);
    
            this.repository.save(category);
    
            return new ResponseEntity<>("Categoria salva!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao salvar categoria", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        try {
            if(this.repository.existsById(id)) {
                this.repository.deleteById(id);
    
                return new ResponseEntity<>("Deletado", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Id inválido", HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}