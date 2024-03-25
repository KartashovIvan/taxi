package org.javaacademy.taxi.company;

import org.javaacademy.taxi.car.CarTaxi;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("bluz")
public class BluzTaxiCompany extends TaxiCompany {
    public BluzTaxiCompany(List<CarTaxi> carTaxis) {
        super(carTaxis);
    }
}
