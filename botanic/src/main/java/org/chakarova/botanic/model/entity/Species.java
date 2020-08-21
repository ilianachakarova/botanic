package org.chakarova.botanic.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "species")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "species_generator")
    @SequenceGenerator(name = "species_generator",sequenceName = "species_sequence")

    private Long id;
    @Column(name = "botanic_name")
    private String botanicName;
    @Column(name = "trivial_name")
    private String trivialName;

}
