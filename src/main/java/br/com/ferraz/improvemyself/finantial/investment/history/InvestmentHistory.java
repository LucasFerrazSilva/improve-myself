package br.com.ferraz.improvemyself.finantial.investment.history;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.ferraz.improvemyself.defaults.DefaultEntity;
import br.com.ferraz.improvemyself.finantial.investment.Investment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "TB_INVESTMENT_HISTORY")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class InvestmentHistory implements DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="INVESTMENT_HISTORY_ID")
    Integer id;

    @ManyToOne
    @JoinColumn(name="INVESTMENT_ID")
    Investment investment;

    @Column(name="HISTORY_YEAR")
    Integer year;

    @Column(name="HISTORY_MONTH")
    Integer month;

    @Column(name="INITIAL_AMOUNT")
    BigDecimal initialAmount;

    @Column(name="FINAL_AMOUNT")
    BigDecimal finalAmount;

    @Column(name="MONTH_INCOME")
    BigDecimal monthIncome;

    @Column(name="AMOUNT_MOVED")
    BigDecimal amountMoved;
    
}