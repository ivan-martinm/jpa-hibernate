package com.ivanmartin.hibernateconcurso.dao.impl;

import com.ivanmartin.hibernateconcurso.modelo.Premio;
import com.ivanmartin.hibernateconcurso.modelo.enums.MetodoPago;
import java.io.IOException;
import java.math.BigDecimal;
import org.hibernate.HibernateException;

/**
 * Implementación de la interfaz ConcursoDAO para la entidad Premio. Esta
 * clase extiende a la implementación ConcursoDAOImpl genérica con un método que
 * permite crear el objeto Premio a partir de los atributos.
 *
 * @author Ivan Martin
 */
public class PremioDAOImpl extends ConcursoDAOImpl<Premio> {

    public PremioDAOImpl() throws HibernateException, IOException {
        super();
    }

    /**
     * Crea un objeto Premio a partir de los atributos de su clase.
     *
     * @param importe el importe monetario del premio.
     * @param patrocinador la cadena con el patrocinador que financia el premio.
     * @param impuestos los impuestos que se deducen del premio.
     * @param metodoPago el valor del enumerable para la modalidad de pago del
     * premio.
     * @return el objeto Premio creado.
     */
    public Premio crearPremio(BigDecimal importe, String patrocinador,
                              int impuestos, MetodoPago metodoPago) {
        return new Premio(importe, patrocinador, impuestos, metodoPago);
    }

}
