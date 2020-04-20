package ru.science.votestheory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.science.votestheory.model.Rule;
import ru.science.votestheory.model.Society;
import ru.science.votestheory.pojo.mapping.Mapper;
import ru.science.votestheory.service.GroupService;
import ru.science.votestheory.service.SocietyService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/societies")
public class SocietyController {
    @Autowired
    private SocietyService societyService;
    @Autowired
    private GroupService groupService;

    @GetMapping("/{societyId}/groups")
    @ResponseBody
    public List<ru.science.votestheory.pojo.Group> getAllGroupsForSociety(@PathVariable("societyId") Long societyId){
        return groupService.findGroupsBySocietyId(societyId).stream()
                .map(Mapper::getGroupPojoFromGroup)
                .collect(Collectors.toList());
    }

    @GetMapping("/")
    @ResponseBody
    public ru.science.votestheory.pojo.Society getSociety(@RequestParam("societyId") Long societyId){
        return Mapper.getSocietyPojoFromSociety(societyService.findSocietyById(societyId));
    }

    @GetMapping("/all")
    @ResponseBody
    public List<ru.science.votestheory.pojo.Society> getAllSocieties(){
        return societyService.findAll().stream()
                .map(Mapper::getSocietyPojoFromSociety)
                .collect(Collectors.toList());
    }

    @PostMapping("/add")
    public ResponseEntity addRule(@RequestBody Society society) {
        if (Objects.nonNull(society)) {
            societyService.addSociety(society);
        }
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity addRule(@PathVariable("id") Long id) {
        societyService.deleteSocietyById(id);
        return ResponseEntity.ok(null);
    }

    @PutMapping("/edit")
    public ResponseEntity editRule(@RequestBody Society society) {
        societyService.editSociety(society);
        return ResponseEntity.ok(null);
    }
}
