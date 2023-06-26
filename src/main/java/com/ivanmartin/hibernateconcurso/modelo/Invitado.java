package com.ivanmartin.hibernateconcurso.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Ivan Martin
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "invitados")
public class Invitado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invitado")
    private Long id;

    @Column(name = "nombre_artistico")
    private String nombreArtistico;

    @Column(name = "profesion")
    private String profesion;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "cache")
    private BigDecimal cache;

    @Column(name = "camerino")
    private int camerino;

    public Invitado(String nombreArtistico, String profesion,
                    String nacionalidad, BigDecimal cache, int camerino) {
        this.nombreArtistico = nombreArtistico;
        this.profesion = profesion;
        this.nacionalidad = nacionalidad;
        this.cache = cache;
        this.camerino = camerino;
    }

}
