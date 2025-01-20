package ru.kamysheva.javaproject.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "readers", schema = "public")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "readerid", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @Size(max = 30)
    @NotNull
    @Column(name = "surname", nullable = false, length = 30)
    private String surname;

    @OneToMany(mappedBy = "readerid")
    private Set<Loan> loans = new LinkedHashSet<>();

}