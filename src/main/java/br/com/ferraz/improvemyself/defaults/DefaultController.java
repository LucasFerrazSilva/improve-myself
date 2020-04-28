package br.com.ferraz.improvemyself.defaults;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public abstract class DefaultController<T extends DefaultEntity, I extends DefaultDto> {

    private DefaultService<T> service;


    public DefaultController(DefaultService<T> service) {
        this.service = service;        
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Integer id) {
        try {
            Object object = this.service.findById(id);

            return new ResponseEntity<>(object, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id) {
        try {
            this.service.delete(id);

            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        } catch (IllegalArgumentException | EmptyResultDataAccessException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody I dto) {
        try {
            this.service.save(dto);

            return new ResponseEntity<>("Saved!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unnable to save", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}