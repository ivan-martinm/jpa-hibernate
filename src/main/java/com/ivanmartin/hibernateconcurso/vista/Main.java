package com.ivanmartin.hibernateconcurso.vista;

import com.ivanmartin.hibernateconcurso.dao.impl.BussinessException;
import com.ivanmartin.hibernateconcurso.dao.impl.ConcursanteDAOImpl;
import com.ivanmartin.hibernateconcurso.dao.impl.EquipoDAOImpl;
import com.ivanmartin.hibernateconcurso.dao.impl.InvitadoDAOImpl;
import com.ivanmartin.hibernateconcurso.dao.impl.PremioDAOImpl;
import com.ivanmartin.hibernateconcurso.dao.impl.ProgramaDAOImpl;
import com.ivanmartin.hibernateconcurso.dao.impl.PruebaDAOImpl;
import com.ivanmartin.hibernateconcurso.modelo.Concursante;
import com.ivanmartin.hibernateconcurso.modelo.Equipo;
import com.ivanmartin.hibernateconcurso.modelo.Invitado;
import com.ivanmartin.hibernateconcurso.modelo.Premio;
import com.ivanmartin.hibernateconcurso.modelo.Programa;
import com.ivanmartin.hibernateconcurso.modelo.Prueba;
import com.ivanmartin.hibernateconcurso.modelo.enums.Genero;
import com.ivanmartin.hibernateconcurso.modelo.enums.MetodoPago;
import com.ivanmartin.hibernateconcurso.modelo.enums.TipoPrueba;
import com.ivanmartin.hibernateconcurso.util.HibernateUtil;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.hibernate.HibernateException;

/**
 *
 * @author Ivan Martin
 */
public class Main {

    private static ConcursanteDAOImpl daoConcursante;
    private static EquipoDAOImpl daoEquipo;
    private static InvitadoDAOImpl daoInvitado;
    private static PremioDAOImpl daoPremio;
    private static ProgramaDAOImpl daoPrograma;
    private static PruebaDAOImpl daoPrueba;

