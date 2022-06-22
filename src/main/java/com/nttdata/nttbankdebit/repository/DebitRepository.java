package com.nttdata.nttbankdebit.repository;

import com.nttdata.nttbankdebit.model.DebitModel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface DebitRepository extends ReactiveMongoRepository<DebitModel, String> {
  Mono<Void> deleteByNumber(String number);

  @Query("{number: ?0}")
  Mono<DebitModel> findByNumber(String number);
}
