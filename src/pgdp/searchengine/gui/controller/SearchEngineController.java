package pgdp.searchengine.gui.controller;

import pgdp.searchengine.gui.model.ResultModel;
import pgdp.searchengine.gui.view.CrawlDialog;
import pgdp.searchengine.gui.view.ResultPane;
import pgdp.searchengine.gui.view.ResultView;
import pgdp.searchengine.gui.view.SearchEngineView;
import pgdp.searchengine.networking.HTMLProcessing;
import pgdp.searchengine.networking.HTTPRequest;
import pgdp.searchengine.networking.HTTPResponse;
import pgdp.searchengine.networking.PageCrawling;
import pgdp.searchengine.pagerepository.DocumentListElement;
import pgdp.searchengine.pagerepository.LinkedDocumentCollection;

import javax.swing.text.html.HTML;
import java.awt.event.WindowEvent;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Optional;

public class SearchEngineController {
    private SearchController searchController;
    private ResultController resultController;
    private AdminController adminController;

    private SearchEngineView searchEngineView;

    public void setSearchEngineView(SearchEngineView searchEngineView) {
        this.searchEngineView = searchEngineView;
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    public void setResultController(ResultController resultController) {
        this.resultController = resultController;
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    /** Arbeitet die übergebene Such-Anfrage ab.
     *  Teilt dabei dem Result Controller mit, die entsprechenden Ergebnisse zu laden
     *  und wechselt dann die aktuell angezeigte View von der Search View zur Result View.
     *
     * @param query Der Such-String
     */
    public void processQuery(String query) {
        // TODO: Implementieren
        LinkedDocumentCollection l = new LinkedDocumentCollection(10);
        if (PageCrawling.crawlPage(l,query)) {
            PageCrawling.crawlPages(l,1,query);
            DocumentListElement[] array = l.toArray();
            ArrayList<ResultPane> rpList = new ArrayList<>();
            for (DocumentListElement documentListElement : array) {
                if (!documentListElement.getDocument().getContent().equals("")) {
                    ResultPane rp = new ResultPane(query, documentListElement.getDocument().getTitle(),
                            documentListElement.getDocument().getContent());
                    rpList.add(rp);
                }
            }
            resultController.setResultModel(new ResultModel(l));
            resultController.loadResultsFor(query);
            changeToResultView();
        }

    }

    public void changeToAdminView() {
        searchEngineView.displayAdminView();
    }

    public void changeToResultView() {
        searchEngineView.displayResultView();
    }

    public void changeToSearchView() {
        searchEngineView.displaySearchView();
    }

    /** Wird aufgerufen, wenn der Crawl-Button, der in der Admin View in der Top-Bar zu sehen ist,
     *  gedrückt wurde.
     *  Erstellt einen neuen CrawlDialog und macht ihn sichtbar.
     */
    public void crawlButtonPressed() {
        // TODO: Implementieren
        CrawlDialog crawlDialog = new CrawlDialog(adminController);
        crawlDialog.setVisible(true);
    }

    public void exitButtonPressed() {
        searchEngineView.dispatchEvent(new WindowEvent(searchEngineView, WindowEvent.WINDOW_CLOSING));
    }
}
