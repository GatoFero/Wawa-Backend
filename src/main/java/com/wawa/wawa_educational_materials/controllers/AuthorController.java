package com.wawa.wawa_educational_materials.controllers;

import com.wawa.wawa_educational_materials.entities.Author;
import com.wawa.wawa_educational_materials.models.AuthorDTO;
import com.wawa.wawa_educational_materials.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wawa/authors")
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> addNewAuthor(@RequestBody Author author) {
        authorService.createAuthor(author);
        return ResponseEntity.status(HttpStatus.CREATED).body(author);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAuthorById(@PathVariable String id) {
        Author author = authorService.getAuthorById(id);
        if (author != null) {
            AuthorDTO authorDTO = AuthorDTO.builder()
                    .name(author.getName())
                    .email(author.getEmail())
                    .youtube(author.getYoutube())
                    .facebook(author.getFacebook())
                    .tiktok(author.getTiktok()).build();
            return ResponseEntity.ok(authorDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllAuthors() {
        return ResponseEntity.ok(authorService.getAllAuthors());
    }
}
