package edu.domnikova.crossplatform.myBooks;

import edu.domnikova.crossplatform.myBooks.book.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/myBooks")
public class MyBooksController {
    private final BookService service;

    public MyBooksController(BookService service){
        this.service = service;
    }

    @GetMapping
    public String index (Model model, @SortDefault.SortDefaults(@SortDefault("title")) Pageable pageable){
        model.addAttribute("title", "Books");
        model.addAttribute("books", service.getBooks(pageable));
        return "myBooks/myBooks";
    }

    @GetMapping("/create")
    public String createBookForm(Model model){
        model.addAttribute("book", new CreateBookFromData());
        modelAddEnumAttributes(model);
        return "myBooks/addBook";
    }

    @PostMapping("/create")
    public String createBook(@Validated(CreateBookValidationGroupSequence.class)
                                 @ModelAttribute("book") CreateBookFromData formData,
                             BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            modelAddEnumAttributes(model);
            return "myBooks/addBook";
        }
        service.createBook(formData.bookParameters());
        return "redirect:/myBooks";
    }

    @GetMapping("/{id}")
    public String editTeamMemberForm(@PathVariable("id") BookId bookId, Model model) {
        Book book = service
                .getBook(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        model.addAttribute("book", EditBookFromData.fromBook(book));
        modelAddEnumAttributes(model);
        model.addAttribute("editMode", EditMode.UPDATE);
        return "myBooks/addBook";
    }

    @PostMapping("/{id}")
    public String editTeamMember(@PathVariable("id") BookId bookId,
                                 @Validated(EditBookValidationGroupSequence.class)
                                 @ModelAttribute("book") EditBookFromData formData,
                                 BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            modelAddEnumAttributes(model);
            model.addAttribute("editMode", EditMode.UPDATE);
            return "myBooks/addBook";
        }
        service.editBook(bookId, formData.toParameters());
        return "redirect:/myBooks";
    }

    @PostMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") BookId bookId,
                             RedirectAttributes redirectAttributes) {
        Book book = service.getBook(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        service.deleteBook(bookId);
        redirectAttributes.addFlashAttribute("deletedBookTitle",
                book.getTitle());
        return "redirect:/myBooks";
    }

    public void modelAddEnumAttributes(Model model){
        model.addAttribute("languages", List.of(Language.UKRAINIAN, Language.ENGLISH, Language.FRENCH,
                                                            Language.GERMAN, Language.ITALIAN, Language.JAPANESE, Language.OTHER));
        model.addAttribute("ageRatings", List.of(AgeRating.G, AgeRating.PG, AgeRating.PG_13, AgeRating.R));
    }
}