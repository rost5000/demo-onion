package ru.rost.sample.repository.jpa;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.mapstruct.factory.Mappers;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ru.rost.sample.demoonion.domain.SimpleClass;
import ru.rost.sample.demoonion.domain.SimpleClassRepository;
import ru.rost.sample.repository.jpa.entities.SimpleClassEntity;
import ru.rost.sample.repository.jpa.mappers.SimpleClassMapper;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SimpleClassRepoAdapter implements SimpleClassRepository {
    SimpleClassMapper simpleClassMapper = Mappers.getMapper(SimpleClassMapper.class);
    CrudRepository<SimpleClassEntity, Long> repository;
    @Override
    public Optional<SimpleClass> findById(Long id) {
        return repository.findById(id)
                .map(simpleClassMapper::toDomain);
    }

    @Override
    public SimpleClass save(SimpleClass simpleClass) {
        return this.simpleClassMapper.toDomain(
                repository.save(
                        this.simpleClassMapper.toJpa(simpleClass)
                )
        );
    }

    @Override
    public List<SimpleClass> findAll() {
        return simpleClassMapper.toDomain(
                repository.findAll()
        );
    }
}
