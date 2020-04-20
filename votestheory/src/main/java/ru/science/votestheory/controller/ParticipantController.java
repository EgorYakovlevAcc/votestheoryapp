package ru.science.votestheory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.science.votestheory.pojo.Participants;
import ru.science.votestheory.service.ParticipantService;

@Controller
@RequestMapping("/participants")
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;

    @PostMapping("/add")
    public ResponseEntity addParticipants(@RequestBody Participants participantsPojo){
        participantService.createParticipantsByParticipantsPojo(participantsPojo);
        return ResponseEntity.ok(null);
    }
}
