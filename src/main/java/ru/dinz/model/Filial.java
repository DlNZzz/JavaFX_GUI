package ru.dinz.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "filial_table")
public class Filial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filial_id;
    private String filial_name;

    public static Filial of(String filial_name) {
        Filial filial = new Filial();
        filial.filial_name = filial_name;
        return filial;
    }

    public int getFilial_id() {
        return filial_id;
    }

    public void setFilial_id(int filial_id) {
        this.filial_id = filial_id;
    }

    public String getFilial_name() {
        return filial_name;
    }

    public void setFilial_name(String filial_name) {
        this.filial_name = filial_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Filial filial = (Filial) o;
        return filial_id == filial.filial_id && Objects.equals(filial_name, filial.filial_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filial_id, filial_name);
    }

    @Override
    public String toString() {
        return "Filial{" +
                "filial_id=" + filial_id +
                ", filial_name='" + filial_name + '\'' +
                '}';
    }
}
