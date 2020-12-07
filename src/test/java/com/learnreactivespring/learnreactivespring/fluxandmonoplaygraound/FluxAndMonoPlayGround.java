package com.learnreactivespring.learnreactivespring.fluxandmonoplaygraound;

import org.junit.Test;
import reactor.core.publisher.Flux;

public class FluxAndMonoPlayGround {

    @Test
    public void fluxTest() {
        Flux<String> stringFlux = Flux.just("Spring", "Spring Boot", "Reactive Spring")
                /*.concatWith(Flux.error(new RuntimeException("Exception Occurred")))*/
                .concatWith(Flux.just("After Error"))
                .log();
        stringFlux
                .subscribe(System.out::println
                        ,(e)->System.err.println("Exception is :" + e)//Error Handling (printing)
                        ,()->System.out.println("I Completed"));
    }

    @Test
    public void fluxTestElements_withoutError() {
        
    }
}
