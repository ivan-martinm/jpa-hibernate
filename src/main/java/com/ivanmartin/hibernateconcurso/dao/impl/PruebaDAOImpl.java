package com.ivanmartin.hibernateconcurso.dao.impl;

import com.ivanmartin.hibernateconcurso.modelo.Prueba;
import com.ivanmartin.hibernateconcurso.modelo.enums.TipoPrueba;
import java.io.IOException;
import org.hibernate.HibernateException;

/**
 * Implementación de la interfaz ConcursoDAO para la entidad Prueba. Esta
 * clase extiende a la implementación ConcursoDAOImpl genérica con un método que
 * permite crear el objeto Prueba a partir de los atributos.
 *
 * @author Ivan Martin
 */
public class PruebaDAOImpl extends ConcursoDAOImpl<Prueba> {

    public PruebaDAOImpl() throws HibernateException, IOException {
        super();
    }

    /**
     * Crea un objeto Prueba a partir de los atributos de su clase.
     *
     * @param nombre la cadena con el nombre de la prueba.
     * @param descripcion la cadena con la descripción de la prueba.
     * @param numeroJugadores el número de los jugadores por equipo de la
     * prueba.
     * @param tipo el valor del enumerable para el tipo de la prueba.
     * @return el objeto Prueba creado.
     */
    public Prueba crearPrueba(String nombre, String descripcion,
                              int numeroJugadores, TipoPrueba tipo) {
        return new Prueba(nombre, descripcion, numeroJugadores, tipo);
    }
}
