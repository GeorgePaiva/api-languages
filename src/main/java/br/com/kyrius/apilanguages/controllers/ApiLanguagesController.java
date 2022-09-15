package br.com.kyrius.apilanguages.controllers;

import br.com.kyrius.apilanguages.domain.Language;
import br.com.kyrius.apilanguages.infrastructure.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ApiLanguagesController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping(value = "/languages")
    public ResponseEntity<List<Language>> findAllLanguages() {
        List<Language> languages = languageRepository.findAll();
        return new ResponseEntity<List<Language>>(languages, HttpStatus.OK);
    }

    @GetMapping(value = "/language/{id}")
    public ResponseEntity<Language> findByIdLanguage(@PathVariable String id) {
        Optional<Language> languageOptional = languageRepository.findById(id);
        return new ResponseEntity<Language>(languageOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/language")
    public ResponseEntity<Language> insertLanguage(@RequestBody Language language) {
        return new ResponseEntity<Language>(languageRepository.save(language), HttpStatus.CREATED);
    }

    @PatchMapping("/language/{id}/{ranking}")
    public ResponseEntity<Language> updateLanguage(@PathVariable String id, @PathVariable int ranking) {
        try {
            Optional<Language> languageOptional = languageRepository.findById(id);
            languageOptional.get().setRanking(ranking);
            return new ResponseEntity<Language>(languageRepository.save(languageOptional.get()), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


}
