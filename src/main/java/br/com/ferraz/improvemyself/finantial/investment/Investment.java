package br.com.ferraz.improvemyself.finantial.investment;

import java.math.BigDecimal;

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
@Table(name = "TB_INVESTMENTS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Investment implements DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVESTMENT_ID")
    Integer id;

    @Column(name="NAME")
    String name;

    @Column(name="AMOUNT")
    BigDecimal amount;

    @Override
    public void load(DefaultDto dto2) {
        InvestmentDto dto = (InvestmentDto) dto2;

        this.id = dto.getId();
        this.name = dto.getName();
        this.amount = dto.getAmount();
    }
    
}