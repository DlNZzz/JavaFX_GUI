package ru.dinz.model;

import javax.persistence.*;

@Entity
@Table(name = "pdfs")
public class PDF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pdf_id;
    private int filial_id;
    private String pdf_name;
    private byte pdf_file;
    private int user_id;

    public int getPdf_id() {
        return pdf_id;
    }

    public void setPdf_id(int pdf_id) {
        this.pdf_id = pdf_id;
    }

    public int getFilial_id() {
        return filial_id;
    }

    public void setFilial_id(int filial_id) {
        this.filial_id = filial_id;
    }

    public String getPdf_name() {
        return pdf_name;
    }

    public void setPdf_name(String pdf_name) {
        this.pdf_name = pdf_name;
    }

    public byte getPdf_file() {
        return pdf_file;
    }

    public void setPdf_file(byte pdf_file) {
        this.pdf_file = pdf_file;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
