package br.com.kyrius.apilanguages.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Document(collection = "LanguagesMains")
public class Language implements Serializable {

    @Id
    private String id;
    private String title;
    private String image;
    private int ranking;

    public void setRanking(final int ranking) {
        this.ranking = ranking;
    }
}
