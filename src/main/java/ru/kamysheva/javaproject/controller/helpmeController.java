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
        List<Author> authors = authorRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Author::getId))
                .toList();
        model.addAttribute("authors", authors);
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
        return "edit_author";
    }

    @PostMapping("/authors/edit_author/{id}")
    public String EditAuthorAction(@PathVariable Integer id, @ModelAttribute Author author) {
        author.setId(id);
        authorRepository.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/authors/delete_author/{id}")
    public String DeleteAuthorAction(@PathVariable Integer id) {
        authorRepository.deleteById(id);
        return "redirect:/authors";
    }

    @GetMapping("/books")
    public String BookAction(Model model) {
        List<Book> books = bookRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Book::getId))
                .toList();
        model.addAttribute("books", books);
        return "actionformbook";
    }

    @GetMapping("/books/add_book")
    public String AddBookAction(Model model) {
        String typeaction = "add";
        model.addAttribute("book", new Book());
        model.addAttribute("typeaction", typeaction);
        return "add_book";
    }

    @PostMapping("/books/add_book")
    public String AddBookAction(@Valid @ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/edit_book/{id}")
    public String EditBookAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Book book = bookRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        model.addAttribute("book", book);
        model.addAttribute("typeaction", typeaction);
        return "edit_book";
    }

    @PostMapping("/books/edit_book/{id}")
    public String EditBookAction(@PathVariable Integer id, @ModelAttribute Book book) {
        book.setId(id);
        bookRepository.save(book);
        return "redirect:/books";
    }

    @GetMapping("/books/delete_book/{id}")
    public String DeleteBookAction(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/books";
    }

    @GetMapping("/genres")
    public String GenreAction(Model model) {
        List<Genre> genres = genreRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Genre::getId))
                .toList();
        model.addAttribute("genres", genres);
        return "actionformgenre";
    }

    @GetMapping("/genres/add_genre")
    public String AddGenreAction(Model model) {
        String typeaction = "add";
        model.addAttribute("genre", new Genre());
        model.addAttribute("typeaction", typeaction);
        return "add_genre";
    }

    @PostMapping("/genres/add_genre")
    public String AddGenreAction(@Valid @ModelAttribute Genre genre) {
        genreRepository.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/genres/edit_genre/{id}")
    public String EditGenreAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Genre genre = genreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid genre Id:" + id));
        model.addAttribute("genre", genre);
        model.addAttribute("typeaction", typeaction);
        return "edit_genre";
    }

    @PostMapping("/genres/edit_genre/{id}")
    public String EditGenreAction(@PathVariable Integer id, @ModelAttribute Genre genre) {
        genre.setId(id);
        genreRepository.save(genre);
        return "redirect:/genres";
    }

    @GetMapping("/genres/delete_genre/{id}")
    public String DeleteGenreAction(@PathVariable Integer id) {
        genreRepository.deleteById(id);
        return "redirect:/genres";
    }

    @GetMapping("/loans")
    public String LoanAction(Model model) {
        List<Loan> loans = loanRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Loan::getId))
                .toList();
        model.addAttribute("loans", loans);
        return "actionformloan";
    }

    @GetMapping("/loans/add_loan")
    public String AddLoanAction(Model model) {
        String typeaction = "add";
        model.addAttribute("loan", new Loan());
        model.addAttribute("typeaction", typeaction);
        return "add_loan";
    }

    @PostMapping("/loans/add_loan")
    public String AddLoanAction(@Valid @ModelAttribute Loan loan) {
        loanRepository.save(loan);
        return "redirect:/loans";
    }

    @GetMapping("/loans/edit_loan/{id}")
    public String EditLoanAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid loan Id:" + id));
        model.addAttribute("loan", loan);
        model.addAttribute("typeaction", typeaction);
        return "edit_loan";
    }

    @PostMapping("/loans/edit_loan/{id}")
    public String EditLoanAction(@PathVariable Integer id, @ModelAttribute Loan loan) {
        loan.setId(id);
        loanRepository.save(loan);
        return "redirect:/loans";
    }

    @GetMapping("/loans/delete_loan/{id}")
    public String DeleteLoanAction(@PathVariable Integer id) {
        loanRepository.deleteById(id);
        return "redirect:/loans";
    }

    @GetMapping("/readers")
    public String ReaderAction(Model model) {
        List<Reader> readers = readerRepository.findAll()
                .stream()
                .sorted(Comparator.comparingInt(Reader::getId))
                .toList();
        model.addAttribute("readers", readers);
        return "actionformreader";
    }


    @GetMapping("/readers/add_reader")
    public String AddReaderAction(Model model) {
        String typeaction = "add";
        model.addAttribute("reader", new Reader());
        model.addAttribute("typeaction", typeaction);
        return "add_reader";
    }

    @PostMapping("/readers/add_reader")
    public String AddReaderAction(@ModelAttribute Reader reader) {
        readerRepository.save(reader);
        return "redirect:/readers";
    }

    @GetMapping("/readers/edit_reader/{id}")
    public String EditReaderAction(@PathVariable Integer id, Model model) {
        String typeaction = "edit";
        Reader reader = readerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid reader Id:" + id));
        model.addAttribute("reader", reader);
        model.addAttribute("typeaction", typeaction);
        return "edit_reader";
    }

    @PostMapping("/readers/edit_reader/{id}")
    public String EditReaderAction(@PathVariable Integer id, @ModelAttribute Reader reader) {
        reader.setId(id);
        readerRepository.save(reader);
        return "redirect:/readers";
    }

    @GetMapping("/reader/delete_reader{id}")
    public String DeleteReaderAction(@PathVariable Integer id) {
        readerRepository.deleteById(id);
        return "redirect:/readers";
    }

}

