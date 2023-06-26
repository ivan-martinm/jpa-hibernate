package com.ivanmartin.hibernateconcurso.modelo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "programas")
public class Programa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_programa")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_rodaje")
    private Date fechaRodaje;

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_emision")
    private Date fechaEmision;

    @Column(name = "lugar_rodaje")
    private String lugarRodaje;

    @Column(name = "cuota_espectadores")
    private int cuotaEspectadores;

    // Programa ---> Equipo 1:1 Unidireccional  (Para equipo azul)
    @OneToOne
    @JoinColumn(name = "equipo_azul", referencedColumnName = "id_equipo")
    private Equipo equipoAzul;

    // Programa ---> Equipo 1:1 Unidireccional  (Para equipo verde)
    @OneToOne
    @JoinColumn(name = "equipo_verde", referencedColumnName = "id_equipo")
    private Equipo equipoVerde;

    // Programa ---> Equipo 1:1 Unidireccional  (Para equipo ganador)
    @OneToOne
    @JoinColumn(name = "equipo_ganador", referencedColumnName = "id_equipo")
    private Equipo ganador;

    // Programa ---> Prueba N:M Unidireccional (EAGER para probar en el Main)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "programas_pruebas", joinColumns = {
        @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")},
               inverseJoinColumns = {
                   @JoinColumn(name = "id_prueba", referencedColumnName = "id_prueba")})
    private Set<Prueba> pruebas;

    // Programa ---> Invitado N:M Unidireccional
    @ManyToMany
    @JoinTable(name = "programas_invitados", joinColumns = {
        @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")},
               inverseJoinColumns = {
                   @JoinColumn(name = "id_invitado", referencedColumnName = "id_invitado")})
    private Set<Invitado> invitados;

    // Programa --- Premio 1:1 Bidireccional
    @OneToOne(mappedBy = "programa", cascade = {CascadeType.ALL})
    private Premio premio;

    public Programa(String titulo, Date fechaRodaje, Date fechaEmision,
                    String lugarRodaje, int cuotaEspectadores) {
        this.titulo = titulo;
        this.fechaRodaje = fechaRodaje;
        this.fechaEmision = fechaEmision;
        this.lugarRodaje = lugarRodaje;
        this.cuotaEspectadores = cuotaEspectadores;
        this.pruebas = new HashSet<>();
        this.invitados = new HashSet<>();
    }
}
