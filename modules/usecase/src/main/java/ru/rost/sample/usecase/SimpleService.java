package ru.rost.sample.usecase;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.rost.sample.demoonion.domain.SimpleClass;
import ru.rost.sample.demoonion.domain.SimpleClassRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SimpleService {

    SimpleClassRepository simpleClassRepository;

    public List<SimpleClass> getAll() {
        return simpleClassRepository.findAll();
    }
}
