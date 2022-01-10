package br.uff.id.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Luiz Alberto Junior
 * @email luiz_alberto@id.uff.br
 * Trabalho da disciplina Desenvolvimento de Aplicações Corporativas 2021/2
 */
@Entity
@Table(name = "curso")
public class Curso extends Colecao implements Serializable{
    
    @NotNull(message = "A data de registro não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "registro", nullable = false)
    private Calendar registro;

    public Curso() {
    }
    
    public Calendar getRegistro() {
        return registro;
    }

    public void setRegistro(Calendar registro) {
        this.registro = registro;
    }

    @Override
    public String toString() {
        return "Curso{" + super.toString() + "registro=" + registro + '}';
    }
    
}
