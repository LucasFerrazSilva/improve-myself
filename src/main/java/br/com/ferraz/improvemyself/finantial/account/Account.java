package br.com.ferraz.improvemyself.finantial.account;

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
@Table(name = "TB_ACCOUNTS")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Account implements DefaultEntity, Comparable<Account> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    Integer id;

    @Column(name = "NAME")
    String name;

    @Column(name = "BALANCE")
    BigDecimal balance;


    @Override
    public void load(DefaultDto dto2) {
        AccountDto dto = (AccountDto) dto2;

        this.id = dto.getId();
        this.name = dto.getName();
        this.balance = dto.getBalance();
    }
    

    @Override
    public int compareTo(Account arg0) {
        return this.name.compareTo(arg0.getName());
    }
    
}