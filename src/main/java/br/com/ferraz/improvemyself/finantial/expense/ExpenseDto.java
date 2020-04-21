package br.com.ferraz.improvemyself.finantial.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;
import br.com.ferraz.improvemyself.util.LocalDateDeserializer;
import br.com.ferraz.improvemyself.util.LocalDateSerializer;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseDto implements DefaultDto {

    Integer id;

    String name;

    BigDecimal amount;
    
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    LocalDate expenseDate;

    ExpenseCategory category;

}