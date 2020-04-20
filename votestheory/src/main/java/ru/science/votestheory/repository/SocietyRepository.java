package ru.science.votestheory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.science.votestheory.model.Society;

@Repository
public interface SocietyRepository extends JpaRepository<Society, Long> {
    Society findSocietyById(Long id);
}
