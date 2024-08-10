
package com.yoprogramo.login.logica;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Rol implements Serializable {    
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public int id;
    
    @Basic
    public String nombreRol;
    public String descripcionRol;
    @OneToMany(mappedBy = "rol")
    public List<Usuario> listaUsuarios;

    public Rol() {
    }

    public Rol(int id, String nombreRol, String descripcionRol, List<Usuario> listaUsuarios) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.descripcionRol = descripcionRol;
        this.listaUsuarios = listaUsuarios;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getDescripcionRol() {
        return descripcionRol;
    }

    public void setDescripcionRol(String descripcionRol) {
        this.descripcionRol = descripcionRol;
    }

    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", nombreRol=" + nombreRol + ", descripcionRol=" + descripcionRol + ", listaUsuarios=" + listaUsuarios + '}';
    }
    
    
    
}
