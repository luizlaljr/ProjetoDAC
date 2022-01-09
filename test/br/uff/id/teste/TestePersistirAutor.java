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
public class TestePersistirAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        EntityManager em = EntityManagerUtil.getEntityManager();
        Autor autor = new Autor();
        autor.setNome("Diane");
        autor.setEmail("di.coelhoej@gmail.com");
        autor.setSobrenome("Coelho");
        autor.setAfiliacao("UFF");
        autor.setOrcid("0000-0002-0123-208X");
        em.getTransaction().begin();
        em.persist(autor);
        em.getTransaction().commit();
        em.close();
    }
    
}
