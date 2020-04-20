package ru.science.votestheory.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.science.votestheory.pojo.Society;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rule {
    private Long id;
    private String name;
    private String configuration;
}
