package ru.rost.sample.controller.rest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import ru.rost.sample.demoonion.domain.SimpleClass;
import ru.rost.sample.rest.model.ModelsSimpleSampleModel;

import java.util.List;

@Mapper(uses = {MoneyMapper.class},
        unmappedTargetPolicy = ReportingPolicy.ERROR, nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SimpleClassMapper {

    ModelsSimpleSampleModel toDto(SimpleClass simpleClass);

    List<ModelsSimpleSampleModel> toDto(List<SimpleClass> all);
}
