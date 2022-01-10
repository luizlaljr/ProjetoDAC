package br.uff.id.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
@Entity
@Table(name = "colecao")
@Inheritance(strategy = InheritanceType.JOINED)
public class Colecao implements Serializable {
    @Id
    @SequenceGenerator(
            name = "seq_colecao", 
            sequenceName = "seq_colecao_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_colecao", strategy = GenerationType.SEQUENCE)
    private long id;
    
    @Length(max = 1024, message = "O titulo não pode ter mais de {max} caracteres")
    @NotNull(message = "O titulo não pode ser nulo")
    @NotBlank(message = "O titulo deve ser informado")
    @Column(name = "titulo", nullable = false, length = 1024)
    private String titulo;
    
    @Length(max = 4096, message = "A descricao não pode ter mais de {max} caracteres")
    @NotNull(message = "A descricao não pode ser nula")
    @NotBlank(message = "A descricao deve ser informada")
    @Column(name = "descricao", nullable = false, length = 4096)
    private String descricao;
    
    @Lob
    @NotNull(message = "A imagem não pode ser nula")
    @Column(name = "imagem", nullable = false)
    private byte[] imagem;
    
    @OneToMany(mappedBy = "colecao", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("titulo ASC")
    private List<Recurso> recurso = new ArrayList<>();
    
    public Colecao() {
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
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the imagem
     */
    public byte[] getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(byte[] imagem) {
        this.imagem = imagem;
    }

    public List<Recurso> getRecurso() {
        return recurso;
    }

    public void setRecurso(List<Recurso> recurso) {
        this.recurso = recurso;
    }

    @Override
    public String toString() {
        return "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", imagem=" + imagem + ", recurso=" + recurso;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Colecao other = (Colecao) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
