package ru.kamysheva.javaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kamysheva.javaproject.entities.Book;
import lombok.*;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}