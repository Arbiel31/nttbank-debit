package com.nttdata.nttbankdebit.service;

import com.nttdata.nttbankdebit.model.DebitModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DebitService {
        Flux<DebitModel> findAll();

        Mono<DebitModel> create(DebitModel debit);

        Mono<DebitModel> update(DebitModel debit);

        Mono<Void> deleteByNumber(String number);

        Mono<DebitModel> findByNumber(String number);

        Mono<Float> getFundsByNumber(String number);
}
