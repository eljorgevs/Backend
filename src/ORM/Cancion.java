package ORM;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Cancion {
    private int idCancion;
    private String nombre;
    private String genero;
    private int duracion;
    private Date fechaSubida;
    private int numRep;
    private String idUser;
    private String nombreAlbum;
    private Usuario usuarioByIdUser;
    private Collection<Cancioneslista> cancioneslistasByIdCancion;
    private Collection<Comentario> comentariosByIdCancion;

    @Id
    @Column(name = "idCancion")
    public int getIdCancion() {
        return idCancion;
    }

    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
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
    @Column(name = "genero")
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Basic
    @Column(name = "duracion")
    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Basic
    @Column(name = "fechaSubida")
    public Date getFechaSubida() {
        return fechaSubida;
    }

    public void setFechaSubida(Date fechaSubida) {
        this.fechaSubida = fechaSubida;
    }

    @Basic
    @Column(name = "numRep")
    public int getNumRep() {
        return numRep;
    }

    public void setNumRep(int numRep) {
        this.numRep = numRep;
    }

    @Basic
    @Column(name = "idUser")
    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    @Basic
    @Column(name = "nombreAlbum")
    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return idCancion == cancion.idCancion &&
                duracion == cancion.duracion &&
                numRep == cancion.numRep &&
                Objects.equals(nombre, cancion.nombre) &&
                Objects.equals(genero, cancion.genero) &&
                Objects.equals(fechaSubida, cancion.fechaSubida) &&
                Objects.equals(idUser, cancion.idUser) &&
                Objects.equals(nombreAlbum, cancion.nombreAlbum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idCancion, nombre, genero, duracion, fechaSubida, numRep, idUser, nombreAlbum);
    }

    @ManyToOne
    @JoinColumn(name = "idUser", referencedColumnName = "idUser", nullable = false, insertable=false, updatable=false)
    public Usuario getUsuarioByIdUser() {
        return usuarioByIdUser;
    }

    public void setUsuarioByIdUser(Usuario usuarioByIdUser) {
        this.usuarioByIdUser = usuarioByIdUser;
    }

    @OneToMany(mappedBy = "cancionByIdCancion")
    public Collection<Cancioneslista> getCancioneslistasByIdCancion() {
        return cancioneslistasByIdCancion;
    }

    public void setCancioneslistasByIdCancion(Collection<Cancioneslista> cancioneslistasByIdCancion) {
        this.cancioneslistasByIdCancion = cancioneslistasByIdCancion;
    }

    @OneToMany(mappedBy = "cancionByIdCancion")
    public Collection<Comentario> getComentariosByIdCancion() {
        return comentariosByIdCancion;
    }

    public void setComentariosByIdCancion(Collection<Comentario> comentariosByIdCancion) {
        this.comentariosByIdCancion = comentariosByIdCancion;
    }
}