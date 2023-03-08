package com.certantchallenge.vtv.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name = "inspector")
@SQLDelete(sql = "UPDATE inspector SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Getter
@Setter
public class InspectorEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false)
    private String name;
    private Boolean softDelete = Boolean.FALSE;
}
