package br.com.ferraz.improvemyself.finantial.expectedexpense.formula;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.defaults.DefaultEntity;
import br.com.ferraz.improvemyself.finantial.expectedexpense.ExpectedExpense;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "TB_EXPECTED_EXPENSE_FORMULA")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class ExpectedExpenseFormula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EXPECTED_EXPENSE_FORMULA_ID")
    Integer id;

    @ManyToOne
    @JoinColumn(name="EXPECTED_EXPENSE_ID")
    @JsonIgnore
    ExpectedExpense expectedExpense;

    @Column(name = "EXPECTED_EXPENSE_FORMULA_OPERATION", columnDefinition = "ENUM('+', '-', '*', '/')")
    String operation;


    public ExpectedExpenseFormula(ExpectedExpenseFormulaDto dto, ExpectedExpense expectedExpense) {
        this.id = dto.getId();
        this.operation = dto.getOperation();
        this.expectedExpense = expectedExpense;
    }

}