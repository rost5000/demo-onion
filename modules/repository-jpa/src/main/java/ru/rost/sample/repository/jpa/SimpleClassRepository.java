package ru.rost.sample.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.rost.sample.repository.jpa.entities.SimpleClassEntity;

public interface SimpleClassRepository extends JpaRepository<SimpleClassEntity, Long> {
}
