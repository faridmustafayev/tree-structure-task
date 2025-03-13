package com.example.spring.repeat.dao.entity;

import com.example.spring.repeat.model.enums.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.MERGE;
import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.FetchType.EAGER;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity
@Builder
@Table(name = "divisions")
public class DivisionEntity {
    @Id
    private String id;

    private String name;

    private String address;

    private String regionWhichItBelongs;

    @Enumerated(STRING)
    private Status status;

    @ManyToOne(fetch = EAGER, cascade = {MERGE})
    @JsonIgnore
    private RegionEntity region;
}
