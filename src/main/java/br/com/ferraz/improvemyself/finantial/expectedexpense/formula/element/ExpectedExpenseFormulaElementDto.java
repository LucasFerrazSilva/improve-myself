package br.com.ferraz.improvemyself.finantial.expectedexpense.formula.element;

import java.math.BigDecimal;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.finantial.parameter.FinantialParameter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class ExpectedExpenseFormulaElementDto implements DefaultDto {

    Integer id;
    ExpectedExpenseFormulaElementType type;
    String operation;
    BigDecimal totalValue;
    FinantialParameter parameter;
    
}