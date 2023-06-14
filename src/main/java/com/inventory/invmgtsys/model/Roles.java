package com.inventory.invmgtsys.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@Builder
@Table(name = "roles_tbl", uniqueConstraints = {@UniqueConstraint(columnNames = {"role_id", "name"})})
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
    @Id
    @SequenceGenerator(name = "role_sequence", sequenceName = "role_sequence", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_sequence")
    @Column(name = "role_id")
    private Integer id;
    private String name;
    private boolean status;
}