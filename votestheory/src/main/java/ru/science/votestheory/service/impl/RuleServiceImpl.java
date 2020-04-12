package ru.science.votestheory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.science.votestheory.model.Rule;
import ru.science.votestheory.repository.RuleRepository;
import ru.science.votestheory.service.RuleService;

@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public void save(Rule rule) {
        ruleRepository.save(rule);
    }

    @Override
    public void delete(Rule rule) {
            ruleRepository.delete(rule);
    }
}
