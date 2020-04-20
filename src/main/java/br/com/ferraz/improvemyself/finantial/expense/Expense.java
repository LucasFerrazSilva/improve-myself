package br.com.ferraz.improvemyself.finantial.expense;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.ferraz.improvemyself.finantial.expense.category.ExpenseCategory;
import br.com.ferraz.improvemyself.util.LocalDateDeserializer;
import br.com.ferraz.improvemyself.util.LocalDateSerializer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="TB_EXPENSES", schema = "IMPROVE_MYSELF")
@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EXPENSE_ID")
    Integer id;

    @Column(name="NAME")
    String name;

    @Column(name="AMOUNT")
    BigDecimal amount;
    
    @Column(name="EXPENSE_DATE")
    @JsonDeserialize(using = LocalDateDeserializer.class)  
    @JsonSerialize(using = LocalDateSerializer.class)  
    LocalDate expenseDate;

    @ManyToOne
    @JoinColumn(name="EXPENSE_CATEGORY_ID")
    ExpenseCategory category;


    public Expense(ExpenseDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.amount = dto.getAmount();
        this.expenseDate = dto.getExpenseDate();
        this.category = dto.getCategory();
    }

    
}