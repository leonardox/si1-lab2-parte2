package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

import com.google.common.base.Objects;

/**
 * Created by X on 25/11/2014.
 */
@Entity(name= "Tarefa")
public class Tarefa implements Comparable{

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String prioridade;

    @Column
    private int semana;

    @Column
    private boolean done;

    // Construtor vazio para o Hibernate criar os objetos
    public Tarefa(){}

    public Tarefa(String nome, String prioridade, int semana) {
        this();
        this.nome = nome;
        this.prioridade = prioridade;
        this.semana = semana;
        done = false;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

    public int getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public boolean getDone(){return done;}

    public void setDone(boolean status){
        done = status;
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Tarefa)) {
            return false;
        }
        Tarefa outraTarefa = (Tarefa) obj;
        return Objects.equal(outraTarefa.getNome(), this.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getNome());
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int compareTo(Object o) {
        Tarefa outraTarefa = (Tarefa)o;

        if(this.getSemana() < outraTarefa.getSemana()){
            return -1;
        }else{
            if(this.getSemana() == outraTarefa.getSemana()){
                if(this.getPrioridade().equals("Alta")){
                    return -1;
                }else{
                    if(this.getPrioridade().equals("Média") && outraTarefa.getPrioridade().equals("Baixa")|| this.getPrioridade().equals("Média") && outraTarefa.getPrioridade().equals("Média") ){
                        return -1;
                    }else{
                        return 1;
                    }
                }
            }else{
                return 1;
            }
        }
    }
}
