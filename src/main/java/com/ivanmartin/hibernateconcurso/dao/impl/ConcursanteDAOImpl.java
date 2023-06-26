package com.ivanmartin.hibernateconcurso.dao.impl;

import com.ivanmartin.hibernateconcurso.modelo.Concursante;
import com.ivanmartin.hibernateconcurso.modelo.enums.Genero;
import jakarta.persistence.Query;
import java.io.IOException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Implementación de la interfaz ConcursoDAO para la entidad Concursante. Esta
 * clase extiende a la implementación ConcursoDAOImpl genérica con un método que
 * permite crear el objeto Concursante a partir de los atributos y otro método
 * para obtener los concursantes de un programa concreto.
 *
 * @author Ivan Martin
 */
public class ConcursanteDAOImpl extends ConcursoDAOImpl<Concursante> {

    public ConcursanteDAOImpl() throws HibernateException, IOException {
        super();
    }

    /**
     * Crea un objeto Concursante a partir de los atributos de su clase.
     *
     * @param nombre la cadena con el nombre del concursante.
     * @param apellidos la cadena con los apellidos del concursante.
     * @param dni la cadena con el dni del concursante.
     * @param genero el valor del enumerable para el género del concursante.
     * @return el objeto Concursante creado.
     */
    public Concursante crearConcursante(String nombre, String apellidos,
                                        String dni, Genero genero) {
        return new Concursante(nombre, apellidos, dni, genero);
    }

    /**
     * Obtiene la lista de concursantes que participan en un programa concreto,
     * a partir del identificador del programa. El método usa una consulta HQL,
     * relacionando el programa con cada los 2 equipos que participan y a su vez
     * con los concursantes de estos, a través de la unión de 2 consultas
     * siguiendo los "mapeos" anotados en cada una de las clases.
     *
     * @param idPrograma el identificador del programa, que servirá como filtro
     * en la cláusula WHERE de la consulta HQL.
     * @return La lista de objetos Concursante obtenidos de la consulta HQL.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio.
     */
    public List<Concursante> obtenerConcursantesPorPrograma(Long idPrograma) throws BussinessException {
        try ( Session session = sessionFactory.openSession()) {
            Query consulta = session.createQuery("""
                                                 SELECT c FROM Programa p 
                                                 INNER JOIN p.equipoAzul ea
                                                 INNER JOIN ea.concursantes c
                                                 WHERE p.id = :id_programa
                                                 UNION
                                                 SELECT c FROM Programa p 
                                                 INNER JOIN p.equipoVerde ev
                                                 INNER JOIN ev.concursantes c
                                                 WHERE p.id = :id_programa
                                                 """, Concursante.class);
            consulta.setParameter("id_programa", idPrograma);
            return consulta.getResultList();
        } catch (ConstraintViolationException ce) {
            throw new BussinessException();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }
}
