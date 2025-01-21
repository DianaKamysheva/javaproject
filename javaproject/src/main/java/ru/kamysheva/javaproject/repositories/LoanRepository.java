package ru.kamysheva.javaproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kamysheva.javaproject.entities.Loan;
import lombok.*;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
}