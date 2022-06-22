package com.nttdata.nttbankdebit.repository;

import com.nttdata.nttbankdebit.model.AccountModel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository extends ReactiveMongoRepository<AccountModel, String> {
  Mono<Void> deleteByNumber(String number);

  @Query("{number: ?0}")
  Mono<AccountModel> findByNumber(String number);

  @Query("{debit: ?0}")
  Flux<AccountModel> findByDebit(String debit);
}
