package ru.rost.sample.controller.rest.mappers;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import ru.rost.sample.rest.model.TypeMoney;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoneyMapperTest {
    MoneyMapper moneyMapper = new MoneyMapper();

    @org.junit.jupiter.api.Test
    void mapToDto() {
        var money = new TypeMoney()
                .nanos(10)
                .currencyCode("USD")
                .units("100");
        var received = moneyMapper.toDomain(money);
        assertEquals(CurrencyUnit.USD, received.getCurrencyUnit());
        assertEquals(new BigDecimal("100.10"), received.getAmount());
    }

    @org.junit.jupiter.api.Test
    void mapToRest() {
        var money = Money.of(
                CurrencyUnit.USD,
                new BigDecimal("100.10")
        );
        var received = moneyMapper.toRest(money);
        assertEquals(CurrencyUnit.USD.getCode(), received.getCurrencyCode());
        assertEquals("100", received.getUnits());
        assertEquals(10, received.getNanos());
    }

    @org.junit.jupiter.api.Test
    void mapToRestNull() {
        assertThrows(AssertionError.class, () -> moneyMapper.toDomain(new TypeMoney()));
        ;
    }

}