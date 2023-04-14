package br.com.dio.desafio.modelo;

import br.com.dio.desafio.dominio.Dev;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TableModelDevs extends AbstractTableModel {
    private List<Dev> linhas;
    private final String[] colunas = new String[]{"Nome", "E-mail"};
    private static final int Nome = 0;
    private static final int Email = 1;

    public TableModelDevs(Set<Dev> linhas) {
        this.linhas = new ArrayList<>(linhas.stream().toList());
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dev d = linhas.get(rowIndex);
        return switch (columnIndex) {
            case Nome -> d.getNome();
            case Email -> d.getEmail();
            default -> throw new IndexOutOfBoundsException(
                    "columnIndex out of bounds");
        };
    }

    public boolean contemNomeLista(Dev dev) {
        for (Dev d : linhas) {
            if (d.equals(dev)) {
                return true;
            }
        }
        return false;
    }

    public Dev getDev(int linha) {
        return linhas.get(linha);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case Nome -> String.class;
            case Email -> String.class;
            default -> throw new IndexOutOfBoundsException(
                    "columnIndex out of bounds");
        };
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Dev d = linhas.get(rowIndex);
        d.setNome((String) aValue);
        fireTableCellUpdated(rowIndex, columnIndex);
        //PainelPessoa.carregarCampos(p);
    }
    @Override
    public String getColumnName(int columnIndex) {
        return colunas[columnIndex];
    };
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == Nome;
    }
    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    @Override
    public int getRowCount() {
        return linhas.size();
    }

}
