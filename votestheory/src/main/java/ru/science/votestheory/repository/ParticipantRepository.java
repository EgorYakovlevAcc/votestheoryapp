package ru.science.votestheory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.science.votestheory.model.Group;
import ru.science.votestheory.model.Participant;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findParticipantById(Long id);
    List<Participant> findParticipantsByGroup(Group group);
}
