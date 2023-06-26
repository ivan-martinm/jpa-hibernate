package com.ivanmartin.hibernateconcurso.dao;

import com.ivanmartin.hibernateconcurso.dao.impl.BussinessException;
import java.util.List;

/**
 *
 * @author Ivan Martin
 */
public interface ConcursoDAO<T> {

    public boolean insertar(T entidad) throws BussinessException;

    public boolean actualizar(T entidad) throws BussinessException;

    public boolean eliminar(T entidad) throws BussinessException;

    public T obtenerPorId(Long id) throws BussinessException;

    public List<T> listarTodos() throws BussinessException;
}
