package ru.science.votestheory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.science.votestheory.model.Society;
import ru.science.votestheory.model.Suggestion;
import ru.science.votestheory.repository.SuggestionRepository;
import ru.science.votestheory.service.ParticipantService;
import ru.science.votestheory.service.SuggestionService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SuggestionServiceImpl implements SuggestionService {
    @Autowired
    private SuggestionRepository suggestionRepository;
    @Autowired
    private ParticipantService participantService;


    @Override
    public void save(Suggestion suggestion) {
        suggestionRepository.save(suggestion);
    }

    @Override
    public void delete(Suggestion suggestion) {
        suggestionRepository.delete(suggestion);
    }

    @Override
    public Suggestion findSuggestionById(Long id) {
        return suggestionRepository.findSuggestionById(id);
    }

    @Override
    public Suggestion createSuggestionWithRandomData(Society society) {
        Suggestion suggestion = new Suggestion();
        Integer societySize = participantService.getAmountOfPaticipantsForSociety(society);
        List<Double> increaseValues = new ArrayList<>();
        for (int i = 0; i < societySize; i++){
            increaseValues.add(Math.random());
        }
        suggestion.setIncreaseValues(increaseValues);
        suggestionRepository.save(suggestion);
        return suggestion;
    }
}
