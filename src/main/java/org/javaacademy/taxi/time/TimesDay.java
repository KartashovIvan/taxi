package org.javaacademy.taxi.time;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TimesDay {
    DAY("День"), NIGHT("Ночь");
    private final String time;
}
