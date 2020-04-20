package ru.science.votestheory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.science.votestheory.model.Group;
import ru.science.votestheory.model.Participant;
import ru.science.votestheory.model.Society;
import ru.science.votestheory.pojo.Participants;
import ru.science.votestheory.repository.ParticipantRepository;
import ru.science.votestheory.service.GroupService;
import ru.science.votestheory.service.ParticipantService;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    private ParticipantRepository participantRepository;
    @Autowired
    private GroupService groupService;

    @Override
    public Participant findParticipantById(Long id) {
        return participantRepository.findParticipantById(id);
    }

    @Override
    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    @Override
    public void save(Participant participant) {
        participant.setFund(Math.random());
        participantRepository.save(participant);
    }

    @Override
    public void delete(Participant participant) {
        participantRepository.delete(participant);
    }

    @Override
    public void createParticipantsByAmount(Group group, Long amount) {
        for (int i = 0; i < amount; i++){
            Participant participant = new Participant();
            participant.setGroup(group);
            participantRepository.save(participant);
        }
    }

    @Override
    public void createParticipantsByParticipantsPojo(Participants participantsPojo) {
        if (Objects.isNull(participantsPojo.getGroup())){
            Group group = groupService.getEgoistsGroupForCurrentSociety(participantsPojo.getSociety());
            for (int i = 0; i < participantsPojo.getAmount(); i++){
                Participant participant = new Participant();
                participant.setGroup(group);
                participantRepository.save(participant);
            }
        }
    }

    @Override
    public Integer getAmountOfPaticipantsForSociety(Society society) {
        return society.getGroups().stream()
                .mapToInt(group -> group.getParticipants().size())
                .sum();
    }
}
