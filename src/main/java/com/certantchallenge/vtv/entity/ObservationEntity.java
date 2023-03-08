package com.certantchallenge.vtv.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "observation")
@SQLDelete(sql = "UPDATE observation SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Getter
@Setter
public class ObservationEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    private Boolean isApproved = Boolean.FALSE;
    private Boolean softDelete = Boolean.FALSE;
}

