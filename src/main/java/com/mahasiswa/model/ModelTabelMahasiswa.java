/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mahasiswa.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author Rasyid
 */
public class ModelTabelMahasiswa extends AbstractTableModel {
    private List<ModelMahasiswa> peminjamList;
    private String[] columnNames = {"ID", "NPM", "Nama", "Judul Buku", "Tanggal Pinjam", "Tanggal Kembali"};

    public ModelTabelMahasiswa(List<ModelMahasiswa> peminjamList) {
        this.peminjamList = peminjamList;
    }

    @Override
    public int getRowCount() {
        return peminjamList.size(); // Jumlah baris sesuai dengan jumlah data peminjam
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Jumlah kolom sesuai dengan jumlah elemen dalam columnNames
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ModelMahasiswa peminjam = peminjamList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return peminjam.getId();
            case 1:
                return peminjam.getNpm();
            case 2:
                return peminjam.getNama();
            case 3:
                return peminjam.getJudulBuku();
            case 4:
                return peminjam.getTanggalPinjam();
            case 5:
                return peminjam.getTanggalKembali();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Mengatur nama kolom
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false; // Semua sel tidak dapat diedit
    }

    // Method untuk menambahkan atau memodifikasi data, jika dibutuhkan
    public void setPeminjamList(List<ModelMahasiswa> peminjamList) {
        this.peminjamList = peminjamList;
        fireTableDataChanged(); // Memberitahu JTable bahwa data telah berubah
    }
}