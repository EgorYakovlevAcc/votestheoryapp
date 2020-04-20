package ru.science.votestheory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.science.votestheory.pojo.Group;
import ru.science.votestheory.pojo.mapping.Mapper;
import ru.science.votestheory.service.GroupService;

@Controller
@RequestMapping("/groups")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @PostMapping("/add")
    public ResponseEntity addGroup(@RequestBody Group group){
        groupService.createGroupByGroupPojo(group);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/")
    @ResponseBody
    public Group getGroupById(@RequestParam("groupId") Long groupId){
        return Mapper.getGroupPojoFromGroup(groupService.findGroupById(groupId));
    }
}
