package org.chakarova.botanic.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "streets")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "street_generator")
    @SequenceGenerator(name = "street_generator",sequenceName = "street_sequence")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "administrative_abbreviation")
    private String administrativeAbbreviation;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Tree>trees;
}
