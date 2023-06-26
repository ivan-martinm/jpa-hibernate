package com.ivanmartin.hibernateconcurso.dao.impl;

import com.ivanmartin.hibernateconcurso.modelo.Equipo;
import com.ivanmartin.hibernateconcurso.modelo.Invitado;
import com.ivanmartin.hibernateconcurso.modelo.Premio;
import com.ivanmartin.hibernateconcurso.modelo.Programa;
import com.ivanmartin.hibernateconcurso.modelo.Prueba;
import java.io.IOException;
import java.util.Date;
import org.hibernate.HibernateException;

/**
 * Implementación de la interfaz ConcursoDAO para la entidad Programa. Esta
 * clase extiende a la implementación ConcursoDAOImpl genérica con un método que
 * permite crear el objeto Programa a partir de los atributos, un método para
 * añadir los equipos participantes de los programas, un método para añadir el
 * equipo ganador a los programas, un método para añadir premios a los
 * programas, un método para añadir pruebas a los programas y un método para
 * añadir invitados a los programas.
 *
 * @author Ivan Martin
 */
public class ProgramaDAOImpl extends ConcursoDAOImpl<Programa> {

    public ProgramaDAOImpl() throws HibernateException, IOException {
        super();
    }

    /**
     * Crea un objeto Programa a partir de los atributos de su clase.
     *
     * @param titulo la cadena con el título del programa.
     * @param fechaRodaje la fecha de rodaje del programa.
     * @param fechaEmision la fecha en la que se emitirá el programa.
     * @param lugarRodaje el lugar de rodaje del programa.
     * @param cuotaEspectadores la cuota de espectadores durante la emisión del
     * programa.
     * @return el objeto Programa creado.
     */
    public Programa crearPrograma(String titulo, Date fechaRodaje,
                                  Date fechaEmision, String lugarRodaje,
                                  int cuotaEspectadores) {
        return new Programa(titulo, fechaRodaje, fechaEmision, lugarRodaje, cuotaEspectadores);
    }

    /**
     * Añade los equipos participantes al programa y persiste los cambios en
     * la tablas correspondientes en la base de datos. A nivel de objetos, se
     * añaden los equipos a los atributos equipoAzul y equipoVerde del objeto
     * Programa y se añade el programa al atributo programa del equipo.
     *
     * @param programa el programa al que se le añadirán los equipos.
     * @param equipoAzul el equipo que será asignado como equipo azul al
     * programa.
     * @param equipoVerde el equipo que será asignado como equipo verde al
     * programa.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio (excepción por propagación del
     * método actualizar().
     */
    public boolean aniadirEquipos(Programa programa, Equipo equipoAzul,
                                  Equipo equipoVerde) throws BussinessException {
        programa.setEquipoAzul(equipoAzul);
        programa.setEquipoVerde(equipoVerde);
        return actualizar(programa);
    }

    /**
     * Añade el equipo ganador a un programa y persiste los cambios en la tablas
     * correspondientes en la base de datos. A nivel de objetos, se añade el
     * equipo al atributo ganador del programa.
     *
     * @param programa el programa al que se le añadirá el equipo ganador.
     * @param equipo el equipo que será añadido como ganador al programa.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio (excepción por propagación del
     * método actualizar().
     */
    public boolean aniadirGanador(Programa programa, Equipo equipo) throws BussinessException {
        programa.setGanador(equipo);
        return actualizar(programa);
    }

    /**
     * Añade el premio a un programa y persiste los cambios en la tablas
     * correspondientes en la base de datos. A nivel de objetos, se añade el
     * premio al atributo premio del programa y el programa al atributo programa
     * del premio.
     *
     * @param programa el programa al que se le añadirá el premio.
     * @param premio el premio que será añadido al programa.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio (excepción por propagación del
     * método actualizar().
     */
    public boolean aniadirPremio(Programa programa, Premio premio) throws BussinessException {
        programa.setPremio(premio);
        premio.setPrograma(programa);
        return actualizar(programa);
    }

    /**
     * Añade una prueba a un programa y persiste los cambios en la tablas
     * correspondientes en la base de datos. A nivel de objetos, se añade la
     * prueba al Set de prueba del programa.
     *
     * @param programa el programa al que se le añadira la prueba.
     * @param prueba la prueba que será añadida al programa.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio (excepción por propagación del
     * método actualizar().
     */
    public boolean aniadirPrueba(Programa programa, Prueba prueba) throws BussinessException {
        programa.getPruebas().add(prueba);
        return actualizar(programa);
    }

    /**
     * Añade un invitado a un programa y persiste los cambios en la tablas
     * correspondientes en la base de datos. A nivel de objetos, se añade el
     * invitado al atributo invitado del programa.
     *
     * @param programa el programa al que se le añadirá el invitado.
     * @param invitado el invitado que será añadido al programa.
     * @return true si la operación se realizó correctamente, false en caso
     * contrario.
     * @throws BussinessException en caso de que la operación no se realice
     * debido a un error de lógica de negocio (excepción por propagación del
     * método actualizar().
     */
    public boolean aniadirInvitado(Programa programa, Invitado invitado) throws BussinessException {
        programa.getInvitados().add(invitado);
        return actualizar(programa);
    }
}
