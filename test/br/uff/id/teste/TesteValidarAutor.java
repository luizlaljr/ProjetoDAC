package br.uff.id.teste;

import br.uff.id.modelo.Autor;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
public class TesteValidarAutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoDACPU");
        EntityManager em = emf.createEntityManager();
        Autor autor = new Autor();
        autor.setNome("");
        autor.setEmail("di.coelhorjgmail.com");
        autor.setAfiliacao("UFF");
        autor.setOrcid("000-0002-0123-208Y");
        em.getTransaction().begin();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();                
        Set<ConstraintViolation<Autor>> erros = validator.validate(autor);
        
        if(erros.size() > 0){
            for (ConstraintViolation<Autor> erro : erros) {
                System.out.println("Erro de Validação: " + erro.getMessage());
            }
        } else {
            em.persist(autor);
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
    
}
