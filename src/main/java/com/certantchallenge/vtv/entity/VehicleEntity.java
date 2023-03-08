package com.certantchallenge.vtv.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
@SQLDelete(sql = "UPDATE vehicle SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Getter
@Setter
public class VehicleEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    @Column(name = "domain", nullable = false)
    private String domain;
    @Column(name = "model", nullable = false)
    private String model;
    @Column(name = "brand", nullable = false)
    private String brand;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private UserEntity owner;
    private Boolean softDelete = Boolean.FALSE;
}
