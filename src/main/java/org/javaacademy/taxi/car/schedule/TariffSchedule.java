package org.javaacademy.taxi.car.schedule;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TariffSchedule {
    BIRCH_GROVE_STREET("Березовая роща",10),
    CANDICLE_STREET("Кандикюля",4),
    BUILDER_STREET("Строитель",12);

    private String StreetName;
    private int distance;
}
