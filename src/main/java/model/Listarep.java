package main.java.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Listarep {
    private int idLista;
    private String nombre;
    private int numElementos;
    private Collection<Cancioneslista> cancioneslistasByIdLista;
    private Usuario usuarioByIdUser;

    @Id
    @Column(name = "idLista")
    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "numElementos")
    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Listarep listarep = (Listarep) o;
        return idLista == listarep.idLista &&
                numElementos == listarep.numElementos &&
                Objects.equals(nombre, listarep.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idLista, nombre, numElementos);
    }

    @OneToMany(mappedBy = "listarepByListaRep")
    public Collection<Cancioneslista> getCancioneslistasByIdLista() {
        return cancioneslistasByIdLista;
    }

    public void setCancioneslistasByIdLista(Collection<Cancioneslista> cancioneslistasByIdLista) {
        this.cancioneslistasByIdLista = cancioneslistasByIdLista;
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false)
    public Usuario getUsuarioByIdUser() {
        return usuarioByIdUser;
    }

    public void setUsuarioByIdUser(Usuario usuarioByIdUser) {
        this.usuarioByIdUser = usuarioByIdUser;
    }
}
