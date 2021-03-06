package br.com.ferraz.improvemyself.finantial.expense.category;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.defaults.DefaultEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="TB_EXPENSE_CATEGORIES")
@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class ExpenseCategory implements DefaultEntity, Comparable<ExpenseCategory> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="EXPENSE_CATEGORY_ID")
    Integer id;

    @Column(name="NAME")
    String name;


    public void load(DefaultDto obj) {
        ExpenseCategoryDto dto = (ExpenseCategoryDto) obj;
        
        this.id = dto.getId();
        this.name = dto.getName();
    }

    @Override
    public int compareTo(ExpenseCategory arg0) {
        return this.name.compareTo(arg0.getName());
    }
    
}