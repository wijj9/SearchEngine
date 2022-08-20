package pgdp.searchengine.gui.view;

import pgdp.searchengine.gui.controller.AdminController;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Stellt die Admin View dar. Sie ist als JScrollPane implementiert und zeigt
 *   1. alle bisher vom Admin Controller geladenen Dokumente untereinander in Form von AbstractDocumentPane-Objekten
 *   2. darunter noch einen Button zum Laden weiterer Dokumente
 *  an.
 */
public class AdminView extends JScrollPane {
    // TODO: Komponenten hinzufügen (und evtl. noch weitere Attribute ??)
    private AdminController adminController;


    private JButton b4 = new JButton("Load More");

    private JScrollPane sp;
    private JPanel p1 = new JPanel();
    private JPanel p2 = new JPanel();
    private JPanel p3 = new JPanel();
    private JPanel p4 = new JPanel();
    private JPanel p5 = new JPanel();

    /** Erzeugt
     *   1. ein Panel (o.Ä.) für die AbstractDocumentPanes
     *   2. den Load-More-Button
     */
    public AdminView() {
        // TODO: Implementieren
        b4.setText("Load More");

        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminController.loadNextBatch();

            }
        });
        sp = new JScrollPane();
        p5.setLayout(new BoxLayout(p1,BoxLayout.Y_AXIS));
        this.setLayout(new ScrollPaneLayout());
        //p1.setLayout(bagLayout);

        p1.setLayout(new BorderLayout());
        p1.add(b4,BorderLayout.PAGE_END);

        this.setViewportView(p1);
    }

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    /** Fügt das übergebene AbstractDocumentPane-Objekt unten an die bereits vorhandenen an
     *  und updatet dann die Anzeige (mit einem Call der Methode 'updateUI()').
     */
    public void addDocumentPane(AbstractDocumentPane documentPane) {
        // TODO: Implementieren

        JButton b = new JButton("Crawl");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminController.crawlButtonPressedForAddress(documentPane.addressLabel.getText());
            }
        });


        if (documentPane instanceof DummyDocumentPane) {

            JPanel pp = new JPanel();


            p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

            p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
            p3.setBackground(Color.RED);


            p3.setAlignmentX(LEFT_ALIGNMENT);

            p3.add(documentPane.idLabel);

            p3.add(documentPane.addressLabel);


            p3.add(b);
            JPanel pg = new JPanel();
            pg.setBackground(getBackground());
            p3.add(pg);



            p2.add(p3);



            pp.add(p2);


            p1.add(pp);

            //this.i=i+3;
            this.setViewportView(p1);
            updateUI();
        }
        else if (documentPane instanceof DocumentPane){
            p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));

            p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));

            JPanel pp1 = new JPanel();


            p4.add(documentPane.idLabel);
            p4.add(documentPane.addressLabel);
            p4.add(((DocumentPane) documentPane).getTitleLabel());
            p4.add(((DocumentPane) documentPane).getContentLabel());
            p4.add(((DocumentPane) documentPane).getLinksToLabel());

            JPanel pg = new JPanel();
            pg.setBackground(getBackground());
            p4.add(pg);


            p2.add(p4);




            pp1.add(p2);

            p1.add(pp1);

            this.setViewportView(p1);
            updateUI();
        }
    }

    /** Löscht alle angezeigten AbstractDocumentPane-Objekte aus der View
     *  (nicht aber den Load-More-Button).
     */
    public void clear() {
        // TODO: Implementieren
        p2.setVisible(false);
    }
}
