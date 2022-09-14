package br.com.kyrius.apilanguages.infrastructure.repository;

import br.com.kyrius.apilanguages.domain.Language;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LanguageRepository extends MongoRepository<Language, String> {
}
