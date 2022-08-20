package pgdp.searchengine.gui.view;

import pgdp.searchengine.gui.controller.SearchController;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Stellt die Search View dar. Sie enthält
 *   1. den Text "PinguPinguLos" fett über dem Suchfeld und dem Search-Button.
 *   2. das Suchfeld
 *   3. den Search-Button
 */
public class SearchView extends JPanel {
    // TODO: Evtl. Attribute ??
    private JButton sButton = new JButton("Search");
    private JLabel pingupingu = new JLabel("PingupinguLos");
    private JTextField feld = new JTextField("pingu?");



    private SearchController searchController;

    /** Erzeugt
     *   1. Den Text "PinguPinguLos" in einer großen, fetten Schrift über den beiden anderen Komponenten.
     *   2. Ein Text-Feld, in das man Suchanfragen eingeben kann.
     *   3. Rechts neben 2. einen Search-Button, auf dessen Klick hin die Suche mit dem aktuell in 2. stehenden
     *      String abgeschickt wird.
     */
    public SearchView() {
        // TODO: Implementieren
        Border grey = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
        feld.setText("penguins?");
        feld.setFont(new Font("Serif",Font.PLAIN,20));
        Dimension d = new Dimension();
        d.width = 200;
        d.height = 40;
        feld.setMaximumSize(d);
        feld.setMinimumSize(d);
        feld.setPreferredSize(d);
        sButton.setText("Search");


        pingupingu.setText("          PinguPinguLos");
        pingupingu.setFont(new Font("Serif", Font.BOLD,20));

        GridBagLayout gb = new GridBagLayout();
        this.setLayout(gb);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy =0;
        gbc.ipadx = 5;
        gbc.ipady = 10;
        this.add(pingupingu, gbc);

        gbc.gridx = 0;
        gbc.gridy =1;
        feld.setBorder(grey);
        this.add(feld, gbc);



        gbc.gridx = 1;
        gbc.gridy =1;
        this.add(sButton, gbc);

        sButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchController.executeSearch(feld.getText());
            }
        });
    }

    public void setSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

}
