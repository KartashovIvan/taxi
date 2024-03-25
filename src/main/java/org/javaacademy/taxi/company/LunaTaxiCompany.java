package org.javaacademy.taxi.company;

import org.javaacademy.taxi.car.CarTaxi;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("luna")
public class LunaTaxiCompany extends TaxiCompany {
    public LunaTaxiCompany(List<CarTaxi> carTaxis) {
        super(carTaxis);
    }
}
