package ru.science.votestheory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.science.votestheory.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findGroupById(Long id);
}
