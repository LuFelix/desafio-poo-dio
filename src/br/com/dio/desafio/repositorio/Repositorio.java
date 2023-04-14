package br.com.dio.desafio.repositorio;

import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Conteudo;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;

import java.util.HashSet;
import java.util.Set;

public class Repositorio {
    Set<Dev> devSet;
    Set<Bootcamp> bootcampSet;
    Set<Conteudo> conteudoSet;

    public Repositorio() {
        bootcampSet = new HashSet<>();
        bootcampSet.add(new Bootcamp());
        devSet = new HashSet<>();
        //devSet.add(new Dev());
        conteudoSet = new HashSet<>();
        conteudoSet.add(new Mentoria());
    }

    public Set<Dev> getSetDevs() {
        return devSet;
    }

    public void setSetDevs(Set<Dev> devSet) {
        this.devSet = devSet;
    }

    public Set<Bootcamp> getSetBootcamps() {
        return bootcampSet;
    }

    public void setSetBootcamps(Set<Bootcamp> bootcampSet) {
        this.bootcampSet = bootcampSet;
    }

    public Set<Conteudo> getSetConteudo() {
        return conteudoSet;
    }

    public void setSetConteudo(Set<Conteudo> conteudoSet) {
        this.conteudoSet = conteudoSet;
    }

    @Override
    public String toString() {
        return "Repositorio{" +
                "devSet=" + devSet +
                ", bootcampSet=" + bootcampSet +
                ", conteudoSet=" + conteudoSet +
                '}';
    }
}
