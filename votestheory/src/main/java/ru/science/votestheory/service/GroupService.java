package ru.science.votestheory.service;

import ru.science.votestheory.model.Group;
import ru.science.votestheory.model.Participant;
import ru.science.votestheory.model.Society;

import java.util.List;

public interface GroupService {
    List<Group> findAll();
    List<Group> findGroupsBySociety(Society society);
    List<Group> findGroupsBySocietyId(Long societyId);
    Group findGroupById(Long id);
    void delete(Group group);
    void safe(Group group);

    void createGroupByGroupPojo(ru.science.votestheory.pojo.Group groupPojo);

    Group getEgoistsGroupForCurrentSociety(ru.science.votestheory.pojo.Society society);
}
