package br.com.ferraz.improvemyself.finantial.investment.history;

import java.math.BigDecimal;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import br.com.ferraz.improvemyself.finantial.investment.Investment;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class InvestmentHistoryDto implements DefaultDto {

    Integer id;
    Investment investment;
    Integer year;
    Integer month;
    BigDecimal initialAmount;
    BigDecimal finalAmount;
    BigDecimal monthIncome;
    BigDecimal amountMoved;
    
}