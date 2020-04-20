package ru.science.votestheory.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Society {
    private Long id;
    private List<Group> groups;
    private Rule rule;
    private String name;
}
