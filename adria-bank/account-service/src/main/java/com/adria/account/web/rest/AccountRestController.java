package com.adria.account.web.rest;
import com.adria.account.domain.Account;import com.adria.account.service.AccountService;import org.springframework.web.bind.annotation.*;import java.util.*;import java.math.BigDecimal;
@RestController @RequestMapping("/api/accounts") public class AccountRestController {private final AccountService service;public AccountRestController(AccountService s){service=s;}
 @PostMapping public Account create(@RequestBody Account a){return service.create(a);} @GetMapping public List<Account> all(){return service.all();} @GetMapping("/{id}") public Account get(@PathVariable UUID id){return service.get(id);}
 @PutMapping("/{id}/balance") public Account balance(@PathVariable UUID id,@RequestParam BigDecimal value){return service.updateBalance(id,value);}
}
