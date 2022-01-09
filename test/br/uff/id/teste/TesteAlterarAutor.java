package br.uff.id.teste;

import br.uff.id.modelo.Autor;
import java.util.HashSet;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
public class TesteAlterarAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoDACPU");
        EntityManager em = emf.createEntityManager();
        Autor autor = em.find(Autor.class, 1l);
        autor.setEmail("di.coelhorj@gmail.com");
        em.getTransaction().begin();
        em.merge(autor);
        em.getTransaction().commit();
        em.close();
        emf.close();                
    }

}
