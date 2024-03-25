package org.javaacademy.taxi.car;

import lombok.Getter;
import lombok.ToString;
import org.javaacademy.taxi.client.Client;
import org.javaacademy.taxi.time.TimesDay;
import org.javaacademy.exeption.NoStreetException;
import org.javaacademy.taxi.car.schedule.TariffSchedule;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Arrays;

@ToString
@Getter
public class CarTaxi {
    private final String carNumber;
    private BigDecimal profit = new BigDecimal(0);
    @Value("${rate.night}")
    private BigDecimal nightRate;
    @Value("${rate.day}")
    private BigDecimal dayRate;

    public CarTaxi(String carNumber) {
        this.carNumber = carNumber;
    }

    public BigDecimal takeOrder(Client client, TimesDay timesDay) throws NoStreetException {
        TariffSchedule street = findStreet(client.getAddress());
        int distance = street.getDistance();
        BigDecimal tripProfit = countProfit(timesDay, distance);
        profit = profit.add(tripProfit);
        return tripProfit;

    }

    private TariffSchedule findStreet(String nameStreet) throws NoStreetException {
        return Arrays.stream(TariffSchedule.values())
                .filter(tariffSchedule -> tariffSchedule.getStreetName().equals(nameStreet))
                .findFirst()
                .orElseThrow(() -> new NoStreetException("No such street"));
    }

    private BigDecimal countProfit(TimesDay timesDay, int distance) {
        if (timesDay.equals(TimesDay.DAY)) {
            return calculateCost(dayRate, distance);
        }
        return calculateCost(nightRate, distance);
    }

    private BigDecimal calculateCost(BigDecimal rate, int distance) {
        return rate.multiply(new BigDecimal(distance)).divide(new BigDecimal(2));
    }
}
