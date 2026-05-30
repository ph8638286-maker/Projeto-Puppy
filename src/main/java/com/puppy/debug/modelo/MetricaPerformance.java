package com.puppy.debug.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entidade que armazena métricas de performance
 */
@Entity
@Table(name = "metricas_performance")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MetricaPerformance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pontofinal;
    private Long tempoResposta;
    private String metodo;
    private Integer codigoStatus;
    private Long timestamp;
    private Long memoriaUsada;
    private Double usosCpu;

    @PrePersist
    protected void aoSerCriado() {
        if (timestamp == null) {
            timestamp = System.currentTimeMillis();
        }
    }
}
