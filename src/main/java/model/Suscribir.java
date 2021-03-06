package main.java.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Suscribir {
    private int idSuscripcion;
    private Usuario usuarioByIdSuscrito;
    private Usuario usuarioByIdSuscriptor;

    @Id
    @Column(name = "idSuscripcion")
    public int getIdSuscripcion() {
        return idSuscripcion;
    }

    public void setIdSuscripcion(int idSuscripcion) {
        this.idSuscripcion = idSuscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suscribir suscribir = (Suscribir) o;
        return idSuscripcion == suscribir.idSuscripcion;
    }

    @Override
    public int hashCode() {

        return Objects.hash(idSuscripcion);
    }

    @ManyToOne
    @JoinColumn(name = "idSuscrito", referencedColumnName = "idUser", nullable = false)
    public Usuario getUsuarioByIdSuscrito() {
        return usuarioByIdSuscrito;
    }

    public void setUsuarioByIdSuscrito(Usuario usuarioByIdSuscrito) {
        this.usuarioByIdSuscrito = usuarioByIdSuscrito;
    }

    @ManyToOne
    @JoinColumn(name = "idSuscriptor", referencedColumnName = "idUser", nullable = false)
    public Usuario getUsuarioByIdSuscriptor() {
        return usuarioByIdSuscriptor;
    }

    public void setUsuarioByIdSuscriptor(Usuario usuarioByIdSuscriptor) {
        this.usuarioByIdSuscriptor = usuarioByIdSuscriptor;
    }
}
