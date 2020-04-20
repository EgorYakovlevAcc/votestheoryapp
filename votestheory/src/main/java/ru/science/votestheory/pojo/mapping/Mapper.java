package ru.science.votestheory.pojo.mapping;

import ru.science.votestheory.model.Group;
import ru.science.votestheory.model.Participant;
import ru.science.votestheory.model.Rule;
import ru.science.votestheory.model.Society;

public class Mapper {
    public static ru.science.votestheory.pojo.Rule getRulePojoFromRule(Rule rule) {
        ru.science.votestheory.pojo.Rule rulePojo = new ru.science.votestheory.pojo.Rule();
        rulePojo.setConfiguration(rule.getConfiguration());
        rulePojo.setName(rule.getName());
        rulePojo.setId(rule.getId());
        return rulePojo;
    }

    public static ru.science.votestheory.pojo.Society getSocietyPojoFromSociety(Society society) {
        ru.science.votestheory.pojo.Society societyPojo = new ru.science.votestheory.pojo.Society();
        societyPojo.setId(society.getId());
        societyPojo.setName(society.getName());
        societyPojo.setRule(getRulePojoFromRule(society.getRule()));
        return societyPojo;
    }

    public static ru.science.votestheory.pojo.Group getGroupPojoFromGroup(Group group) {
        ru.science.votestheory.pojo.Group groupPojo = new ru.science.votestheory.pojo.Group();
        groupPojo.setId(group.getId());
        groupPojo.setName(group.getName());
        groupPojo.setAmount(group.getParticipants().stream().count());
        groupPojo.setSociety(getSocietyPojoFromSociety(group.getSociety()));
        return groupPojo;
    }

    public static ru.science.votestheory.pojo.Participant getParticipantPojoFromParticipant(Participant participant) {
        ru.science.votestheory.pojo.Participant participantPojo = new ru.science.votestheory.pojo.Participant();
        participantPojo.setId(participant.getId());
        participantPojo.setGroup(getGroupPojoFromGroup(participant.getGroup()));
        return participantPojo;
    }

}
