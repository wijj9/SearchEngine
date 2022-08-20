package pgdp.searchengine.gui;

import pgdp.searchengine.gui.controller.AdminController;
import pgdp.searchengine.gui.controller.ResultController;
import pgdp.searchengine.gui.controller.SearchController;
import pgdp.searchengine.gui.controller.SearchEngineController;
import pgdp.searchengine.gui.model.AdminModel;
import pgdp.searchengine.gui.model.ResultModel;
import pgdp.searchengine.gui.view.*;
import pgdp.searchengine.pagerepository.LinkedDocumentCollection;

import javax.swing.*;

public class StartGUI {

    /**
     * main()-Methode, die die Suchmaschinen-GUI ausführt
     * @param args
     */

    public static void main(String[] args) {
        startGUI();
    }

    public static void startGUI() {
        // Erzeugen einer LinkedDocumentCollection
        LinkedDocumentCollection documentCollection = new LinkedDocumentCollection(7);



        // Erzeugen der beiden Model-Objekte
        AdminModel adminModel = new AdminModel(documentCollection);
        ResultModel resultModel = new ResultModel(documentCollection);

        // Erzeugen der SearchEngine-Objekte (View und Controller) und setzen der Referenzen aufeinander
        SearchEngineView searchEngineView = new SearchEngineView();
        SearchEngineController searchEngineController = new SearchEngineController();

        searchEngineView.setSearchEngineController(searchEngineController);
        searchEngineController.setSearchEngineView(searchEngineView);

        // Erzeugen der Admin-Objekte und setzen der Referenzen
        AdminView adminView = new AdminView();
        AdminController adminController = new AdminController();
        //
        DocumentPane documentPane = new DocumentPane(1,"man1.pgdp.sse.in.tum.de/showchar.1.html"
        ,"show car","testing",new int[]{1,2,3});
        DummyDocumentPane dummyDocumentPane = new DummyDocumentPane(2,"man1.pgdp.sse.in.tum.de/showchar.1.html",
                adminController);
        DummyDocumentPane dummyDocumentPane2 = new DummyDocumentPane(3,"man1.pgdp.sse.in.tum.de/showchar.1.html",
                adminController);
        DummyDocumentPane dummyDocumentPane3 = new DummyDocumentPane(4,"man1.pgdp.sse.in.tum.de/showchar.1.html",
                adminController);
        DummyDocumentPane dummyDocumentPane4 = new DummyDocumentPane(5,"man1.pgdp.sse.in.tum.de/showchar.1.html",
                adminController);
        DummyDocumentPane dummyDocumentPane5 = new DummyDocumentPane(6,"man1.pgdp.sse.in.tum.de/showchar.1.html",
                adminController);
        DummyDocumentPane dummyDocumentPane6 = new DummyDocumentPane(7,"man1.pgdp.sse.in.tum.de/showchar.1.html",
                adminController);

        /*
        adminView.addDocumentPane(documentPane);
        adminView.addDocumentPane(dummyDocumentPane);
        adminView.addDocumentPane(dummyDocumentPane2);
        adminView.addDocumentPane(dummyDocumentPane3);
        adminView.addDocumentPane(dummyDocumentPane4);
        adminView.addDocumentPane(dummyDocumentPane5);
        adminView.addDocumentPane(dummyDocumentPane6);
        */
        //


        adminView.setAdminController(adminController);
        adminController.setAdminView(adminView);
        adminController.setAdminModel(adminModel);

        // Erzeugen der Result-Objekte und setzen der Referenzen
        ResultView resultView = new ResultView();
        ResultController resultController = new ResultController();

        resultView.setResultController(resultController);
        resultController.setResultView(resultView);
        resultController.setResultModel(resultModel);

        // Erzeugen der Search-Objekte und setzen der Referenzen
        SearchView searchView = new SearchView();
        SearchController searchController = new SearchController(searchEngineController);

        searchView.setSearchController(searchController);
        searchController.setSearchView(searchView);

        // Initialisierung der SearchEngineView (+ Setzen weiterer Referenzen auf die speziellen Views)
        searchEngineView.init(searchEngineController, adminView, resultView, searchView);
        searchEngineController.setAdminController(adminController);
        searchEngineController.setResultController(resultController);
        searchEngineController.setSearchController(searchController);

        // Sichtbar-Setzen des Haupt-Frames 'searchEngineView'
        searchEngineView.setSize(600, 600);
        searchEngineView.setVisible(true);
        searchEngineView.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
