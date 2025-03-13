package com.example.spring.repeat.dao.entity;

import com.example.spring.repeat.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "cities")
public class CityEntity {
    @Id
    private String id;

    private String name;

    private String address;

    private String policeStationWhichItBelongs;

    @Enumerated(STRING)
    private Status status;

    @ManyToOne(fetch = EAGER, cascade = {MERGE})
    @JsonIgnore
    private PoliceStationEntity police;

    @OneToMany(mappedBy = "city", fetch = EAGER, cascade = {PERSIST, MERGE})
    private List<RegionEntity> regions;
}
