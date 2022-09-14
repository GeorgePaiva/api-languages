package br.com.kyrius.apilanguages.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@AllArgsConstructor
@Document(collection = "LanguagesMains")
public class Language {

    @Id
    private final String id;
    private final String title;
    private final String image;
    private final int ranking;
}
