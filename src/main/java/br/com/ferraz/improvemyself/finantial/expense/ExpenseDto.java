package br.com.ferraz.improvemyself.finantial.expense;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpenseDto {

    Integer id;
    String name;
    BigDecimal amount;

}