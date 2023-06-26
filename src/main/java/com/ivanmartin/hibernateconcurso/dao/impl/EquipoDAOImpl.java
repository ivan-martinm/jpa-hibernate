package com.ivanmartin.hibernateconcurso.dao.impl;

import com.ivanmartin.hibernateconcurso.modelo.Concursante;
import com.ivanmartin.hibernateconcurso.modelo.Equipo;
import java.io.IOException;
import org.hibernate.HibernateException;

/**
 * Implementación de la interfaz ConcursoDAO para la entidad Equipo. Esta
 * clase extiende a la implementación ConcursoDAOImpl genérica con un método que
 * permite crear el objeto Equipo a partir de los atributos y otro método
 * para añadir concursantes a los equipos.
 *
 * @author Ivan Martin
 */
public class EquipoDAOImpl extends ConcursoDAOImpl<Equipo> {

    public EquipoDAOImpl() throws HibernateException, IOException {
        super();
    }

    /**
     * Crea un objeto Equipo a partir de los atributos de su clase.
     *
     * @param nombre la cadena con el nombre del equipo.
     * @param pueblo la cadena con el nombre del pueblo al que representa el
     * equipo.
     * @param provincia la cadena con la provincia de origen del equipo.
     * @param alcalde la cadena con el alcalde del pueblo del equipo.
     * @return el objeto Equipo creado.
     */
    public Equipo crearEquipo(String nombre, String pueblo, String provincia,
                              String alcalde) {
        return new Equipo(nombre, pueblo, provincia, alcalde);
    }

    /**
     * Añade un concursante a un equipo y persiste los cambios en la tablas
     * correspondientes en la base de datos. A nivel de objetos, se añade el
     * concursante al Set de concursantes del equipo, y se añade el equipo al
     * atributo equipo del concursante.
     *
     * @param equipo el equipo al que se le añadirá el concursante.
     * @param concursante el concursante que será añadido al equipo.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio (excepción por propagación del
     * método actualizar().
     */
    public boolean aniadirConcursante(Equipo equipo, Concursante concursante) throws BussinessException {
        equipo.getConcursantes().add(concursante);
        concursante.setEquipo(equipo);
        return actualizar(equipo);
    }

}
