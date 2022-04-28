package ru.rost.sample.demoonion.domain;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.joda.money.Money;

import java.time.OffsetDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SimpleClass {
    long id;
    Money money;
    String name;
    OffsetDateTime dateTime;
}
