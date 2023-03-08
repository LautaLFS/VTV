package com.certantchallenge.vtv.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "owner", fetch = FetchType.LAZY)
    @Column(nullable = false)
    private List<VehicleEntity> vehicles =new ArrayList<>();
    @Column(nullable = false)
    private Boolean isExempt = Boolean.FALSE;
    private Boolean softDelete = Boolean.FALSE;
}

