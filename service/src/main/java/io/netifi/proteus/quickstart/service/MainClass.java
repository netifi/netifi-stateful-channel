package io.netifi.proteus.quickstart.service;

import reactor.core.publisher.EmitterProcessor;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class MainClass {
  public static void main(String... args) {
   EmitterProcessor<Flux<String>> processor = EmitterProcessor.create(false);
   
    processor
      .flatMap(Function.identity())
      .doOnNext(System.out::println)
      .subscribe();
    
    Flux<String> map = Flux.range(1, 10).map(i -> "one -> " + i);
    Flux<String> map1 = Flux.range(1, 15).map(i -> "two -> " + i);
    
    processor.onNext(map);
    processor.onNext(map1);
  }
}
