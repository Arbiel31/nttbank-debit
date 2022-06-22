package com.nttdata.nttbankdebit.api;

import com.nttdata.nttbankdebit.model.AccountModel;
import com.nttdata.nttbankdebit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "account")
public class AccountApi {
  @Autowired
  private AccountService accountService;

  @GetMapping
  public Flux<AccountModel> findAll() {
    return accountService.findAll();
  }

  @PostMapping
  public Mono<AccountModel> create(@RequestBody AccountModel account) {
    return accountService.create(account);
  }

  @PutMapping
  public Mono<AccountModel> update(@RequestBody AccountModel account) {
    return accountService.update(account);
  }

  @DeleteMapping("/{number}")
  public Mono<Void> delete(@PathVariable("number") String number) {
    return accountService.deleteByNumber(number);
  }

  @GetMapping("/{number}")
  public Mono<AccountModel> findByNumber(@PathVariable("number") String number) {
    return accountService.findByNumber(number);
  }

  @GetMapping("/{debit}")
  public Flux<AccountModel> findByDebit(@PathVariable("debit") String debit) {
    return accountService.findByDebit(debit);
  }
}
