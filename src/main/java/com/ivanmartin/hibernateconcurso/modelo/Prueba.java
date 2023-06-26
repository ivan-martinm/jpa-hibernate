package com.ivanmartin.hibernateconcurso.modelo;

import com.ivanmartin.hibernateconcurso.modelo.enums.TipoPrueba;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
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
@Table(name = "pruebas")
public class Prueba implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_prueba")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "numero_jugadores")
    private int numeroJugadores;

    @Column(name = "tipo")
    @Enumerated(value = EnumType.STRING)
    private TipoPrueba tipo;

    public Prueba(String nombre, String descripcion, int numeroJugadores,
                  TipoPrueba tipo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numeroJugadores = numeroJugadores;
        this.tipo = tipo;
    }

}
