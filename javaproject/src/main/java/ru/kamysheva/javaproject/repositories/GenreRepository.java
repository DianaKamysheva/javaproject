package ru.kamysheva.javaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kamysheva.javaproject.entities.Genre;
import lombok.*;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
}