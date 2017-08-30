/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Usuario
 */
public class Conexion {
    
    private Conexion() {
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();
 private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CORPUSPU");
        private static final EntityManager em = emf.createEntityManager();

    }

    public EntityManager getEntity() {
        return ConexionHolder.em;

    }

    public void persist(Object object) {

        getEntity().getTransaction().begin();
        try {
            getEntity().persist(object);
            getEntity().getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            getEntity().getTransaction().rollback();
        }
    }
}
