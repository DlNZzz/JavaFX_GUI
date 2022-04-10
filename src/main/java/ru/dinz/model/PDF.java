package ru.dinz.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "pdf")
public class PDF {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pdf;
    private int user_id;
    private String type_file;
    private String name_file;
    private Timestamp data_create;
    private byte[] source;

    public PDF() {
    }

    public PDF(int user_id, String type_file, String name_file, Timestamp data_create, byte[] source) {
        this.user_id = user_id;
        this.type_file = type_file;
        this.name_file = name_file;
        this.data_create = data_create;
        this.source = source;
    }

    public int getId_pdf() {
        return id_pdf;
    }

    public void setId_pdf(int id_pdf) {
        this.id_pdf = id_pdf;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getType_file() {
        return type_file;
    }

    public void setType_file(String type_file) {
        this.type_file = type_file;
    }

    public String getName_file() {
        return name_file;
    }

    public void setName_file(String name_file) {
        this.name_file = name_file;
    }

    public Timestamp getData_create() {
        return data_create;
    }

    public void setData_create(Timestamp data_create) {
        this.data_create = data_create;
    }

    public byte[] getSource() {
        return source;
    }

    public void setSource(byte[] source) {
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PDF pdf = (PDF) o;
        return id_pdf == pdf.id_pdf && user_id == pdf.user_id && Objects.equals(type_file, pdf.type_file) && Objects.equals(name_file, pdf.name_file) && Objects.equals(data_create, pdf.data_create) && Arrays.equals(source, pdf.source);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id_pdf, user_id, type_file, name_file, data_create);
        result = 31 * result + Arrays.hashCode(source);
        return result;
    }

    @Override
    public String toString() {
        return "PDF{" +
                "id_pdf=" + id_pdf +
                ", user_id=" + user_id +
                ", type_file='" + type_file + '\'' +
                ", name_file='" + name_file + '\'' +
                ", data_create=" + data_create +
                ", source=" + Arrays.toString(source) +
                '}';
    }
}
