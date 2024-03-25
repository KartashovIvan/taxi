package org.javaacademy;

import org.javaacademy.taxi.car.CarTaxi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class TaxiConfig {
    @Bean
    @Profile(value = {"luna", "bluz"})
    public CarTaxi carsOne() {
        return new CarTaxi("a111bc69");
    }

    @Bean
    @Profile(value = {"luna", "bluz"})
    public CarTaxi carsTwo() {
        return new CarTaxi("a222bc69");
    }

    @Bean
    @Profile("luna")
    public CarTaxi carsThree() {
        return new CarTaxi("a333bc69");
    }
}
