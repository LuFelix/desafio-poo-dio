package br.com.dio.desafio.controle;

import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.modelo.TableModelDevs;
import br.com.dio.desafio.repositorio.Repositorio;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

public class Controle {

    Repositorio repositorio;
    private TableModelDevs modelDevs;
    private JTable tblBootcamps;
    private JTable tblConteudos;
    private JTable tblDevs;

    public Controle(Repositorio repositorio) {
        this.repositorio = repositorio;
        modelDevs = new TableModelDevs(repositorio.getSetDevs());

    }

    public TableModelDevs getModelDevs() {
        return new TableModelDevs(repositorio.getSetDevs());
    }

    public JTable carregarTabelaDevs() {
        System.out.println("Carregar Tabela de Devs");
        modelDevs = new TableModelDevs(repositorio.getSetDevs());
        tblDevs = new JTable(modelDevs);
        System.out.println("QTD de Devs: " + tblDevs.getModel().getRowCount());
        return tblDevs;
    }
    public Dev carregarDev(int linha){
        if (linha!=-1){
            return modelDevs.getDev(linha);
        }
        return null;
    }

    public void criar(Dev dev) {
        System.out.println(dev.getNome());
        this.repositorio.getSetDevs().add(dev);
        //System.out.println(this.repositorio.getSetDevs().stream().findFirst()+ " Adicionado ao Set!!");
    }
    public void remover(Dev dev) {
        repositorio.getSetDevs().remove(dev);
    }
    @Override
    public String toString() {
        return "Controle{" +
                "repositorio=" + repositorio +
                '}';
    }

    }

