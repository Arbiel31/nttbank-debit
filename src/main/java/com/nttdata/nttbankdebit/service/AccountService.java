package com.nttdata.nttbankdebit.service;

import com.nttdata.nttbankdebit.model.AccountModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
  Flux<AccountModel> findAll();

  Mono<AccountModel> create(AccountModel account);

  Mono<AccountModel> update(AccountModel account);

  Mono<Void> deleteByNumber(String number);

  Mono<AccountModel> findByNumber(String number);

  Flux<AccountModel> findByDebit(String debit);
}
