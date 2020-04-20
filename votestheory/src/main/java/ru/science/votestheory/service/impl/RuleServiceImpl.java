package ru.science.votestheory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.science.votestheory.model.Rule;
import ru.science.votestheory.repository.RuleRepository;
import ru.science.votestheory.service.RuleService;

import java.util.List;

@Service
@Transactional
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

    @Override
    public void addRule(Rule rule) {
        ruleRepository.save(rule);
    }


    @Override
    public void editRule(Rule rule) {
        Rule oldRule = ruleRepository.findRuleById(rule.getId());
        oldRule.setName(rule.getName());
        oldRule.setConfiguration(rule.getConfiguration());
        ruleRepository.save(oldRule);
    }

    @Override
    public List<Rule> findAll() {
        return ruleRepository.findAll();
    }

    @Override
    public void deleteRule(Long id) {
        ruleRepository.deleteById(id);
    }
}
