package com.ivanmartin.hibernateconcurso.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ivan Martin
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = "concursantes")
@Table(name = "equipos")
public class Equipo implements Serializable {

    @Id
    @Column(name = "id_equipo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "pueblo")
    private String pueblo;

    @Column(name = "provincia")
    private String provincia;

    @Column(name = "alcalde")
    private String alcalde;

    @OneToMany(mappedBy = "equipo", cascade = {CascadeType.ALL})
    private Set<Concursante> concursantes;

    public Equipo(String nombre, String pueblo, String provincia, String alcalde) {
        this.nombre = nombre;
        this.pueblo = pueblo;
        this.provincia = provincia;
        this.alcalde = alcalde;
        this.concursantes = new HashSet<>();
    }

}
