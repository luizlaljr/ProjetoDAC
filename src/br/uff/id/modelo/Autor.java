package br.uff.id.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
@Entity
@Table(name = "autor")
public class Autor implements Serializable{
    
    @Id
    @SequenceGenerator(
            name = "seq_autor", 
            sequenceName = "seq_autor_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_autor", strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "nome", nullable = false, length = 64)
    private String nome;
    @Column(name = "sobrenome", nullable = false, length = 64)
    private String sobrenome;
    @Column(name = "afiliacao", nullable = false, length = 256)
    private String afiliacao;
    @Column(name = "orcid", nullable = false, length = 19)
    private String orcid;
    
    public Autor() {
        
    }
    
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    
    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sobrenome
     */
    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * @param sobrenome the sobrenome to set
     */
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    /**
     * @return the afiliacao
     */
    public String getAfiliacao() {
        return afiliacao;
    }

    /**
     * @param afiliacao the afiliacao to set
     */
    public void setAfiliacao(String afiliacao) {
        this.afiliacao = afiliacao;
    }

    /**
     * @return the orcid
     */
    public String getOrcid() {
        return orcid;
    }

    /**
     * @param orcid the orcid to set
     */
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }
    
    @Override
    public String toString() {
        return "Autor{" + "email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", afiliacao=" + afiliacao + ", orcid=" + orcid + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
