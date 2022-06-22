package com.nttdata.nttbankdebit.service.impl;

import com.nttdata.nttbankdebit.model.AccountModel;
import com.nttdata.nttbankdebit.model.DebitModel;
import com.nttdata.nttbankdebit.repository.AccountRepository;
import com.nttdata.nttbankdebit.repository.DebitRepository;
import com.nttdata.nttbankdebit.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DebitServiceImpl implements DebitService {
  @Autowired
  DebitRepository debitRepository;

  @Autowired
  AccountRepository accountRepository;

  @Override
  public Flux<DebitModel> findAll() {
    return debitRepository.findAll();
  }

  @Override
  public Mono<DebitModel> create(DebitModel debit) {
    return debitRepository.save(debit);
  }

  @Override
  public Mono<DebitModel> update(DebitModel debit) {
    return debitRepository.save(debit);
  }

  @Override
  public Mono<Void> deleteByNumber(String number) {
    return debitRepository.deleteByNumber(number);
  }

  @Override
  public Mono<DebitModel> findByNumber(String number) {
    return debitRepository.findByNumber(number);
  }

  @Override
  public Mono<Float> getFundsByNumber(String number) {
    return debitRepository.findByNumber(number)
            .map(deb->(accountRepository.findByNumber(deb.getMainAccount())))
            .cast(AccountModel.class)
            .map(acc->(acc.getFunds()));
  }
}
