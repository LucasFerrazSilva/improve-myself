package br.com.ferraz.improvemyself.finantial.expectedexpense.formula.element;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ferraz.improvemyself.finantial.expectedexpense.formula.ExpectedExpenseFormula;
import br.com.ferraz.improvemyself.finantial.parameter.FinantialParameter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "TB_EXPECTED_EXPENSE_FORMULA_ELEMENT")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ExpectedExpenseFormulaElement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EXPECTED_EXPENSE_FORMULA_ELEMENT_ID")
    Integer id;

    @ManyToOne
    @JoinColumn(name="EXPECTED_EXPENSE_FORMULA_ID")
    @JsonIgnore
    ExpectedExpenseFormula formula;

    @Column(name="EXPECTED_EXPENSE_FORMULA_ELEMENT_OPERATION", columnDefinition="ENUM('+', '-', '*', '/')")
    String operation;

    @Enumerated(EnumType.STRING)
    @Column(name="EXPECTED_EXPENSE_FORMULA_ELEMENT_TYPE", columnDefinition = "ENUM('VALUE', 'PARAMETER')")
    ExpectedExpenseFormulaElementType type;

    @Column(name="TOTAL_VALUE")
    BigDecimal totalValue;

    @ManyToOne
    @JoinColumn(name="FINANTIAL_PARAMETER_ID")
    FinantialParameter parameter;

    public ExpectedExpenseFormulaElement(ExpectedExpenseFormulaElementDto dto, ExpectedExpenseFormula formula) {
        this.id = dto.getId();
        this.operation = dto.getOperation();
        this.type = dto.getType();
        this.totalValue = dto.getTotalValue();
        this.parameter = dto.getParameter();

        this.formula = formula;
    }
    
}