package ru.kamysheva.javaproject.controller;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kamysheva.javaproject.entities.*;
import ru.kamysheva.javaproject.repositories.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import jakarta.validation.*;


@AllArgsConstructor
@Controller
public class helpmeController {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;
    private final LoanRepository loanRepository;
    private final ReaderRepository readerRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Author> authors = authorRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Author::getId))
                .toList();
        List<Book> books = bookRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Book::getId))
                .toList();
        List<Genre> genres = genreRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Genre::getId))
                .toList();
        List<Loan> loans = loanRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Loan::getId))
                .toList();
        List<Reader> readers = readerRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Reader::getId))
                .toList();

        model.addAttribute("authors", authors);
        model.addAttribute("books", books);
        model.addAttribute("genres", genres);
        model.addAttribute("loans", loans);
        model.addAttribute("readers", readers);

        return "index";
    }

    @GetMapping("/authors")
    public String AuthorAction(Model model) {
        return "actionformauthor";
    }


    @GetMapping("/authors/add_author")
    public String AddAuthorAction(Model model) {
        String typeaction = "add";
        model.addAttribute("author", new Author());
        model.addAttribute("typeaction", typeaction);
        return "add_author";
    }

    @PostMapping("/authors/add_author")
    public String AddAuthorAction(@ModelAttribute Author author) {
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit_author/{id}")
    public String EditAuthorAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Author author = authorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
        model.addAttribute("author", author);
        model.addAttribute("typeaction", typeaction);
        return "actionformauthor";
    }

    @PostMapping("/authors/edit_author/{id}")
    public String EditAuthorAction(@PathVariable Integer id, @ModelAttribute Author author, @ModelAttribute String typeaction) {
        author.setId(id);
        authorRepository.save(author);
        return "redirect:/confirm";
    }

    @GetMapping("/author/delete{id}")
    public String DeleteAuthorAction(@PathVariable Integer id) {
        authorRepository.deleteById(id);
        return "redirect:/confirm";
    }

    @GetMapping("/genre/add_readers")
    public String AddGenreAction(Model model) {
        String typeaction = "add";
        model.addAttribute("genre", new Genre());
        model.addAttribute("typeaction", typeaction);
        return "actionformgenre";
    }

    @PostMapping("/genre/add_readers")
    public String AddGenreAction(@Valid @ModelAttribute Genre genre, @ModelAttribute String typeaction) {
        genreRepository.save(genre);
        return "redirect:/confirm";
    }

    @GetMapping("/genre/edit_readers/{id}")
    public String EditGenreAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid genre Id:" + id));
        model.addAttribute("genre", genre);
        model.addAttribute("typeaction", typeaction);
        return "actionformgenre";
    }

    @PostMapping("/edit/genre/{id}")
    public String EditGenreAction(@PathVariable Integer id, @ModelAttribute Genre genre, @ModelAttribute String typeaction) {
        genre.setId(id);
        genreRepository.save(genre);
        return "redirect:/confirm";
    }

    @GetMapping("/delete/genre/{id}")
    public String DeleteGenreAction(@PathVariable Integer id) {
        genreRepository.deleteById(id);
        return "redirect:/confirm";
    }

    @GetMapping("/add/reader")
    public String AddReaderAction(Model model) {
        String typeaction = "add";
        model.addAttribute("reader", new Reader());
        model.addAttribute("typeaction", typeaction);
        return "actionformreader";
    }

    @PostMapping("/add/reader")
    public String AddReaderAction(@Valid @ModelAttribute Reader reader, @ModelAttribute String typeaction) {
        readerRepository.save(reader);
        return "redirect:/confirm";
    }

    @GetMapping("/edit/reader/{id}")
    public String EditReaderAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Reader reader = readerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid reader Id:" + id));
        model.addAttribute("reader", reader);
        model.addAttribute("typeaction", typeaction);
        return "actionformreader";
    }

    @PostMapping("/edit/reader/{id}")
    public String EditReaderAction(@PathVariable Integer id, @ModelAttribute Reader reader, @ModelAttribute String typeaction) {
        reader.setId(id);
        readerRepository.save(reader);
        return "redirect:/confirm";
    }

    @GetMapping("/delete/reader/{id}")
    public String DeleteReaderAction(@PathVariable Integer id) {
        readerRepository.deleteById(id);
        return "redirect:/confirm";
    }

    @GetMapping("/add/loan")
    public String AddLoanAction(Model model) {
        String typeaction = "add";
        model.addAttribute("loan", new Loan());
        model.addAttribute("typeaction", typeaction);
        return "actionformloan";
    }

    @PostMapping("/add/loan")
    public String AddLoanAction(@Valid @ModelAttribute Loan loan, @ModelAttribute String typeaction) {
        loanRepository.save(loan);
        return "redirect:/confirm";
    }

    @GetMapping("/edit/loan/{id}")
    public String EditLoanAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid loan Id:" + id));
        model.addAttribute("loan", loan);
        model.addAttribute("typeaction", typeaction);
        return "actionformloan";
    }

    @PostMapping("/edit/loan/{id}")
    public String EditLoanAction(@PathVariable Integer id, @ModelAttribute Loan loan, @ModelAttribute String typeaction) {
        loan.setId(id);
        loanRepository.save(loan);
        return "redirect:/confirm";
    }

    @GetMapping("/delete/loan/{id}")
    public String DeleteLoanAction(@PathVariable Integer id) {
        loanRepository.deleteById(id);
        return "redirect:/confirm";
    }

    @GetMapping("/add/book")
    public String AddBookAction(Model model) {
        String typeaction = "add";
        model.addAttribute("book", new Book());
        model.addAttribute("typeaction", typeaction);
        return "actionformbook";
    }

    @PostMapping("/add/book")
    public String AddBookAction(@Valid @ModelAttribute Book book, @ModelAttribute String typeaction) {
        bookRepository.save(book);
        return "redirect:/confirm";
    }

    @GetMapping("/edit/book/{id}")
    public String EditBookAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        model.addAttribute("typeaction", typeaction);
        return "actionformbook";
    }

    @PostMapping("/edit/book/{id}")
    public String EditBookAction(@PathVariable Integer id, @ModelAttribute Book book, @ModelAttribute String typeaction) {
        book.setId(id);
        bookRepository.save(book);
        return "redirect:/confirm";
    }

    @GetMapping("/delete/book/{id}")
    public String DeleteBookAction(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/confirm";
    }


}

