package com.nttdata.nttbankdebit.repository;

import com.nttdata.nttbankdebit.model.MovementModel;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface MovementRepository extends ReactiveMongoRepository<MovementModel, String> {
  @Query("{debit: ?0}, limit = 10")
  Flux<MovementModel> findByDebit(String debit);
}
