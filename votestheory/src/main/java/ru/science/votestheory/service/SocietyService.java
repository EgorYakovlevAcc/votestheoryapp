package ru.science.votestheory.service;

import ru.science.votestheory.model.Rule;
import ru.science.votestheory.model.Society;

import java.util.List;

public interface SocietyService {
    Society findSocietyById(Long id);

    void save(Society society);
    void delete(Society society);

    List<Society> findAll();

    void addSociety(Society society);

    void deleteSocietyById(Long id);

    void editSociety(Society society);
}
