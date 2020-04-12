package ru.science.votestheory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.science.votestheory.model.Rule;

@Repository
public interface RuleRepository extends JpaRepository<Rule, Long> {
    Rule findRuleById(Long id);
}
