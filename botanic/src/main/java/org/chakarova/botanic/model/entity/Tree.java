package org.chakarova.botanic.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "trees")
@Getter
@Setter
@NoArgsConstructor
public class Tree {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tree_generator")
    @SequenceGenerator(name = "species_generator",sequenceName = "tree_sequence")
    private Long id;
    @Column
    private Long number;
    @Column(name = "plantation_date")
    private Date plantationDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Sample>samples;
    @ManyToOne(targetEntity = Species.class,cascade = CascadeType.ALL)
    private Species species;
    @OneToOne(targetEntity = GeoLocation.class)
    private GeoLocation geoLocation;

}
