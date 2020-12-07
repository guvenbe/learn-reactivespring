package com.learnreactivespring.learnreactivespring.fluxandmonoplaygraound;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class FluxAndMonoFactoryTest {
    List<String> names = Arrays.asList("adam", "anna", "jack", "jenny");

    @Test
    public void flusUsingIterable() {
        Flux<String> namesFlux = Flux.fromIterable(names).log();
        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();
    }

    @Test
    public void fluxUsingArray() {
        String[] names = new String[]{"adam", "anna", "jack", "jenny"};
        Flux<String> namesFlux = Flux.fromArray(names).log();

        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();
    }

    @Test
    public void fluxUsingStreamTest() {
        Flux<String> namesFlux = Flux.fromStream(names.stream());
        StepVerifier.create(namesFlux)
                .expectNext("adam", "anna", "jack", "jenny")
                .verifyComplete();

    }

    @Test
    public void monoUsingJustOreEmpty() {
        Mono<String> mono = Mono.justOrEmpty(null);
        StepVerifier.create(mono.log())
                .verifyComplete();
    }

    @Test
    public void monoUsingSupplierTest() {
        Supplier<String> stringSupplier = () -> "adam";
        Mono<String> stringMono = Mono.fromSupplier(stringSupplier);
        System.out.println(stringSupplier.get());
        StepVerifier.create(stringMono.log())
                .expectNext("adam")
                .verifyComplete();

    }

    @Test
    public void fluxUsingRangeTest() {
        Flux<Integer> integerFlux = Flux.range(1, 5).log();

        StepVerifier.create(integerFlux)
                .expectNext(1,2,3,4,5)
                .verifyComplete();
    }
}
