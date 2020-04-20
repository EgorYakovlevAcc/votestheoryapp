package ru.science.votestheory.service;

import ru.science.votestheory.model.Society;
import ru.science.votestheory.model.Suggestion;

public interface SuggestionService {
    void save(Suggestion suggestion);
    void delete(Suggestion suggestion);

    Suggestion findSuggestionById(Long id);

    Suggestion createSuggestionWithRandomData(Society society);

}
