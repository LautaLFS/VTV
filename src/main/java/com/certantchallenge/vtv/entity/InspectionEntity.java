package com.certantchallenge.vtv.entity;

import com.certantchallenge.vtv.config.AppConstants;
import lombok.Getter;
import lombok.Setter;
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
    @CreatedDate
    @Column(columnDefinition = "timestamp", nullable = false)
    private Timestamp timestamps;
    @Column(name = "state", nullable = false)
    private String state = AppConstants.DEFAULT_STATE;
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private VehicleEntity vehicleEntity;
    @ManyToOne
    @JoinColumn(name = "inspector_id", nullable = false)
    private InspectorEntity inspector;
    @OneToOne
    @JoinColumn(nullable = false)
    private MeasurementEntity measurement;
    @OneToOne
    @JoinColumn(nullable = false)
    private ObservationEntity observation;
    private Boolean isExempt = Boolean.FALSE;
    private Boolean softDelete = Boolean.FALSE;
}
