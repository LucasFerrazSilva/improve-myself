package br.com.ferraz.improvemyself.finantial.expectedexpense;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.defaults.DefaultEntity;
import br.com.ferraz.improvemyself.finantial.expectedexpense.formula.ExpectedExpenseFormula;
import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "TB_EXPECTED_EXPENSES")
@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class ExpectedExpense implements DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EXPECTED_EXPENSE_ID")
    Integer id;

    @OneToOne
    @JoinColumn(name = "EXPENSE_CATEGORY_ID")
    ExpenseCategory category;

    @Enumerated(EnumType.STRING)
    @Column(name = "EXPECTED_EXPENSE_TYPE", columnDefinition = "ENUM('VALUE', 'FORMULA')")
    ExpectedExpenseType type;

    @Column(name = "TOTAL_VALUE")
    BigDecimal totalValue;

    @Enumerated(EnumType.STRING)
    @Column(name = "PERIOD", columnDefinition = "ENUM('MONTHLY', 'YEARLY')")
    ExpectedExpensePeriod period;

    @OneToMany(mappedBy = "expectedExpense", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ExpectedExpenseFormula> formulas;


    @Override
    public void load(DefaultDto dto2) {
        ExpectedExpenseDto dto = (ExpectedExpenseDto) dto2;

        this.id = dto.getId();
        this.category = dto.getCategory();
        this.type = dto.getType();
        this.totalValue = dto.getTotalValue();
        this.period = dto.getPeriod();

        this.formulas = new ArrayList<>();

        if(dto.hasFormulas()) {
            this.formulas = dto.getFormulas().stream().map(formulaDto -> new ExpectedExpenseFormula(formulaDto, this)).collect(Collectors.toList());
        }
    }


    public BigDecimal getMonthTotalValue() {
        return (this.period != null ? this.period.calculatelValue(this.totalValue) : null);
    }

}