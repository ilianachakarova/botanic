package org.chakarova.botanic.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "towns")
@Getter
@Setter
@NoArgsConstructor
public class Town {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "town_generator")
    @SequenceGenerator(name = "town_generator",sequenceName = "town_sequence")
    private Long id;
    @Column
    private String name;
    @Column(name = "post_code")
    private String postCode;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Street>streets;
}
