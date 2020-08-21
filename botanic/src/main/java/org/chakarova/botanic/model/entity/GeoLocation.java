package org.chakarova.botanic.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "geo_location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeoLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geoLocation_generator")
    @SequenceGenerator(name = "geoLocation_generator",sequenceName = "geoLocation_sequence")

    private Long id;
    @Column
    private double latitude;
    @Column
    private double longitude;

    public GeoLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
