package sk.upjs.paz;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @org.junit.jupiter.api.Test
    void computrGenderRatio_happyPath() {

        var userService = new UserService(List.of(
                new User(1L,
                        "User1",
                        "Surname1",
                        User.Gender.MALE,
                        LocalDate.ofYearDay(2008, 29)
                ),
                new User(2L,
                        "User2",
                        "Surname2",
                        User.Gender.FEMALE,
                        LocalDate.ofYearDay(2002, 15)
                ),
                new User(3L,
                        "User3",
                        "Surname3",
                        User.Gender.UNKNOWN,
                        LocalDate.ofYearDay(2003, 20)
                )
        ));

        var got = userService.computrGenderRatio();
        assertEquals(0.3333333333333333, got.boys());
        assertEquals(0.3333333333333333, got.girls());
        assertEquals(0.3333333333333333, got.unknown());
    }

    @org.junit.jupiter.api.Test
    void computrGenderRatio_empty() {

        var userService = new UserService(Collections.emptyList());

        var got = userService.computrGenderRatio();
        assertEquals(0.0, got.boys());
        assertEquals(0.0, got.girls());
        assertEquals(0.0, got.unknown());
    }

    @org.junit.jupiter.api.Test
    void computrGenderRatio_null() {

        var userService = new UserService(Collections.emptyList());

        var got = userService.computrGenderRatio();
        assertEquals(0.0, got.boys());
        assertEquals(0.0, got.girls());
        assertEquals(0.0, got.unknown());
    }
}