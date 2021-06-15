package ar.edu.unlam.tallerweb1.modelo;

import javax.persistence.Embeddable;

@Embeddable
public enum TurnoEstado {
    PENDIENTE, CANCELADO, EXPIRADO
}
