package com.herbst;

import java.util.Set;

public interface Armazenamento {
    void armazenarPonto(String usuario, String tipoPonto, int quantidade);
    int recuperarPontos(String usuario, String tipoPonto);
    Set<String> recuperarUsuarios();
    Set<String> recuperarTiposPontos();
}
