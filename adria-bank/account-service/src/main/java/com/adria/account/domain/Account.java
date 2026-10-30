package com.adria.account.domain;
import jakarta.persistence.*;import java.util.UUID;
@Entity @Table(name="accounts") public class Account {
 @Id @GeneratedValue(strategy=GenerationType.UUID) private UUID id;
 @Column(nullable=false) private String customerReference;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private AccountStatus status=AccountStatus.ACTIVE;
 @Column(nullable=false,length=3) private String currency;
 @Column(nullable=false) private java.math.BigDecimal balance=java.math.BigDecimal.ZERO;
 public Account(){} public UUID getId(){return id;} public String getCustomerReference(){return customerReference;} public void setCustomerReference(String v){customerReference=v;} public AccountStatus getStatus(){return status;} public void setStatus(AccountStatus v){status=v;} public String getCurrency(){return currency;} public void setCurrency(String v){currency=v;} public java.math.BigDecimal getBalance(){return balance;} public void setBalance(java.math.BigDecimal v){balance=v;}
}
