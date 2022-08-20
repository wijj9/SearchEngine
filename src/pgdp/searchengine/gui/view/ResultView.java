package pgdp.searchengine.gui.view;

import pgdp.searchengine.gui.controller.ResultController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/** Stellt die Result View dar. Sie ist als JScrollPane implementiert und zeigt
 *   1. alle bisher vom Result Controller geladenen Ergebnisse der letzten Suchanfrage untereinander
 *      in Form von ResultPane-Objekten
 *   2. darunter noch einen Button zum Laden weiterer Dokumente
 *  an.
 */
public class ResultView extends JScrollPane {
    // TODO: Komponenten hinzufügen (und evtl. noch weitere Attribute ??)
    private ResultController resultController;
    private JButton b = new JButton();
    private JScrollPane sp ;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel pp1 = new JPanel();
    /** Erzeugt
     *   1. ein Panel (o.Ä.) für die AbstractDocumentPanes
     *   2. den Load-More-Button
     */
    public ResultView() {
        // TODO: Implementieren
        b.setText("Load More");
        sp = new JScrollPane();
        this.setLayout(new ScrollPaneLayout());
        p1.setLayout(new BorderLayout());
        p1.add(b,BorderLayout.PAGE_END);

        this.setViewportView(p1);
    }

    public void setResultController(ResultController resultController) {
        this.resultController = resultController;
    }

    /** Fügt das übergebene ResultPane-Objekt unten an die bereits vorhandenen an
     *  und updatet dann die Anzeige (mit einem Call der Methode 'updateUI()').
     */
    public void addResultPane(ResultPane resultPane) {
        // TODO: Implementieren

        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));




        p4.add(resultPane.getLinkLabel());
        p4.add(resultPane.getTitleLabel());
        p4.add(resultPane.getContentLabel());

        JPanel pg = new JPanel();
        pg.setBackground(getBackground());
        p4.add(pg);

        p2.add(p4);
        Border black = BorderFactory.createLineBorder(Color.black);
        p2.setBorder(black);


        pp1.add(p2);
        Border black1 = BorderFactory.createLineBorder(Color.black);
        pp1.setBorder(black1);

        p1.add(pp1);

        this.setViewportView(p1);
        updateUI();
    }

    /** Löscht alle angezeigten ResultPane-Objekte aus der View
     *  (nicht aber den Load-More-Button).
     */
    public void clear() {
        // TODO: Implementieren
        pp1.setVisible(false);
    }

}
