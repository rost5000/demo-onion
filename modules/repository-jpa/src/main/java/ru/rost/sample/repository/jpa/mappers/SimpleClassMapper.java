package ru.rost.sample.repository.jpa.mappers;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import ru.rost.sample.demoonion.domain.SimpleClass;
import ru.rost.sample.repository.jpa.entities.SimpleClassEntity;

import java.util.List;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.ERROR)
public abstract class SimpleClassMapper {

    @Mapping(target = "money", expression = "java(this.toMoney(simpleClassEntity))")
    public abstract SimpleClass toDomain(SimpleClassEntity simpleClassEntity);

    @InheritInverseConfiguration
    @Mapping(target = "currency", source = "money.currencyUnit.code")
    @Mapping(target = "amount", source = "money.amount")
    public abstract SimpleClassEntity toJpa(SimpleClass simpleClass);

    public abstract List<SimpleClass> toDomain(Iterable<SimpleClassEntity> all);


    protected Money toMoney(SimpleClassEntity simpleClassEntity) {
        return Money.of(
                CurrencyUnit.of(simpleClassEntity.getCurrency()),
                simpleClassEntity.getAmount()
        );
    }
}
