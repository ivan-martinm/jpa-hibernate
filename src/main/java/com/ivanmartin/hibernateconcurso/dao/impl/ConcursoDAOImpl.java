package com.ivanmartin.hibernateconcurso.dao.impl;

import com.ivanmartin.hibernateconcurso.dao.ConcursoDAO;
import com.ivanmartin.hibernateconcurso.util.HibernateUtil;
import jakarta.persistence.Query;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

/**
 * Implementación de la interfaz genérica ConcursoDAO, que incluye las
 * operaciones CRUD comunes a todas las entidades del modelo.
 *
 * @author Ivan Martin
 */
public class ConcursoDAOImpl<T> implements ConcursoDAO<T> {

    protected SessionFactory sessionFactory;

    public ConcursoDAOImpl() throws HibernateException, IOException {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    /**
     * Inserta un registro en la tabla de la base de datos con la entidad
     * proporcionada como parámetro.
     *
     * @param entidad la entidad que se insertará como registro.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio.
     */
    @Override
    public boolean insertar(T entidad) throws BussinessException {
        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.persist(entidad);
            transaction.commit();
            return true;
        } catch (ConstraintViolationException ce) {
            try {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Exception e) {
                System.err.println("Error haciendo rollback a la transacción");
            } finally {
                throw new BussinessException();
            }
        } catch (Exception e) {
            try {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Exception ex) {
                System.err.println("Error haciendo rollback a la transacción");
            } finally {
                System.err.println(e.getMessage());
                return false;
            }
        }
    }

    /**
     * Devuelve la entidad correspondiente a un registro de la tabla de la base
     * de datos a partir del índice numérico.
     *
     * @param id el índice númerico del registro.
     * @return la entidad solicitida.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio.
     */
    @Override
    public T obtenerPorId(Long id) throws BussinessException {
        try ( Session session = sessionFactory.openSession()) {
            return (T) session.get(obtenerClase(), id);
        } catch (ConstraintViolationException ce) {
            throw new BussinessException();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    /**
     * Devuelve una lista de objetos de una entidad a partir de todos los
     * registros de una tabla de la base de datos.
     *
     * @return la lista de todos los objetos de la entidad.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio.
     */
    @Override
    public List<T> listarTodos() throws BussinessException {
        List<T> listaEntidades = null;
        try ( Session session = sessionFactory.openSession()) {
            Query consulta = session.createQuery("FROM " + obtenerClase().getName(), obtenerClase());
            listaEntidades = consulta.getResultList();
        } catch (ConstraintViolationException ce) {
            throw new BussinessException();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            return listaEntidades;
        }
    }

    /**
     * Actualiza un registro de una tabla de la base de datos a partir de la
     * entidad modificada proporcionada como parámetro.
     *
     * @param entidad la entidad modificada a actualizar en la tabla.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio.
     */
    @Override
    public boolean actualizar(T entidad) throws BussinessException {
        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(entidad);
            transaction.commit();
            return true;
        } catch (ConstraintViolationException ce) {
            try {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Exception e) {
                System.err.println("Error haciendo rollback a la transacción");
            } finally {
                throw new BussinessException();
            }
        } catch (Exception e) {
            try {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Exception ex) {
                System.err.println("Error haciendo rollback a la transacción");

            } finally {
                System.err.println(e.getMessage());
                return false;
            }
        }
    }

    /**
     * Elimina un registro de una tabla de la base de datos a partir de la
     * entidad proporcionada como parámetro.
     *
     * @param entidad la entidad del registro a eliminar.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio.
     */
    @Override
    public boolean eliminar(T entidad) throws BussinessException {
        Transaction transaction = null;
        try ( Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.remove(entidad);
            transaction.commit();
            return true;
        } catch (ConstraintViolationException ce) {
            try {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Exception e) {
                System.err.println("Error haciendo rollback a la transacción");
            } finally {
                throw new BussinessException();
            }
        } catch (Exception e) {
            try {
                if (transaction != null && transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Exception ex) {
                System.err.println("Error haciendo rollback a la transacción");

            } finally {
                System.err.println(e.getMessage());
                return false;
            }
        }
    }

    /**
     * Obtiene la clase parametrizada en la interface genérica ConcursoDAO, para
     * poder crear la consulta en el método listarTodos().
     *
     * @return
     */
    private Class<T> obtenerClase() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
}
