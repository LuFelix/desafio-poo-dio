package br.com.dio.desafio.visao;

import br.com.dio.desafio.controle.Controle;
import br.com.dio.desafio.dominio.Dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PnlControle extends JPanel{
    JSplitPane jspPrincipal;
    JPanel pnlCRUD;
    static JPanel pnlDetalhes;
    JPanel pnlBotoes;
    JMenuBar mnuBControle = new JMenuBar();
    JScrollPane jscpControle = new JScrollPane();
    static JScrollPane jscpDetalhes = new JScrollPane();
    private static JTable tabela;
    private static Controle controle;
    static JScrollPane jscpTabela;
        public PnlControle(Controle controle) {
            this.controle = controle;

            jspPrincipal = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
            pnlCRUD = new JPanel(new BorderLayout());
            pnlCRUD.add(new BotoesCRUD(0,2,controle), BorderLayout.NORTH);

            jscpTabela = new JScrollPane(tabela);
            pnlCRUD.add(jscpTabela, BorderLayout.CENTER);
            jscpControle.setViewportView(pnlCRUD);

            jspPrincipal.setLeftComponent(jscpControle);

            pnlDetalhes = new PnlDev();
            jscpDetalhes.setViewportView(pnlDetalhes);
            jspPrincipal.setRightComponent(jscpDetalhes);
            adicionarDEV();
            configuraTabela();
            setLayout(new BorderLayout());
            add(jspPrincipal,BorderLayout.CENTER);
            setVisible(true);
    }
    void adicionarDEV(){

           controle.criar(new Dev("Mateus"));
           controle.criar(new Dev("Marcos"));
           controle.criar(new Dev("Lucas"));
           controle.criar(new Dev("João"));
           controle.criar(new Dev("Kardec"));



    }
    static void configuraTabela(){
            tabela = new JTable(controle.getModelDevs());
            tabela.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    refreshDetalhes();

                    //System.out.println("DEV Selecionado" + controle.getModelDevs().getDev(tabela.getSelectedRow()));
                }
            });
        jscpTabela.setViewportView(tabela);
    }
    public static void refreshDetalhes(){
        pnlDetalhes = new PnlDev(controle.getModelDevs().getDev(tabela.getSelectedRow()));
        jscpDetalhes.setViewportView(pnlDetalhes);
    }



}
