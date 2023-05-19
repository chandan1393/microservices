package com.chandan.model.entity;

import com.chandan.model.AccountStatus;
import com.chandan.model.AccountType;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "banking_core_transaction")
public class BankAccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private BigDecimal availableBalance;

    private BigDecimal actualBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;


}
