package br.com.kyrius.apilanguages.controllers;

import br.com.kyrius.apilanguages.domain.Language;
import br.com.kyrius.apilanguages.infrastructure.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiLanguagesController {

    @Autowired
    private LanguageRepository languageRepository;

    @GetMapping(value = "/languages")
    public List<Language> getLanguages() {
        List<Language> languages = languageRepository.findAll();
        return languages;
    }

    @PostMapping("/language")
    public Language insertLanguage(@RequestBody Language language) {
        return languageRepository.save(language);
    }


}
