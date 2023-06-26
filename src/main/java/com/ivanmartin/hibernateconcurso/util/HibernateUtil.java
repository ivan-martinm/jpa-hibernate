package com.ivanmartin.hibernateconcurso.util;

import java.io.IOException;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * Clase que contiene la interfaz de conexión de Hibernate con la base de datos.
 *
 * @author Ivan Martin
 */
public class HibernateUtil {

    public static SessionFactory sessionFactory;

    /**
     * Crea la SessionFactory de Hibernate de forma estática y que será un
     * recurso único durante toda la aplicación.
     *
     * @throws HibernateException en caso de producirse un error durante la
     * conexión de Hibernate con la base de datos.
     * @throws IOException en caso de producirse un error de lectura o escritura
     * durante la comunicación de Hibernate con la base de datos.
     */
    public static void crearSessionFactory() throws HibernateException, IOException {
        if (sessionFactory == null) {
            StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                    .configure("hibernate.cfg.xml")
                    .build();

            Metadata metadata = new MetadataSources(standardRegistry)
                    .getMetadataBuilder()
                    .build();

            sessionFactory = metadata.getSessionFactoryBuilder()
                    .build();
        }
    }

    /**
     * Devuelve el objeto SessionFactory creado e inicializado.
     *
     * @return el objeto SessionFactory.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Cierra el recurso del objeto SessionFactory, dando por terminada la
     * comunicación de Hibernate con la base de datos.
     */
    public static void cerrarSesionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
