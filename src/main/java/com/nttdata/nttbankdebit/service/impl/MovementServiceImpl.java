package com.nttdata.nttbankdebit.service.impl;

import com.nttdata.nttbankdebit.model.AccountModel;
import com.nttdata.nttbankdebit.model.DebitModel;
import com.nttdata.nttbankdebit.model.MovementModel;
import com.nttdata.nttbankdebit.repository.AccountRepository;
import com.nttdata.nttbankdebit.repository.DebitRepository;
import com.nttdata.nttbankdebit.repository.MovementRepository;
import com.nttdata.nttbankdebit.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {
  @Autowired
  MovementRepository movementRepository;

  @Autowired
  AccountRepository accountRepository;

  @Override
  public Flux<MovementModel> findAll() {
    return movementRepository.findAll();
  }

  @Override
  public Mono<MovementModel> create(MovementModel movement) {
    Flux<AccountModel> accounts=accountRepository.findByDebit(movement.getDebit());

    Mono<Float> totalFund=accounts
            .filter(account->(account.getFunds()>0))
            .sort()
            .reduce(0.0F, (accumulator, account)-> accumulator + account.getFunds())
            .filter(total->(total>movement.getAmount()))
            .switchIfEmpty(Mono.error(new RuntimeException("error")));

    return movementRepository.save(movement);
  }

  @Override
  public Mono<MovementModel> update(MovementModel movement) {
    return movementRepository.save(movement);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return movementRepository.deleteById(id);
  }

  @Override
  public Mono<MovementModel> findById(String id) {
    return movementRepository.findById(id);
  }

  @Override
  public Flux<MovementModel> findByDebit(String debit) {
    return movementRepository.findByDebit(debit);
  }
}
