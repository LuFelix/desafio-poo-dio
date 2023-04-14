package br.com.dio.desafio.visao;

import br.com.dio.desafio.controle.Controle;
import br.com.dio.desafio.dominio.Dev;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BotoesCRUD extends JPanel {

    private JButton btnAdicionar;
    private JButton btnRemove;

    public BotoesCRUD(int linhas, int colunas, Controle controle) {

        btnAdicionar = new JButton("Novo Dev");
        btnAdicionar.setBackground(new Color(0, 0, 0, 0));
        btnAdicionar.addFocusListener(new FocusListener() {
            @Override
            public void focusLost(FocusEvent e) {
                btnAdicionar.setBackground(new Color(0, 0, 0, 0));
            }
            @Override
            public void focusGained(FocusEvent e) {
                btnAdicionar.setBackground(null);
            }
        });
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dev dev = new Dev(JOptionPane.showInputDialog("Qual o Nome do DEV"));
                controle.criar(dev);
                PnlControle.configuraTabela();
            }
        });
        btnAdicionar.addMouseListener(new MouseListener() {
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnAdicionar.setBackground(new Color(0, 0, 0, 0));
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                btnAdicionar.setBackground(null);
            }
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        btnRemove = new JButton("Remover");
        btnRemove.setBackground(new Color(0, 0, 0, 0));
        btnRemove.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent e) {
                btnRemove.setBackground(new Color(0, 0, 0, 0));

            }

            @Override
            public void focusGained(FocusEvent e) {
                btnRemove.setBackground(null);

            }
        });
        btnRemove.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnRemove.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                btnRemove.setBackground(new Color(0, 0, 0, 0));

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                btnRemove.setBackground(null);

            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });

        setLayout(new GridLayout(linhas, colunas));
        add(btnAdicionar);
        add(btnRemove);

    }
}