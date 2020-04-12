package ru.science.votestheory.service;

import ru.science.votestheory.model.Society;

public interface SocietyService {
    Society findSocietyById(Long id);

    void save(Society society);
    void delete(Society society);
}
