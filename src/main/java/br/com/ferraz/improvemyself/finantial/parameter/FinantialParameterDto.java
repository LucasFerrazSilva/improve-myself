package br.com.ferraz.improvemyself.finantial.parameter;

import java.math.BigDecimal;

import br.com.ferraz.improvemyself.defaults.DefaultDto;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class FinantialParameterDto implements DefaultDto {

    Integer id;
    String name;
    BigDecimal value;

}