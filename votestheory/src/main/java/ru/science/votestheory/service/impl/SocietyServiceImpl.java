package ru.science.votestheory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.science.votestheory.model.Society;
import ru.science.votestheory.repository.SocietyRepository;
import ru.science.votestheory.service.SocietyService;

@Service
public class SocietyServiceImpl implements SocietyService {
    @Autowired
    private SocietyRepository societyRepository;

    @Override
    public Society findSocietyById(Long id) {
        return societyRepository.findSocietiesById(id);
    }

    @Override
    public void save(Society society) {
        societyRepository.save(society);
    }

    @Override
    public void delete(Society society) {
        societyRepository.delete(society);
    }
}
