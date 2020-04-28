package br.com.ferraz.improvemyself.finantial.parameter;

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
@Table(name = "TB_FINANTIAL_PARAMETERS")
@Data @FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor @NoArgsConstructor
public class FinantialParameter implements DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FINANTIAL_PARAMETER_ID")
    Integer id;

    @Column(name = "NAME")
    String name;

    @Column(name = "VALUE")
    BigDecimal value;


    @Override
    public void load(DefaultDto dto2) {
        FinantialParameterDto dto = (FinantialParameterDto) dto2;

        this.id = dto.getId();
        this.name = dto.getName();
        this.value = dto.getValue();
    }

}