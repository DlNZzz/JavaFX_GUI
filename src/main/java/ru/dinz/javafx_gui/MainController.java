package ru.dinz.javafx_gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import ru.dinz.model.PDF;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainController {

    private ObservableList<PDF> pdfs = FXCollections.observableArrayList();
    List<PDF> pdfList = new ArrayList<>();

    public class EmployeeController {

        @FXML
        private Button addPDFButton;

        @FXML
        private TextField age;

        @FXML
        private Button considerButton;

        @FXML
        private TextField fio;

        @FXML
        private TextField path;

        @FXML
        private Button saveButton;

        @FXML
        private TableView<PDF> table;

        @FXML
        private TableColumn<PDF, Integer> tableAge;

        @FXML
        private TableColumn<PDF, String> tableName;

        @FXML
        void initialize(ActionEvent event) {
            final FileChooser fileChooser = new FileChooser();
            addPDFButton.setOnAction(actionEvent -> {
                pdfList.add(new PDF());
                //tableName.setCellValueFactory(new PropertyValueFactory<Employee, String>("Name"));
                //tableAge.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("Age"));
                tableName.setCellValueFactory(new PropertyValueFactory<PDF, String>("Name"));
                tableAge.setCellValueFactory(new PropertyValueFactory<PDF, Integer>("Age"));
                table.setItems(pdfs);
            });
            addPDFButton.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    List<File> files = fileChooser.showOpenMultipleDialog(primaryStage);

                    printLog(textArea, files);
                }
            });
        }

    }


}


