package com.puppy.debug.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Entidade que rastreia atividades dos usuários
 */
@Entity
@Table(name = "atividades_usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtividadeUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idUsuario;
    private String acao;
    private String detalhes;
    private Long timestamp;
    private String enderecosIp;
    private String status;

    @PrePersist
    protected void aoSerCriado() {
        if (timestamp == null) {
            timestamp = System.currentTimeMillis();
        }
    }
}
