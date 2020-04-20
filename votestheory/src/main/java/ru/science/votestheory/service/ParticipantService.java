package ru.science.votestheory.service;

import ru.science.votestheory.model.Group;
import ru.science.votestheory.model.Participant;
import ru.science.votestheory.model.Society;
import ru.science.votestheory.pojo.Participants;

import java.util.List;

public interface ParticipantService {
    Participant findParticipantById(Long id);

    List<Participant> findAll();
    void save(Participant participant);
    void delete(Participant participant);

    void createParticipantsByAmount(Group group, Long amount);

    void createParticipantsByParticipantsPojo(Participants participantsPojo);

    Integer getAmountOfPaticipantsForSociety(Society society);
}
