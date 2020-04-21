package br.com.ferraz.improvemyself.finantial.expense.category;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseCategoryDto implements DefaultDto {

    Integer id;
    
    String name;

}