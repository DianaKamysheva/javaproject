package ru.kamysheva.javaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kamysheva.javaproject.entities.*;
import lombok.*;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}