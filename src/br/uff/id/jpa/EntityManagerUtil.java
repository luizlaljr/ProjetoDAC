package br.uff.id.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
public class EntityManagerUtil {
    private static EntityManagerFactory factory = null;
    private static EntityManager em = null;
    
    public static EntityManager getEntityManager() {
        if(factory == null) {
            factory = Persistence.createEntityManagerFactory("ProjetoDACPU");
        }
        if(em == null) {
            em = factory.createEntityManager();
        }
        return em;
    }
}
