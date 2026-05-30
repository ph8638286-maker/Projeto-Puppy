package com.puppy.debug.repositorio;

import com.puppy.debug.modelo.MetricaPerformance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para gerenciar métricas de performance
 */
@Repository
public interface RepositorioMetricaPerformance extends JpaRepository<MetricaPerformance, Long> {
    Page<MetricaPerformance> findByPontofinal(String pontofinal, Pageable pageable);

    @Query("SELECT p FROM MetricaPerformance p WHERE p.tempoResposta > :limite ORDER BY p.timestamp DESC")
    List<MetricaPerformance> encontrarRequisicoesChuvas(@Param("limite") Long limite);
}
