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
@Table(name = "genres", schema = "public")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genreid", nullable = false)
    private Integer id;

    @Size(max = 30)
    @NotNull
    @Column(name = "genrename", nullable = false, length = 30)
    private String genrename;

    @OneToMany(mappedBy = "genreid")
    private Set<Book> books = new LinkedHashSet<>();

}