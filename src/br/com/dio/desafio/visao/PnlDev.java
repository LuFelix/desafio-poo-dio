package br.com.dio.desafio.visao;

import br.com.dio.desafio.dominio.Dev;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class PnlDev extends JPanel {
    Dev dev;
    private JLabel lblNome;
    private JTextField txtfNome;
    private JLabel lblEmail;
    private JTextField txtfEmail;
    private JLabel lblXP;
    private JTextField txtfXP;
    private JLabel lblStatus;
    private JLabel lblHearts;
    private JPanel pnlPerfil;
    private JPanel pnlDadosPessoais;
    private JPanel pnlStatus;
    private JPanel pnlSuperior;
    private JPanel pnlCursos;
    private JPanel pnlMatriculados;
    private JPanel pnlConcluidos;
    private JPanel pnlCentral;
    private JLabel lblCursosIniciados;
    private JLabel lblCursosConcluidos;
    private JTextArea txtaMatriculados;
    private JTextArea txtaConcluidos;

    public PnlDev() {
        initComponents();
    }
    public PnlDev(Dev dev) {
        this.dev = dev;
        initComponents();
        exibirDEV();
    }
    void exibirDEV(){
        if (dev != null){
            System.out.println("Nome " + dev.getNome());
            txtfNome.setText(dev.getNome());
            txtfXP.setText(String.valueOf(dev.calcularTotalXP()));
            txtaMatriculados.setText(dev.getConteudosMatriculados().toString());
            txtaConcluidos.setText(dev.getConteudosConcluidos().toString());
        }else {
            System.out.println("DEV não exibido");
        }
    }
    void initComponents(){
        pnlDadosPessoais = new JPanel(new GridLayout(1,2));
        lblNome = new JLabel("Nome");
        txtfNome = new JTextField(15);
        lblEmail = new JLabel("E-mail");
        txtfEmail = new JTextField(15);
        lblXP = new JLabel("__XP__");
        txtfXP = new JTextField(6);
        pnlStatus = new JPanel(new GridLayout(1,2));
        pnlStatus.setBorder(BorderFactory.
                createTitledBorder(new LineBorder(Color.red),
                        "Status",
                        1,
                        1,
                        new Font(
                                "Arial",
                                Font.BOLD,
                                16),
                                Color.red));


        pnlStatus.add(lblXP);
        pnlStatus.add(txtfXP);

        pnlPerfil = new JPanel(new GridLayout(5 ,1));
        pnlPerfil.add(lblNome);
        pnlPerfil.add(txtfNome);
        pnlPerfil.add(lblEmail);
        pnlPerfil.add(txtfEmail);
        pnlPerfil.add(pnlStatus);

        pnlSuperior = new JPanel(new GridLayout(1,2));
        pnlSuperior.add(pnlPerfil);
        pnlSuperior.add(pnlDadosPessoais);

        pnlMatriculados = new JPanel(new BorderLayout(3,3));
        pnlMatriculados.setBorder(BorderFactory.createTitledBorder("Matriculados"));
        txtaMatriculados = new JTextArea("Matriculados AQUI");
        pnlMatriculados.add(txtaMatriculados);


        pnlConcluidos = new JPanel(new BorderLayout(3,3));
        pnlConcluidos.setBorder(BorderFactory.createTitledBorder("Concluidos"));
        txtaConcluidos = new JTextArea("Concluidos AQUI");
        pnlConcluidos.add(txtaConcluidos);

        pnlCursos = new JPanel(new GridLayout(1,2));
        pnlCursos.add(pnlMatriculados);
        pnlCursos.add(pnlConcluidos);

        pnlCentral = new JPanel(new BorderLayout());
        pnlCentral.setBorder(BorderFactory.
                createTitledBorder(new LineBorder(Color.red),
                        "*.* Conteúdos & Mentorias & Cursos & Conquistas *.*",
                1,
                1,
                new Font(
                        "Arial",
                        Font.BOLD,
                        16),
                Color.red));
        //pnlCentral.add(pnlStatus, BorderLayout.NORTH);

        pnlCentral.add(pnlCursos,BorderLayout.CENTER);
        setBorder(BorderFactory.
                createTitledBorder(new LineBorder(Color.red),
                        "DEV",
                        1,
                        1,
                        new Font(
                                "Arial",
                                Font.BOLD,
                                16),
                        Color.red));
        setLayout(new BorderLayout());
        add(pnlSuperior,BorderLayout.NORTH);
        add(pnlCentral,BorderLayout.CENTER);

    }


}
