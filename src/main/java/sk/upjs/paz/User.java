package sk.upjs.paz;

import java.time.LocalDate;

public record User(
        Long id,
        String name,
        String surname,
        Gender gender,
        LocalDate date
) {
    public enum Gender {
        UNKNOWN,
        MALE,
        FEMALE
    }

}
