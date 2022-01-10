package br.uff.id.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
@Entity
@Table(name = "recurso")
public class Recurso implements Serializable{
    
    @Id
    @SequenceGenerator(
            name = "seq_recurso", 
            sequenceName = "seq_recurso_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
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
    
    @URL(message = "O link deve ser informadao")
    @NotNull(message = "O link não pode ser nulo")
    @NotBlank(message = "O link deve ser informado")
    @Column(name = "link", nullable = false)
    private String link;
    
    @Column(name = "imagem", nullable = false, columnDefinition = "bytea")
    private String imagem;
    
    @NotNull(message = "A data de criação não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "criacao", nullable = false)
    private Calendar criacao;
    
    @NotNull(message = "A data de registro não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "registro", nullable = false)
    private Calendar registro;
    
    @NotNull(message = "A lista de palavras não pode ser nula")
    @Column(name = "palavras", nullable = false)
    private List<String> palavras = new ArrayList<>();
    
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("nome ASC")
    private List<Autor> autor = new ArrayList<>();
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "colecao_id", referencedColumnName = "id", nullable = true, foreignKey = @ForeignKey(name = "fk_colecao_id"))
    private Colecao colecao;
    
    public Recurso() {
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
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     * @return the imagem
     */
    public String getImagem() {
        return imagem;
    }

    /**
     * @param imagem the imagem to set
     */
    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
    /**
     * @return the criacao
     */
    public Calendar getCriacao() {
        return criacao;
    }

    /**
     * @param criacao the criacao to set
     */
    public void setCriacao(Calendar criacao) {
        this.criacao = criacao;
    }

    /**
     * @return the registro
     */
    public Calendar getRegistro() {
        return registro;
    }

    /**
     * @param registro the registro to set
     */
    public void setRegistro(Calendar registro) {
        this.registro = registro;
    }
    
    /**
     * @return the palavras
     */
    public List<String> getPalavras() {
        return palavras;
    }

    /**
     * @param palavras the palavras to set
     */
    public void setPalavras(List<String> palavras) {
        this.palavras = palavras;
    }
    
    /**
     * @return the autor
     */
    public List<Autor> getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }
    
    /**
     * @return the colecao
     */
    public Colecao getColecao() {
        return colecao;
    }
    
    /**
     * @param colecao the colecao to set
     */
    public void setColecao(Colecao colecao) {
        this.colecao = colecao;
    }

    @Override
    public String toString() {
        return "Recurso{" + "id=" + id + ", titulo=" + titulo + ", descricao=" + descricao + ", link=" + link + ", imagem=" + imagem + ", criacao=" + criacao + ", registro=" + registro + ", palavras=" + palavras + ", autor=" + autor + ", colecao=" + colecao + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Recurso other = (Recurso) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
}
