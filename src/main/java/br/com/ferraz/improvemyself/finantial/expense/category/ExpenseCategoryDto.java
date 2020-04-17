package br.com.ferraz.improvemyself.finantial.expense.category;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseCategoryDto {

    Integer id;
    String name;

}