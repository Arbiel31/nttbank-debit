package com.nttdata.nttbankdebit.api;

import com.nttdata.nttbankdebit.model.DebitModel;
import com.nttdata.nttbankdebit.service.DebitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "debit")
public class DebitApi {
  @Autowired
  private DebitService debitService;

  @GetMapping
  public Flux<DebitModel> findAll() {
    return debitService.findAll();
  }

  @PostMapping
  public Mono<DebitModel> create(@RequestBody DebitModel debit) {
    return debitService.create(debit);
  }

  @PutMapping
  public Mono<DebitModel> update(@RequestBody DebitModel debit) {
    return debitService.update(debit);
  }

  @DeleteMapping("/{number}")
  public Mono<Void> delete(@PathVariable("number") String number) {
    return debitService.deleteByNumber(number);
  }

  @GetMapping("/{number}")
  public Mono<DebitModel> findByNumber(@PathVariable("number") String number) {
    return debitService.findByNumber(number);
  }

  @GetMapping("/funds/{number}")
  public Mono<Float> getFundsByNumber(@PathVariable("number") String number) {
    return debitService.getFundsByNumber(number);
  }
}
