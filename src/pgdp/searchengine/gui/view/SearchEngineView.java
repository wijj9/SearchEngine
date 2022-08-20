package pgdp.searchengine.gui.view;

import pgdp.searchengine.gui.controller.SearchEngineController;

import javax.swing.*;
import java.awt.*;

/** Das Haupt-Frame. Besteht aus einer Top-Bar oben, in der der Titel der aktuellen View und einige Buttons angezeigt
 *  werden, sowie das Haupt-Fenster darunter, in das die jeweils angezeigte View (Admin View, Result View oder
 *  Search View) geladen wird.
 */
public class SearchEngineView extends JFrame {
    private SearchEngineController searchEngineController;

    private TopBar topBar;
    private JPanel body;

    private AdminView adminView;
    private ResultView resultView;
    private SearchView searchView;
    private JPanel p = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();


    // TODO: Evtl. mehr Attribute ?? (nicht unbedingt nötig)

    public SearchEngineView() {
        super("PinguPinguLos");
    }

    public void setSearchEngineController(SearchEngineController searchEngineController) {
        this.searchEngineController = searchEngineController;
    }

    /** Initialisiert die Search Engine View mit einer neuen Top-Bar in 'topBar' und einem Panel in 'body',
     *  in dem, je nach Programmzustand, je eines der drei übergebenen Views angezeigt werden kann.
     *  Als Erstes wird die dabei Search View angezeigt.
     *  Setzt außerdem die vier Attribute 'searchEngineController', 'adminView', 'resultView'
     *  und 'searchView' auf die entsprechenden Parameter.
     *
     * @param searchEngineController Ein Search Engine Controller
     * @param adminView Eine Admin View
     * @param resultView Eine Result View
     * @param searchView Eine Search View
     */
    public void init(SearchEngineController searchEngineController, AdminView adminView, ResultView resultView, SearchView searchView) {
        // TODO: Implementieren
        this.topBar = new TopBar(searchEngineController);
        this.body = new JPanel();
        this.searchEngineController = searchEngineController;
        this.adminView = adminView;
        this.resultView = resultView;
        this.searchView = searchView;
        body.add(searchView);
        body.add(resultView);
        body.add(adminView);
        p.add(searchView);
        p2.add(adminView);
        p3.add(resultView);
        //topBar.search();
        //topBar.adminV();
        //topBar.resultat();
        //displayResultView();
        //displayAdminView();
        displaySearchView();
    }


    /** Diese drei Methoden zeigen die dem Namen entsprechende View an.
     *  Dabei wird der Titel in der Top-Bar korrekt gesetzt und die Buttons in ihr, die in dieser View nicht angezeigt
     *  werden sollen, werden versteckt.
     */
    public void displayAdminView() {
        // TODO: Implementieren
        topBar.adminV();
        topBar.search();
        topBar.resultat();
        searchView.setVisible(false);
        resultView.setVisible(false);
        adminView.setVisible(true);
        //p.remove(resultView);
        //p.add(topBar);
        //p.remove(searchView);
        p.setLayout(new BorderLayout());
        p.add(topBar,BorderLayout.NORTH);
        p.add(adminView,BorderLayout.CENTER);
        this.add(p);
    }

    public void displayResultView() {
        // TODO: Implementieren
        topBar.resultat();
        topBar.search();
        topBar.adminV();
        adminView.setVisible(false);
        searchView.setVisible(false);
        resultView.setVisible(true);
        //p.remove(adminView);
        //p.add(resultView);
        //p.remove(searchView);
        //p.add(topBar);
        //p.remove(adminView);
        p.setLayout(new BorderLayout());
        p.add(topBar, BorderLayout.NORTH);
        p.add(resultView,BorderLayout.CENTER);
        this.add(p);
    }

    public void displaySearchView() {
        // TODO: Implementieren
        topBar.search();
        topBar.adminV();
        p.remove(adminView);
        resultView.setVisible(false);
        searchView.setVisible(true);
        //top
        //topBar.add(body);
        //p.add(topBar);
        //p.add(body);
        //this.setContentPane(p);
        p.setLayout(new BorderLayout());
        p.add(topBar, BorderLayout.NORTH);
        p.add(searchView,BorderLayout.CENTER);
        //searchView.add(topBar,gbc);
        //this.setLayout(new BorderLayout());
        this.add(p);
    }

}
