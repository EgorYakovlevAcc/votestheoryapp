package ru.science.votestheory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.science.votestheory.model.Society;
import ru.science.votestheory.repository.SocietyRepository;
import ru.science.votestheory.service.SocietyService;

import java.util.List;

@Service
@Transactional
public class SocietyServiceImpl implements SocietyService {
    @Autowired
    private SocietyRepository societyRepository;

    @Override
    public Society findSocietyById(Long id) {
        return societyRepository.findSocietyById(id);
    }

    @Override
    public void save(Society society) {
        societyRepository.save(society);
    }

    @Override
    public void delete(Society society) {
        societyRepository.delete(society);
    }

    @Override
    public List<Society> findAll() {
        return societyRepository.findAll();
    }

    @Override
    public void addSociety(Society society) {
        societyRepository.save(society);
    }

    @Override
    public void deleteSocietyById(Long id) {
        Society society = societyRepository.findSocietyById(id);
        societyRepository.delete(society);
    }

    @Override
    public void editSociety(Society society) {
        Society oldSociety = societyRepository.findSocietyById(society.getId());
        oldSociety.setName(society.getName());
        societyRepository.save(oldSociety);
    }
}
