package pgdp.searchengine.gui.controller;

import pgdp.searchengine.gui.model.AdminModel;
import pgdp.searchengine.gui.view.AbstractDocumentPane;
import pgdp.searchengine.gui.view.AdminView;
import pgdp.searchengine.gui.view.DocumentPane;
import pgdp.searchengine.gui.view.DummyDocumentPane;
import pgdp.searchengine.networking.PageCrawling;
import pgdp.searchengine.pagerepository.*;

import java.util.List;

public class AdminController {
    private AdminView adminView;
    private AdminModel adminModel;

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    /** Teilt dem 'adminModel' mit, dass es alle Dokumente neu laden soll
     *  und lädt dann das erste Batch (AdminModel.BATCH_SIZE Stück) in die Admin View.
     */
    public void loadDocuments() {
        // TODO: Implementieren
        adminModel.loadListOfAllDocuments();
        loadIntoView(adminModel.getDocumentsSoFar());
    }

    /** Lädt das nächste Batch (die nächsten AdminModel.BATCH_SIZE Stück) an Dokumenten in die Admin View.
     */
    public void loadNextBatch() {
        // TODO: Implementieren
        List<AbstractLinkedDocument> l = adminModel.getNextBatch();
        loadIntoView(l);
    }

    /** Lädt alle Dokumente in der übergebenen Liste in die Admin View, indem es für jeden davon
     *  die korrekte 'AbstractDocumentPane' erstellt und diese dann in die Admin View einfügt.
     *
     * @param documents Liste mit in die Admin View zu ladenden Dokumenten
     */
    public void loadIntoView(List<AbstractLinkedDocument> documents) {
        // TODO: Implementieren
        for (AbstractLinkedDocument abstractLinkedDocument : documents) {
            if (abstractLinkedDocument instanceof DummyLinkedDocument) {
                DummyDocumentPane documentPane = new DummyDocumentPane(
                        abstractLinkedDocument.getDocumentId(),
                        abstractLinkedDocument.getAddress(),
                        this
                ) {
                    @Override
                    public void setId(int id) {
                        super.setId(id);
                    }

                    @Override
                    public void setAddress(String address) {
                        super.setAddress(address);
                    }
                };
                adminView.addDocumentPane(documentPane);
            } else if (abstractLinkedDocument instanceof LinkedDocument){
                LinkedDocumentCollection out = ((LinkedDocument) abstractLinkedDocument).getOutgoingLinks();
                DocumentListElement[] ar = out.toArray();
                int[]a = new int[out.size()];
                for (int i= 0; i< ar.length;i++){
                    a[i] = ar[i].getDocumentId();
                }
                DocumentPane documentPane = new DocumentPane(
                        abstractLinkedDocument.getDocumentId(),
                        abstractLinkedDocument.getAddress(),
                        abstractLinkedDocument.getTitle(),
                        abstractLinkedDocument.getContent(),
                        a
                ) {
                    @Override
                    public void setId(int id) {
                        super.setId(id);
                    }

                    @Override
                    public void setAddress(String address) {
                        super.setAddress(address);
                    }
                };
                adminView.addDocumentPane(documentPane);
            }
        }
    }

    /** Diese Methode wird aufgerufen, wenn in der 'DummyDocumentPane' eines Dummy-Dokumentes der Crawl-Button
     *  gedrückt wurde.
     *  Crawlt diese Adresse und lädt dann die Admin View neu, da sich die Dokumente ja (eventuell) geändert haben.
     *  Es sollen genauso viele Dokumente wieder in die Admin View geladen werden, wie davor angezeigt wurden,
     *  also 'adminModel.numberOfLoadedDocuments' Stück.
     *
     * @param address
     */
    public void crawlButtonPressedForAddress(String address) {
        // TODO: Implementieren
        PageCrawling.crawlPages(adminModel.getDocumentCollection(),1,address);
        loadDocuments();
    }

    /** Diese Methode wird aufgerufen, wenn der Crawl-Button in der Top-Bar gedrückt und der daraufhin aufpoppende
     *  Dialog ausgefüllt und "abgeschickt" wurde.
     *  Crawlt von der Adresse 'address' aus 'amount' Seiten und lädt dann die Dokumente neu. (Wie viele ist egal,
     *  nur nicht keine.)
     *
     * @param amount Anzahl an zu crawlenden Seiten
     * @param address Startadresse zum Crawlen
     */
    public void crawlFromAddress(int amount, String address) {
        // TODO: Implementieren
        //PageCrawling.crawlPages(adminModel.getDocumentCollection(),amount,address);
        adminModel.crawlPageWithAddress(amount,address);
        loadNextBatch();
    }
}
