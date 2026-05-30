package com.puppy.debug.modelo;

import com.puppy.debug.enums.NivelLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entidade que representa um registro de log no banco de dados
 */
@Entity
@Table(name = "entradas_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private NivelLog nivel;

    private String mensagem;
    private String modulo;
    private String idUsuario;
    private Long timestamp;
    private String rastreamentoErro;
    private String enderecosIp;
    private Long tempoResposta;
    private String status;

    @PrePersist
    protected void aoSerCriado() {
        if (timestamp == null) {
            timestamp = System.currentTimeMillis();
        }
    }
}