    public static void main(String[] args) {
        try {
            HibernateUtil.crearSessionFactory();
        } catch (HibernateException | IOException e) {
            System.err.println("Error iniciando la sesión Hibernate");
            System.err.println(e.getMessage());
            return;
        }

        // Inicializando los controladores
        try {
            daoConcursante = new ConcursanteDAOImpl();
            daoEquipo = new EquipoDAOImpl();
            daoInvitado = new InvitadoDAOImpl();
            daoPremio = new PremioDAOImpl();
            daoPrograma = new ProgramaDAOImpl();
            daoPrueba = new PruebaDAOImpl();
        } catch (HibernateException | IOException e) {
            System.err.println("Error inicializando los controladores");
            System.err.println(e.getMessage());
            return;
        }

        try {
            // Instanciando objetos.
            Concursante concursante1 = daoConcursante.crearConcursante("Manuel", "García Martínez", "78443965L", Genero.HOMBRE);
            Concursante concursante2 = daoConcursante.crearConcursante("Carmen", "Santos Ruiz", "25727278S", Genero.MUJER);
            Concursante concursante3 = daoConcursante.crearConcursante("David", "Hernández Torres", "18903657R", Genero.HOMBRE);
            Concursante concursante4 = daoConcursante.crearConcursante("Marta", "González López", "89577455K", Genero.MUJER);
            Concursante concursante5 = daoConcursante.crearConcursante("Francisco", "Rodríguez Fernández", "63929560G", Genero.HOMBRE);
            Concursante concursante6 = daoConcursante.crearConcursante("Elena", "Jiménez Pérez", "58205624P", Genero.MUJER);
            Concursante concursante7 = daoConcursante.crearConcursante("Javier", "Ruiz García", "73892002T", Genero.HOMBRE);
            Concursante concursante8 = daoConcursante.crearConcursante("Isabel", "Torres Martínez", "46615990C", Genero.MUJER);

            Equipo equipo1 = daoEquipo.crearEquipo("Los Victoriosos", "Tordesillas", "Valladolid", "Juan José Martín García");
            Equipo equipo2 = daoEquipo.crearEquipo("Los Campeones", "Jerez de la Frontera", "Cádiz", "Francisco Manuel León Fernández");
            Equipo equipo3 = daoEquipo.crearEquipo("Los Audaces", "Ponferrada", "León", "Pedro Antonio González García");
            Equipo equipo4 = daoEquipo.crearEquipo("Los Valientes", "Oliva", "Valencia", "José Ramón García Ruiz");

            Invitado invitado1 = daoInvitado.crearInvitado("Penélope Cruz", "Actriz", "Español", BigDecimal.valueOf(15000000), 20);
            Invitado invitado2 = daoInvitado.crearInvitado("Meryl Streep", "Actriz", "Estadounidense", BigDecimal.valueOf(30000000), 27);
            Invitado invitado3 = daoInvitado.crearInvitado("Guillermo del Toro", "Director de cine", "Mexicano", BigDecimal.valueOf(22000000), 25);
            Invitado invitado4 = daoInvitado.crearInvitado("Elon Musk", "Empresario", "Sudáfricano", BigDecimal.valueOf(500000000), 28);

            Premio premio1 = daoPremio.crearPremio(BigDecimal.valueOf(10000), "El Corte Inglés", 2100, MetodoPago.TRANSFERENCIA);
            Premio premio2 = daoPremio.crearPremio(BigDecimal.valueOf(11000), "Repsol", 2310, MetodoPago.CHEQUE);

            Prueba prueba1 = daoPrueba.crearPrueba("La Cuerda", "Hay que cruzar una piscina colgando de una cuerda con las manos", 6, TipoPrueba.FISICA);
            Prueba prueba2 = daoPrueba.crearPrueba("El Cuco", "Se trata de un laberinto donde se deben ir colocando bloques para llegar al final", 4, TipoPrueba.NO_FISICA);
            Prueba prueba3 = daoPrueba.crearPrueba("Los Bolos", "Los concursantes deben intentar derribar todos los bolos con una bola gigante", 6, TipoPrueba.FISICA);
            Prueba prueba4 = daoPrueba.crearPrueba("La Patata caliente", "Los concursantes deben pasarse una patata caliente sin que se les caiga", 4, TipoPrueba.NO_FISICA);

            SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");

            Date fechaRodaje1 = formato.parse("2023-07-01");
            Date fechaRodaje2 = formato.parse("2023-07-08");
            Date fechaEmision1 = formato.parse("2023-09-01");
            Date fechaEmision2 = formato.parse("2023-09-08");
            Programa programa1 = daoPrograma.crearPrograma("Programa 1", fechaRodaje1, fechaEmision1, "Alcalá de Henares", 500000);
            Programa programa2 = daoPrograma.crearPrograma("Programa 2", fechaRodaje2, fechaEmision2, "Pontevedra", 1200000);

            /*
             * Operaciones CRUD *
             */
            // CREATE
            try {
                daoEquipo.insertar(equipo1);
                daoEquipo.insertar(equipo2);
                daoEquipo.insertar(equipo3);
                daoEquipo.insertar(equipo4);

                daoConcursante.insertar(concursante1);
                daoConcursante.insertar(concursante2);
                daoConcursante.insertar(concursante3);
                daoConcursante.insertar(concursante4);
                daoConcursante.insertar(concursante5);
                daoConcursante.insertar(concursante6);
                daoConcursante.insertar(concursante7);
                daoConcursante.insertar(concursante8);

                daoInvitado.insertar(invitado1);
                daoInvitado.insertar(invitado2);
                daoInvitado.insertar(invitado3);
                daoInvitado.insertar(invitado4);

                daoPremio.insertar(premio1);
                daoPremio.insertar(premio2);

                daoPrueba.insertar(prueba1);
                daoPrueba.insertar(prueba2);
                daoPrueba.insertar(prueba3);
                daoPrueba.insertar(prueba4);

                daoPrograma.insertar(programa1);
                daoPrograma.insertar(programa2);
            } catch (BussinessException e) {
                System.err.println("Error CRUD: insertando...");
                System.err.println(e.getMessage());
            }

            // UPDATE
            try {
                // Modificando los equipos
                daoEquipo.aniadirConcursante(equipo1, concursante1);
                daoEquipo.aniadirConcursante(equipo1, concursante2);
                daoEquipo.aniadirConcursante(equipo2, concursante3);
                daoEquipo.aniadirConcursante(equipo2, concursante4);
                daoEquipo.aniadirConcursante(equipo3, concursante5);
                daoEquipo.aniadirConcursante(equipo3, concursante6);
                daoEquipo.aniadirConcursante(equipo4, concursante7);
                daoEquipo.aniadirConcursante(equipo4, concursante8);

                // Modificando el programa 1
                daoPrograma.aniadirEquipos(programa1, equipo1, equipo2);
                daoPrograma.aniadirPremio(programa1, premio1);
                daoPrograma.aniadirPrueba(programa1, prueba1);
                daoPrograma.aniadirPrueba(programa1, prueba3);
                daoPrograma.aniadirPrueba(programa1, prueba4);
                daoPrograma.aniadirGanador(programa1, equipo2);
                daoPrograma.aniadirInvitado(programa1, invitado1);
                daoPrograma.aniadirInvitado(programa1, invitado2);

                // Modificando el programa 2
                daoPrograma.aniadirEquipos(programa2, equipo3, equipo4);
                daoPrograma.aniadirPremio(programa2, premio2);
                daoPrograma.aniadirPrueba(programa2, prueba2);
                daoPrograma.aniadirPrueba(programa2, prueba3);
                daoPrograma.aniadirPrueba(programa2, prueba4);
                daoPrograma.aniadirGanador(programa2, equipo3);
                daoPrograma.aniadirInvitado(programa2, invitado3);
                daoPrograma.aniadirInvitado(programa2, invitado4);
            } catch (BussinessException e) {
                System.err.println("Error CRUD: actualizando...");
                System.err.println(e.getMessage());
            }

            // READ
            try {
                // Consultando un invitado y mostrando sus datos
                Invitado invitadoConsultado = daoInvitado.obtenerPorId(Long.valueOf(1));
                System.out.println("Mostrando información del invitado 1");
                System.out.println("Nombre artístico: " + invitadoConsultado.getNombreArtistico());
                System.out.println("Profesión: " + invitadoConsultado.getProfesion());
                System.out.println("Nacionalidad: " + invitadoConsultado.getNacionalidad());
                System.out.println("Caché: " + invitadoConsultado.getCache());
                System.out.println("Camerino asignado: " + invitadoConsultado.getCamerino());
                System.out.println("-----------");

                // Consultando todos los concursantes
                List<Concursante> concursantes = daoConcursante.listarTodos();
                System.out.println("Lista de todos los concursantes: ");
                for (Concursante concursante : concursantes) {
                    System.out.println(concursante.getId() + " - " + concursante.getNombre() + " " + concursante.getApellidos());
                    System.out.println("DNI: " + concursante.getDni());
                    System.out.println("Género: " + concursante.getGenero());
                    System.out.println("-----------");
                }

                // Consultando un programa y obteniendo su Set de pruebas (EAGER FETCHING)
                Programa programaConsultado = daoPrograma.obtenerPorId(Long.valueOf(2));
                Set<Prueba> pruebas = programaConsultado.getPruebas();
                System.out.println("Listando las pruebas del Programa 2 (con eager fetching): ");
                for (Prueba prueba : pruebas) {
                    System.out.println("Nombre de la prueba: " + prueba.getNombre());
                    System.out.println("Descripción: " + prueba.getDescripcion());
                    System.out.println("Nº de jugadores: " + prueba.getNumeroJugadores());
                    System.out.println("Tipo: " + prueba.getTipo());
                    System.out.println("-----------");
                }

                // Usando queries para obtener los concursantes de un determinado programa
                List<Concursante> concursantesPorPrograma = daoConcursante.obtenerConcursantesPorPrograma(programa2.getId());
                System.out.println("Listando todos los concursantes del Programa 2 (mediante query): ");
                for (Concursante concursante : concursantesPorPrograma) {
                    System.out.println(concursante.getId() + " - " + concursante.getNombre() + " " + concursante.getApellidos());
                    System.out.println("DNI: " + concursante.getDni());
                    System.out.println("Género: " + concursante.getGenero());
                    System.out.println("-----------");
                }
            } catch (BussinessException e) {
                System.err.println("Error CRUD: consultando...");
                System.err.println(e.getMessage());
            }

            // DELETE 
            System.out.println("Borrando el programa 1");
            try {
                daoPrograma.eliminar(programa1);
                /*
            Se puede ver en la consola las operaciones en cascada:
             - Se borra el registro en la tabla programas. 
             - Se borra el premio asociado en la tabla premios.
             - Se borra el registro asociado en la tabla programas_pruebas.
             - Se borra el registro asociado en la tabla programas_invitados.
            Quedan intactos los equipos, los invitados y las pruebas en sus
            tablas corespondientes.
                 */
            } catch (BussinessException e) {
                System.err.println("Error CRUD: eliminando...");
                System.err.println(e.getMessage());
            }
        } catch (ParseException ex) {
            System.err.println("Error parseando fecha");
            System.err.println(ex.getMessage());
        } finally {
            HibernateUtil.cerrarSesionFactory();
        }
    }
}
