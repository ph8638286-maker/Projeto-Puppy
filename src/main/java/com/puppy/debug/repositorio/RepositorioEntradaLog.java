package com.puppy.debug.repositorio;

import com.puppy.debug.enums.NivelLog;
import com.puppy.debug.modelo.EntradaLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório para gerenciar registros de log
 */
@Repository
public interface RepositorioEntradaLog extends JpaRepository<EntradaLog, Long> {
    Page<EntradaLog> findByNivel(NivelLog nivel, Pageable pageable);
    Page<EntradaLog> findByModulo(String modulo, Pageable pageable);
    Page<EntradaLog> findByIdUsuario(String idUsuario, Pageable pageable);
    Page<EntradaLog> findByNivelAndModulo(NivelLog nivel, String modulo, Pageable pageable);

    @Query("SELECT l FROM EntradaLog l WHERE l.timestamp >= :horaInicio ORDER BY l.timestamp DESC")
    List<EntradaLog> encontrarLogsRecentes(@Param("horaInicio") Long horaInicio);

    @Query(value = "SELECT * FROM entradas_log WHERE nivel = 'ERRO' ORDER BY timestamp DESC LIMIT 100", nativeQuery = true)
    List<EntradaLog> encontrarErrosRecentes();
}
