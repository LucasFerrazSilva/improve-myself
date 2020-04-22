package br.com.ferraz.improvemyself.finantial.expensepermonth;

import java.math.BigDecimal;
import java.time.Month;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ferraz.improvemyself.finantial.expense.Expense;
import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public class ExpensePerMonth implements Comparable<ExpensePerMonth> {

    ExpenseCategory category;

    EnumMap<Month, BigDecimal> values = new EnumMap<>(Month.class);

    BigDecimal totalValue;


    public ExpensePerMonth(ExpenseCategory category, List<Expense> expenses) {
        this.category = category;

        initValues();

        expenses.forEach(this::addValue);
    }


    private void initValues() {
        Arrays.asList(Month.values()).forEach(month -> {
            values.put(month, BigDecimal.ZERO);
        });

        this.totalValue = BigDecimal.ZERO;
    }

    private void addValue(Expense expense) {
        Month month = expense.getExpenseDateMonth();

        BigDecimal value = values.get(month);

        value = value.add(expense.getAmount());

        values.put(month, value);

        this.totalValue = this.totalValue.add(expense.getAmount());
    }

    @Override
    public int compareTo(ExpensePerMonth arg0) {
        return this.getCategoryName().compareTo(arg0.getCategoryName());
    }

    @JsonIgnore()
    public String getCategoryName() {
        return (category != null ? category.getName() : "");
    }

}