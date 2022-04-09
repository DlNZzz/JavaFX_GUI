module ru.dinz.javafx_gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires java.naming;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;

    opens ru.dinz.javafx_gui to javafx.fxml;
    opens ru.dinz.persistence to org.hibernate.orm.core;
    opens ru.dinz.model to org.hibernate.orm.core;
    exports ru.dinz.javafx_gui;
    exports ru.dinz.model;
    exports ru.dinz.persistence;
}