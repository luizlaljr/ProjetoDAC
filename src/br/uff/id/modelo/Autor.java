package br.uff.id.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

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
    
    @Email(message = "O email deve ser valido")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    
    @Length(max = 64, message = "O nome não pode ter mais de {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome deve ser informado")
    @Column(name = "nome", nullable = false, length = 64)
    private String nome;
    
    @Length(max = 64, message = "O sobrenome não pode ter mais de {max} caracteres")
    @NotNull(message = "O sobrenome não pode ser nulo")
    @NotBlank(message = "O sobrenome deve ser informado")
    @Column(name = "sobrenome", nullable = false, length = 64)
    private String sobrenome;
    
    @Length(max = 256, message = "O afiliacao não pode ter mais de {max} caracteres")
    @NotNull(message = "O afiliacao não pode ser nulo")
    @NotBlank(message = "O afiliacao deve ser informado")
    @Column(name = "afiliacao", nullable = false, length = 256)
    private String afiliacao;
    
    @Pattern(message = "O ORCID deve seguir o seguinte padrão 0000-0002-0123-208X",regexp = "(\\d{4}\\-\\d{4}\\-\\d{4}\\-\\d{3}(?:\\d|X))$")
    @Column(name = "orcid", nullable = false, length = 19)
    private String orcid;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false, foreignKey = @ForeignKey(name = "fk_recurso_id"))
    private Recurso recurso;
        
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
    
    /**
     * @return the recurso
     */
    public Recurso getRecurso() {
        return recurso;
    }

    /**
     * @param recurso the recurso to set
     */
    public void setRecurso(Recurso recursos) {
        this.recurso = recurso;
    }    

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", afiliacao=" + afiliacao + ", orcid=" + orcid + ", recurso=" + recurso + '}';
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
