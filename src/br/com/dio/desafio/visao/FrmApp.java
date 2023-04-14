package br.com.dio.desafio.visao;

import br.com.dio.desafio.controle.Controle;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.repositorio.Repositorio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmApp extends JFrame{
    private JPanel pnlPrincipal;
    private JScrollPane jscpPrincipal;
    private  Repositorio repositorio;
    private Controle controle;
    private JMenuBar mnuBControle;

    public FrmApp() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                 //System.out.println(info.getName());
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
            UIManager.put("ScrollBar.is3DEnabled", Boolean.TRUE);
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look
            // and feel.
        }
        initComponents();
        setVisible(true);
    }

    private void initComponents() {

        mnuBControle = new JMenuBar();
        jscpPrincipal = new JScrollPane();
        controle = new Controle(new Repositorio());
        pnlPrincipal = new JPanel(new BorderLayout());

        /**
         * Barra de Menu / Controle
         */
        {
            mnuBControle = new JMenuBar();
            mnuBControle.setLayout(new GridLayout(1,1));
            JButton btnDevs = new JButton("Devs");
            btnDevs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("Devs Pressionado");
                    Dev dev = new Dev("Luciano Felix");
                    System.out.println(dev.getNome());
                    controle.criar(dev);
                    pnlPrincipal = new PnlControle(controle);
                    jscpPrincipal.setViewportView(pnlPrincipal);

                }
            });

            JButton btnBootcamps = new JButton("BootCamps");
            JButton btnConteudos = new JButton("Conteúdos");
            JButton btnHome = new JButton("Home");
            mnuBControle.add(btnHome);
            mnuBControle.add(btnDevs);
            mnuBControle.add(btnBootcamps);
            mnuBControle.add(btnConteudos);
        }
        /**
         * Configuração do Frame
         */

        setLayout(new BorderLayout());
        setJMenuBar(mnuBControle);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setSize(1400,800);
        setContentPane(jscpPrincipal);
    }
}

