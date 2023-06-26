package com.ivanmartin.hibernateconcurso.modelo;

import com.ivanmartin.hibernateconcurso.modelo.enums.MetodoPago;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "premios")
public class Premio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_premio")
    private Long id;

    @Column(name = "importe")
    private BigDecimal importe;

    @Column(name = "patrocinador")
    private String patrocinador;

    @Column(name = "impuestos")
    private int impuestos;

    @Column(name = "metodo_pago")
    @Enumerated(value = EnumType.STRING)
    private MetodoPago metodoPago;

    @OneToOne(cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_programa", referencedColumnName = "id_programa")
    private Programa programa;

    public Premio(BigDecimal importe, String patrocinador, int impuestos,
                  MetodoPago metodoPago) {
        this.importe = importe;
        this.patrocinador = patrocinador;
        this.impuestos = impuestos;
        this.metodoPago = metodoPago;
    }
}
