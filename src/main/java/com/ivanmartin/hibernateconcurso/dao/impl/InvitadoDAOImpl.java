package com.ivanmartin.hibernateconcurso.dao.impl;

import com.ivanmartin.hibernateconcurso.modelo.Invitado;
import java.io.IOException;
import java.math.BigDecimal;
import org.hibernate.HibernateException;

/**
 * Implementación de la interfaz ConcursoDAO para la entidad Invitado. Esta
 * clase extiende a la implementación ConcursoDAOImpl genérica con un método que
 * permite crear el objeto Invitado a partir de los atributos.
 *
 * @author Ivan Martin
 */
public class InvitadoDAOImpl extends ConcursoDAOImpl<Invitado> {

    public InvitadoDAOImpl() throws HibernateException, IOException {
        super();
    }

    /**
     * Crea un objeto Invitado a partir de los atributos de su clase.
     *
     * @param nombreArtistico la cadena con el nombre artístico del invitado.
     * @param profesion la cadena con la profesión del invitado.
     * @param nacionalidad la cadena con la nacionalidad del invitado.
     * @param cache el caché del invitado.
     * @param camerino el camerino asignado al invitado.
     * @return el objeto Invitado creado.
     */
    public Invitado crearInvitado(String nombreArtistico, String profesion,
                                  String nacionalidad, BigDecimal cache,
                                  int camerino) {
        return new Invitado(nombreArtistico, profesion, nacionalidad, cache, camerino);
    }

}
