package br.com.dio.desafio.view;

import br.com.dio.desafio.dominio.Dev;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class FrmApp extends JFrame{

    public FrmApp() {
        initComponents();
        setVisible(true);
    }

    private void initComponents() {
        JPanel pnlControle = new JPanel(new BorderLayout());
        JPanel pnlDetalhes = new JPanel(new BorderLayout(5,5));
        JSplitPane jspPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JMenuBar mnuBControle = new JMenuBar();
        JScrollPane jscpDetalhes = new JScrollPane();

        /**
         * Barra de Menu / Controle
         */
        {
            mnuBControle = new JMenuBar();
            mnuBControle.setLayout(new GridLayout(1,1));

            JButton btnDevs = new JButton("Devs");
            JButton btnBootcamps = new JButton("BootCamps");
            JButton btnConteudos = new JButton("Conteúdos");
            JButton btnHome = new JButton("Home");
            mnuBControle.add(btnHome);
            mnuBControle.add(btnDevs);
            mnuBControle.add(btnBootcamps);
            mnuBControle.add(btnConteudos);
        }

        /**
         * Painel Esquerdo
         */

        jspPrincipal.setDividerLocation(200);
        jspPrincipal.setLeftComponent(pnlControle);

        /**
         * Painel Direito
         */

        pnlDetalhes.add(new PnlDev());
        jscpDetalhes.setViewportView(pnlDetalhes);
        jspPrincipal.setRightComponent(jscpDetalhes);


        /**
         * Configuração do Frame
         */

        setLayout(new BorderLayout());
        setJMenuBar(mnuBControle);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setLocationRelativeTo(null);
        setContentPane(jspPrincipal);
        setSize(900,500);
    }
}

