package ru.science.votestheory.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "societies")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Society {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "society",cascade = CascadeType.ALL)
    private List<Group> groups;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "rule_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Rule rule;
    private String name;
}
