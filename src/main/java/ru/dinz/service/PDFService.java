package ru.dinz.service;

import ru.dinz.model.PDF;
import ru.dinz.persistence.PDFStore;

import java.util.ArrayList;
import java.util.List;

public class PDFService {

    private final PDFStore store;

    public PDFService(PDFStore pdfStore) {
        this.store = pdfStore;
    }

    public List<PDF> findAll() {
        return store.findAll();
    }

    public void add(PDF pdf) {
        store.add(pdf);
    }

    public List<PDF> findByUserId(int userId) {
        List<PDF> list = findAll();
        List<PDF> result = new ArrayList<>();
        for (PDF pdf : list) {
            if (pdf.getUser_id() == userId) {
                result.add(pdf);
            }
        }
        return result;
    }
}
