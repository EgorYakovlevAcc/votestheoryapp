package ru.science.votestheory.controller;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.science.votestheory.model.Rule;
import ru.science.votestheory.service.RuleService;

@Controller
@RequestMapping("/rules")
public class RuleController {
    @Autowired
    private RuleService ruleService;

    @GetMapping("/add")
    public ResponseEntity addRule() {
        ruleService.addRule();
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity addRule(@PathVariable("id") Long id) {
        ruleService.deleteRule(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/edit")
    public ResponseEntity editRule(@RequestBody Rule rule){
        ruleService.editRule(rule);
        return ResponseEntity.ok(null);
    }
}
