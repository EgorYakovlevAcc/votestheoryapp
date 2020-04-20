package ru.science.votestheory.service;

import ru.science.votestheory.model.Rule;

import java.util.List;

public interface RuleService {
    void save(Rule rule);
    void delete(Rule rule);

    void addRule(Rule rule);

    void deleteRule(Long id);

    void editRule(Rule rule);

    List<Rule> findAll();
}
