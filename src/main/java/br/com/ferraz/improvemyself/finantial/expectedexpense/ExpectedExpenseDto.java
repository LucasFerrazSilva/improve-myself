package br.com.ferraz.improvemyself.finantial.expectedexpense;

import java.math.BigDecimal;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class ExpectedExpenseDto implements DefaultDto {

    Integer id;
    ExpenseCategory category;
    ExpectedExpenseType type;
    BigDecimal totalValue;

}