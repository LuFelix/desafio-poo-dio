package br.com.dio.desafio.view;

import br.com.dio.desafio.dominio.Dev;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;

public class PnlDev extends JPanel {
    private JLabel lblNome;
    private JTextField txtfNome;
    private JLabel lblXP;
    private JTextField txtfXP;
    private JLabel lblStatus;
    private JLabel lblHearts;
    private JPanel pnlPerfil;
    private JPanel pnlStatus;
    private JPanel pnlSuperior;
    private JPanel pnlCursos;
    private JPanel pnlIniciados;
    private JPanel pnlConcluidos;
    private JPanel pnlCentral;
    private JLabel lblCursosIniciados;
    private JLabel lblCursosConcluidos;
    private JTextArea txtaIniciados;
    private JTextArea txtaConcluidos;
    public PnlDev() {
        setLayout(new BorderLayout(5,5));
        initComponents();
    }
    public PnlDev(Dev dev) {
        setLayout(new BorderLayout(5,5));
        initComponents();
    }
    void initComponents(){

        lblNome = new JLabel("Nome");
        txtfNome = new JTextField(15);
        lblXP = new JLabel("__XP__");
        txtfXP = new JTextField(6);
        pnlStatus = new JPanel(new GridLayout(1,2));

        lblStatus = new JLabel("Status");
        pnlStatus.add(lblStatus);
        pnlStatus.add(txtfXP);

        pnlPerfil = new JPanel(new GridLayout(4 ,1));
        pnlPerfil.add(lblNome);
        pnlPerfil.add(txtfNome);
        pnlPerfil.add(new JLabel(""));
        pnlPerfil.add(pnlStatus);

        pnlSuperior = new JPanel(new GridLayout(1,2));
        pnlSuperior.add(pnlPerfil);

        pnlIniciados = new JPanel(new BorderLayout(3,3));
        pnlIniciados.setBorder(BorderFactory.createTitledBorder("Iniciados"));
        txtaIniciados = new JTextArea("Iniciados AQUI");
        pnlIniciados.add(txtaIniciados);


        pnlConcluidos = new JPanel(new BorderLayout(3,3));
        pnlConcluidos.setBorder(BorderFactory.createTitledBorder("Concluidos"));
        txtaConcluidos = new JTextArea("Concluidos AQUI");
        pnlConcluidos.add(txtaConcluidos);

        pnlCursos = new JPanel(new GridLayout(1,2));
        pnlCursos.add(pnlIniciados);
        pnlCursos.add(pnlConcluidos);

        pnlCentral = new JPanel(new BorderLayout());
        pnlCentral.setBorder(BorderFactory.createTitledBorder("Cursos"));
        //pnlCentral.add(pnlStatus, BorderLayout.NORTH);
        pnlCentral.add(pnlCursos,BorderLayout.CENTER);

        setBorder(BorderFactory.createTitledBorder("DEV"));
        add(pnlSuperior,BorderLayout.NORTH);
        add(pnlCentral,BorderLayout.CENTER);

    }

    void carregarDev(Dev dev){
        txtfNome.setText(dev.getNome());
        txtfXP.setText(String.valueOf(dev.calcularTotalXP()));
        txtaIniciados.setText(dev.getConteudosIncritos().toString());
        txtaConcluidos.setText(dev.getConteudosIncritos().toString());
    }

}
