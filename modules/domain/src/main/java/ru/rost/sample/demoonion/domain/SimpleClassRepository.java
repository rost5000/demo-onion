package ru.rost.sample.demoonion.domain;

import java.util.List;
import java.util.Optional;

public interface SimpleClassRepository {

    Optional<SimpleClass> findById(Long id);

    SimpleClass save(SimpleClass simpleClass);

    List<SimpleClass> findAll();
}
