package com.puppy.debug.enums;

/**
 * Enumeração dos níveis de log disponíveis
 * TRACE: Informações mais detalhadas (apenas desenvolvimento)
 * DEBUG: Informações de debug
 * INFO: Informações gerais
 * WARNING: Avisos
 * ERROR: Erros críticos
 */
public enum NivelLog {
    TRACE(0, "TRACE"),
    DEBUG(1, "DEBUG"),
    INFO(2, "INFO"),
    AVISO(3, "AVISO"),
    ERRO(4, "ERRO");

    private final int nivel;
    private final String nome;

    NivelLog(int nivel, String nome) {
        this.nivel = nivel;
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public String getNome() {
        return nome;
    }

    public boolean ehMaiorOuIgual(NivelLog outro) {
        return this.nivel >= outro.nivel;
    }
}
