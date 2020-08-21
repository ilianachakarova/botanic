package org.chakarova.botanic.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "samples")
@Getter
@Setter
@NoArgsConstructor
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sample_generator")
    @SequenceGenerator(name = "sample_generator",sequenceName = "sample_sequence")

    private Long id;
    @Column(name = "collected_on")
    private Date collectedOn;
    @Column(name="description")
    private String description;

}
