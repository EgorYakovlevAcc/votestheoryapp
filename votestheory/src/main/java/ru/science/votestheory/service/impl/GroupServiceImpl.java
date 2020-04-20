package ru.science.votestheory.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.science.votestheory.model.Group;
import ru.science.votestheory.model.Participant;
import ru.science.votestheory.model.Society;
import ru.science.votestheory.repository.GroupRepository;
import ru.science.votestheory.service.GroupService;
import ru.science.votestheory.service.ParticipantService;
import ru.science.votestheory.service.SocietyService;

import java.util.List;
import java.util.Objects;

@Service
@Transactional
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private SocietyService societyService;
    @Autowired
    private ParticipantService participantService;

    @Override
    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> findGroupsBySociety(Society society) {
        return groupRepository.findGroupsBySociety(society);
    }

    @Override
    public List<Group> findGroupsBySocietyId(Long societyId) {
        return groupRepository.findGroupsBySocietyId(societyId);
    }

    @Override
    public Group findGroupById(Long id) {
        return groupRepository.findGroupById(id);
    }

    @Override
    public void delete(Group group) {
        groupRepository.delete(group);
    }

    @Override
    public void safe(Group group) {
        groupRepository.save(group);
    }

    @Override
    public void createGroupByGroupPojo(ru.science.votestheory.pojo.Group groupPojo) {
        Group group = new Group();
        group.setName(groupPojo.getName());
        Society society = societyService.findSocietyById(groupPojo.getSociety().getId());
        group.setSociety(society);
        groupRepository.save(group);
        participantService.createParticipantsByAmount(group, groupPojo.getAmount());
    }

    @Override
    public Group getEgoistsGroupForCurrentSociety(ru.science.votestheory.pojo.Society societyPojo) {
        Society society = societyService.findSocietyById(societyPojo.getId());
        Group group = groupRepository.findAll().stream()
                .filter(g -> g.isEgoistsGroup())
                .findFirst()
                .orElse(null);
        if (Objects.isNull(group)) {
            group = new Group();
            group.setName("EGOISTS_OF_" + society.getName());
            group.setEgoistsGroup(true);
            group.setSociety(society);
            groupRepository.save(group);
        }
        return group;
    }
}
