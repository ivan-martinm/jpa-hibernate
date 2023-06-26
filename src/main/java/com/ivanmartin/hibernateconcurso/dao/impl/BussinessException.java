package com.ivanmartin.hibernateconcurso.dao.impl;

/**
 * Clase que extiende a Exception y que será lanzada por los métodos de las
 * implementaciones DAO.
 *
 * @author Ivan Martin
 */
public class BussinessException extends Exception {

    public BussinessException() {
        super("Error en la sentencia SQL. Revisa el código de tu consulta o los tipos de datos.");
    }
}
