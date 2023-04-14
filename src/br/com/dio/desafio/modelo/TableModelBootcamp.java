package br.com.dio.desafio.modelo;

import br.com.dio.desafio.dominio.Bootcamp;

import javax.swing.table.AbstractTableModel;

public class TableModelBootcamp extends AbstractTableModel {
    private Bootcamp bootcamp;

    @Override
    public int getRowCount() {
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 0;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        return null;
    }
}
