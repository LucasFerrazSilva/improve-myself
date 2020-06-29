package br.com.ferraz.improvemyself.finantial.investment;

import java.math.BigDecimal;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class InvestmentDto implements DefaultDto {
    
    Integer id;
    String name;
    BigDecimal amount;
    BigDecimal expectedIncome;
    BigDecimal monthlyInvestment;

}