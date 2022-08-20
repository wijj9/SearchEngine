package pgdp.searchengine.gui.view;

import pgdp.searchengine.gui.controller.AdminController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Stellt den Dialog dar, der aufpoppt, wenn man in der Admin View den Crawl-Button drückt.
 *  Es wird erstens nach einer Start-Adresse zum crawlen und zweitens nach der Anzahl an zu crawlenden
 *  Seiten gefragt.
 *  Der Nutzer hat die Möglichkeit, auf einen von zwei Buttons zu drücken:
 *   1. Cancel: Bricht das Crawling ab, bevor es begonnen hat.
 *   2. Crawl: Crawlt mit den aktuell eingegebenen Parametern
 *
 *  Der Dialog zeigt sich nicht selbst an (ruft also nicht 'setVisible(true)' auf), sondern wartet,
 *  bis er von außen her (= in SearchEngineController.crawlButtonPressed() dann) sichtbar gesetzt wird.
 */
public class CrawlDialog extends JDialog {

    /** Erzeugt den Dialog wie oben beschrieben.
     *  Mittels des 'adminController's können die Buttons nach außen hin kommunizieren.
     *
     * @param adminController Ein Admin Controller
     */
    public CrawlDialog(AdminController adminController) {
        // TODO: Implementieren
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());

        this.setBounds(20,20,500,250);
        JButton crawl = new JButton("Crawl");
        JButton cancel = new JButton("Cancel");
        JPanel pbottom = new JPanel();
        GroupLayout pbottomLayout = new GroupLayout(pbottom);
        pbottom.setLayout(pbottomLayout);
        pbottomLayout.setHorizontalGroup(
                pbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbottomLayout.createSequentialGroup()
                                .addGap(0, 500, Short.MAX_VALUE)
                                .addComponent(cancel)
                                .addGap(0, 0, 0)
                                .addComponent(crawl))
        );
        pbottomLayout.setVerticalGroup(
                pbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pbottomLayout.createSequentialGroup()
                                .addGroup(pbottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancel)
                                        .addComponent(crawl)))
        );


        JPanel pcenter = new JPanel();
        pcenter.setLayout(new BoxLayout(pcenter,BoxLayout.Y_AXIS));


        JLabel amount = new JLabel("Amount");

        SpinnerNumberModel model = new SpinnerNumberModel(0,0,10,1);
        JSpinner spinner = new JSpinner(model);
        Dimension d1 = new Dimension();
        d1.width = 400;
        d1.height = 30;
        spinner.setMaximumSize(d1);
        spinner.setMinimumSize(d1);
        spinner.setPreferredSize(d1);

        JLabel address = new JLabel("Address");


        JTextField field = new JTextField();
        Dimension d = new Dimension();
        d.width = 400;
        d.height = 30;
        field.setMaximumSize(d);
        field.setMinimumSize(d);
        field.setPreferredSize(d);

        pcenter.setAlignmentX(LEFT_ALIGNMENT);

        pcenter.add(amount);

        pcenter.add(spinner);

        pcenter.add(address);

        pcenter.add(field);

        p.add(pbottom,BorderLayout.PAGE_END);
        p.add(pcenter,BorderLayout.CENTER);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });
        crawl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adminController.crawlFromAddress(Integer.parseInt(spinner.getValue()+""),field.getText());
                setVisible(false);
            }
        });

        this.add(p);

    }

}
