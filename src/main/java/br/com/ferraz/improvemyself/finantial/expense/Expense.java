package br.com.ferraz.improvemyself.finantial.expense;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="TB_EXPENSES", schema = "IMPROVE_MYSELF")
@Data @FieldDefaults(level = AccessLevel.PRIVATE)
public class Expense {

    @Id
    @Column(name="EXPENSE_ID")
    Integer id;

    @Column(name="NAME")
    String name;

    @Column(name="AMOUNT")
    Float amount;

    
}