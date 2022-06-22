package com.nttdata.nttbankdebit.service;

import com.nttdata.nttbankdebit.model.MovementModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {
  Flux<MovementModel> findAll();

  Mono<MovementModel> create(MovementModel movement);

  Mono<MovementModel> update(MovementModel movement);

  Mono<Void> deleteById(String id);

  Mono<MovementModel> findById(String id);

  Flux<MovementModel> findByDebit(String debit);
}
