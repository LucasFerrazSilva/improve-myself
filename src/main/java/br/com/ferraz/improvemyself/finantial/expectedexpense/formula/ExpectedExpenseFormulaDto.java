package br.com.ferraz.improvemyself.finantial.expectedexpense.formula;

import java.util.List;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.finantial.expectedexpense.formula.element.ExpectedExpenseFormulaElementDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class ExpectedExpenseFormulaDto implements DefaultDto {

    Integer id;
    String operation;
    List<ExpectedExpenseFormulaElementDto> elements;

    public boolean hasElements() {
        return this.elements != null && !this.elements.isEmpty();
    }

}