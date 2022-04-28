package ru.rost.sample.controller.rest.mappers;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class MoneyMapper {

    public Money toDomain(ru.rost.sample.rest.model.TypeMoney typeMoney) {
        assert typeMoney.getCurrencyCode() != null : "Currency code is null";
        assert typeMoney.getUnits() != null : "Units is null";
        var coins = Objects.requireNonNullElse(typeMoney.getNanos(), 0);
        var coinsBigDecimal = new BigDecimal(coins);
        return Money.of(
                CurrencyUnit.of(typeMoney.getCurrencyCode()),
                new BigDecimal(typeMoney.getUnits()).add(
                        coinsBigDecimal.scaleByPowerOfTen(-1 * coinsBigDecimal.precision())
                )
        );

    }

    public ru.rost.sample.rest.model.TypeMoney toRest(Money money) {
        BigDecimal units = money.getAmount().setScale(0, RoundingMode.DOWN);
        BigDecimal coins = money.getAmount().subtract(units);
        coins = coins.scaleByPowerOfTen(coins.scale());
        return new ru.rost.sample.rest.model.TypeMoney()
                .currencyCode(money.getCurrencyUnit().getCode())
                .units((units).toString())
                .nanos(coins.intValue());
    }
}
