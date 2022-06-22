package com.nttdata.nttbankdebit.api;

import com.nttdata.nttbankdebit.model.MovementModel;
import com.nttdata.nttbankdebit.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "movement")
public class MovementApi {
  @Autowired
  private MovementService movementService;

  @GetMapping
  public Flux<MovementModel> findAll() {
    return movementService.findAll();
  }

  @PostMapping
  public Mono<MovementModel> create(@RequestBody MovementModel movement) {
    return movementService.create(movement);
  }

  @PutMapping
  public Mono<MovementModel> update(@RequestBody MovementModel movement) {
    return movementService.update(movement);
  }

  @DeleteMapping("/{id}")
  public Mono<Void> delete(@PathVariable("id") String id) {
    return movementService.deleteById(id);
  }

  @GetMapping("/{id}")
  public Mono<MovementModel> findById(@PathVariable("id") String id) {
    return movementService.findById(id);
  }

  @GetMapping("/debit/{debit}")
  public Flux<MovementModel> findByDebit(@PathVariable("debit") String debit) {
    return movementService.findByDebit(debit);
  }
}
