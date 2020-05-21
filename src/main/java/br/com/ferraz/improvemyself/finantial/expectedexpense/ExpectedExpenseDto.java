package br.com.ferraz.improvemyself.finantial.expectedexpense;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.finantial.expectedexpense.formula.ExpectedExpenseFormulaDto;
import br.com.ferraz.improvemyself.finantial.expectedexpense.formula.element.ExpectedExpenseFormulaElementDto;
import br.com.ferraz.improvemyself.finantial.expectedexpense.formula.element.ExpectedExpenseFormulaElementType;
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
    List<ExpectedExpenseFormulaDto> formulas;
    ExpectedExpensePeriod period;
    

    public boolean hasFormulas() {
        return this.formulas != null && !this.formulas.isEmpty();
    }

    public BigDecimal getTotalValue() {
        if(ExpectedExpenseType.VALUE.equals(type)) {
            return totalValue;
        } else {
            return calculateFormulaTotalValue();
        }
    }

    private BigDecimal calculateFormulaTotalValue() {
        BigDecimal value = BigDecimal.ZERO;

        int formulaIndex = 0;

        for(ExpectedExpenseFormulaDto formulaDto: formulas) {
            BigDecimal formulaValue = calculateFormualTotalValue(formulaDto);

            String formulaOperation = (formulaIndex++ > 0 ? formulaDto.getOperation() : "+");

            value = makeOperation(value, formulaValue, formulaOperation);
        }

        return value;
    }

    private BigDecimal calculateFormualTotalValue(ExpectedExpenseFormulaDto formulaDto) {
        BigDecimal formulaValue = BigDecimal.ZERO;

        int elementIndex = 0;

        for(ExpectedExpenseFormulaElementDto elementDto: formulaDto.getElements()) {
            String elementOperation = (elementIndex++ > 0 ? elementDto.getOperation() : "+");

            if(ExpectedExpenseFormulaElementType.VALUE.equals(elementDto.getType())) {
                formulaValue = makeOperation(formulaValue, elementDto.getTotalValue(), elementOperation);
            } else {
                formulaValue = makeOperation(formulaValue, elementDto.getParameter().getValue(), elementOperation);
            }
        }

        return formulaValue;
    }

    private BigDecimal makeOperation(BigDecimal value1, BigDecimal value2, String operation) {
        switch(operation) {
            case "+": return value1.add(value2);
            case "-": return value1.subtract(value2);
            case "*": return value1.multiply(value2);
            case "/": return value1.divide(value2, 2, RoundingMode.HALF_UP);
            default: return value1;
        }
    }

}