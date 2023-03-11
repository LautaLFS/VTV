package com.certantchallenge.vtv.entity;

import com.certantchallenge.vtv.config.AppConstants;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "inspection")
@SQLDelete(sql = "UPDATE inspection SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
@Getter
@Setter
public class InspectionEntity {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name="uuid", strategy = "uuid2")
    private String id;
    @Column(name = "nroInspection", nullable = false)
    private Integer nroInspection;
    @CreationTimestamp
    @Column(columnDefinition = "timestamp")
    private Timestamp timestamps;
    @Column(name = "state")
    private String state;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;
    @ManyToOne
    @JoinColumn(name = "inspector_id")
    private InspectorEntity inspector;
    private Boolean measurement;
    private Boolean observation;
    private Boolean isExempt;
    private Boolean softDelete = Boolean.FALSE;
}
