package ru.rost.sample.repository.jpa.entities;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "simple_class")
public class SimpleClassEntity {
    @Id
    long id;
    BigDecimal amount;
    String currency;
    String name;
    @Column(name = "date_time")
    OffsetDateTime dateTime;
}
