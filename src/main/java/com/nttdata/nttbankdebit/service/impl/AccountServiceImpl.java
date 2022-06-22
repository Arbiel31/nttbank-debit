package com.nttdata.nttbankdebit.service.impl;

import com.nttdata.nttbankdebit.model.AccountModel;
import com.nttdata.nttbankdebit.repository.AccountRepository;
import com.nttdata.nttbankdebit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AccountServiceImpl implements AccountService {
  @Autowired
  AccountRepository accountRepository;

  @Override
  public Flux<AccountModel> findAll() {
    return accountRepository.findAll();
  }

  @Override
  public Mono<AccountModel> create(AccountModel account) {
    return accountRepository.save(account);
  }

  @Override
  public Mono<AccountModel> update(AccountModel account) {
    return accountRepository.save(account);
  }

  @Override
  public Mono<Void> deleteByNumber(String number) {
    return accountRepository.deleteByNumber(number);
  }

  @Override
  public Mono<AccountModel> findByNumber(String number) {
    return accountRepository.findByNumber(number);
  }

  @Override
  public Flux<AccountModel> findByDebit(String debit) {
    return accountRepository.findByDebit(debit);
  }
}
