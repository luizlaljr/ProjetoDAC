package br.uff.id.teste;

import br.uff.id.jpa.EntityManagerUtil;
import br.uff.id.modelo.Autor;
import javax.persistence.EntityManager;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
public class TesteExcluirAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        Autor autor = em.find(Autor.class, 2l);
        em.getTransaction().begin();
        em.remove(autor);
        em.getTransaction().commit();
        em.close();
    }

}
