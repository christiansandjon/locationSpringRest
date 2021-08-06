package com.smc.location.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
@Getter @Setter @NoArgsConstructor
public class Location implements Serializable {

    private static final long serialVersionUID = 9178661439383356177L;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="LOC_SEQ")
    @SequenceGenerator(name="LOC_SEQ", sequenceName="LOC_SEQ", allocationSize=100)
    private Long id;
    private String code;
    private String name;
    private String type;


}
