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
@Table(name = "groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "society_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Society society;
    @OneToMany(mappedBy = "group", cascade=CascadeType.ALL)
    private List<Participant> participants;
    private boolean isEgoistsGroup;
}
