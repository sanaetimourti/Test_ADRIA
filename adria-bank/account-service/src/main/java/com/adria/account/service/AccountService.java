package com.adria.account.service;
import com.adria.account.domain.*;import com.adria.account.repository.AccountRepository;import org.springframework.stereotype.Service;import org.springframework.transaction.annotation.Transactional;import java.math.BigDecimal;import java.util.*;
@Service public class AccountService { private final AccountRepository repo; public AccountService(AccountRepository repo){this.repo=repo;}
 public Account create(Account a){if(a.getBalance()==null||a.getBalance().signum()<0)throw new IllegalArgumentException("Solde initial invalide");if(a.getCurrency()==null||a.getCurrency().length()!=3)throw new IllegalArgumentException("Devise invalide");return repo.save(a);}
 public List<Account> all(){return repo.findAll();} public Account get(UUID id){return repo.findById(id).orElseThrow(()->new NoSuchElementException("Compte introuvable: "+id));}
 @Transactional public Account updateBalance(UUID id, BigDecimal balance){if(balance==null||balance.signum()<0)throw new IllegalArgumentException("Solde invalide");Account a=get(id);a.setBalance(balance);return repo.save(a);}
}
