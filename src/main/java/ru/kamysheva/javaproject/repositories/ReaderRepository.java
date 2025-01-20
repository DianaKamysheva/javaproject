package ru.kamysheva.javaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kamysheva.javaproject.entities.Reader;
import lombok.*;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
}