package ru.science.votestheory.service;

import ru.science.votestheory.model.Rule;

public interface RuleService {
    void save(Rule rule);
    void delete(Rule rule);
}
