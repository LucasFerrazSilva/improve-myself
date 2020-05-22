package br.com.ferraz.improvemyself.finantial.expectedexpense;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum ExpectedExpensePeriod {

    MONTHLY {
        public BigDecimal calculatelValue(BigDecimal value) {
            return value;
        }
    },
    YEARLY {
        public BigDecimal calculatelValue(BigDecimal value) {
            return (value != null ? value.divide(new BigDecimal(12), 2, RoundingMode.HALF_UP) : null);
        }
    };

    public abstract BigDecimal calculatelValue(BigDecimal value);
    
}