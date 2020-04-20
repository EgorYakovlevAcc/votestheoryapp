package ru.science.votestheory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.science.votestheory.model.Rule;
import ru.science.votestheory.pojo.mapping.Mapper;
import ru.science.votestheory.service.RuleService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/rules")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @GetMapping("/all")
    @ResponseBody
    public List<ru.science.votestheory.pojo.Rule> getAllRules(){
        return ruleService.findAll().stream()
                .map(Mapper::getRulePojoFromRule)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity addRule(@RequestBody Rule rule) {
        if (Objects.nonNull(rule)) {
            ruleService.addRule(rule);
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity addRule(@PathVariable("id") Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/edit")
    public ResponseEntity editRule(@RequestBody Rule rule) {
        ruleService.editRule(rule);
        return ResponseEntity.ok(null);
    }
}
