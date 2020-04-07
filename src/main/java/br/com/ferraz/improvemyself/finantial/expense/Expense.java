package br.com.ferraz.improvemyself.finantial.expense;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
    

    public Expense(ExpenseDto dto) {
        this.id = dto.getId();
        this.name = dto.getName();
        this.amount = dto.getAmount();
    }

    
}