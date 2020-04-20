package ru.science.votestheory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.science.votestheory.model.Group;
import ru.science.votestheory.model.Society;

import java.util.List;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findGroupById(Long id);

    List<Group> findGroupsBySociety(Society society);
    List<Group> findGroupsBySocietyId(Long societyId);
}
