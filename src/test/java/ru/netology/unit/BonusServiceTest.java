package ru.netology.unit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;


import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test

    void calculateBonus() {
        // подготовка
        BonusService service = new BonusService();
        int amount = 2001;

        // выполнение целевого действия
        int actual = service.calculateBonus(amount);
        int expected = 10;

        // сравнение ожидаемого и фактического
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturn10IfAmountIs2000() {
        BonusService service = new BonusService();
        int amount = 2000;

        int actual = service.calculateBonus(amount);
        int expected = 10;

        assertEquals(expected, actual);

    }

    @Test
    @DisplayName("Should return 10 if amount is 2000")
    void shouldReturnZeroIfAmountLowerThan1000() {
        BonusService service = new BonusService();
        int amount = 1100;

        int actual = service.calculateBonus(amount);
        int expected = 0;

        assertEquals(expected, actual);
    }



    @ParameterizedTest // Вместо Test
    @CsvFileSource(resources = "/BonusData.csv", numLinesToSkip = 1)
    void ShouldCalculateBonus(int amount, int expected, String message) {
        BonusService service =new BonusService();

        int actual = service.calculateBonus(amount);

        assertEquals(expected, actual, message);
    }

}