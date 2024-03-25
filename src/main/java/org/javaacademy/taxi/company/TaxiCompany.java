package org.javaacademy.taxi.company;

import jakarta.annotation.PreDestroy;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.javaacademy.taxi.client.Client;
import org.javaacademy.taxi.time.TimesDay;
import org.javaacademy.exeption.NoStreetException;
import org.javaacademy.taxi.car.CarTaxi;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Slf4j
@ToString
public abstract class TaxiCompany {
    @Value("${name}")
    private String nameCompany;
    private BigDecimal profitCompany = new BigDecimal(0);
    private final List<CarTaxi> carTaxis;

    public TaxiCompany(List<CarTaxi> carTaxis) {
        this.carTaxis = carTaxis;
    }

    public void takeOrder(Client client, TimesDay timesDay) {
        CarTaxi car = carTaxis.remove(0);
        try {
            BigDecimal profit = car.takeOrder(client, timesDay);
            profitCompany = profitCompany.add(profit);
        } catch (NoStreetException e) {
            log.error(e.getMessage());
        }
        carTaxis.add(car);
    }

    @PreDestroy
    public void result() {
        System.out.printf("""
                %s
                Заработано: %s
                 """, nameCompany, profitCompany);
        carTaxis.forEach(car -> System.out.printf("Водитель машины %s заработал: %s\n", car.getCarNumber(), car.getProfit()));
    }
}
