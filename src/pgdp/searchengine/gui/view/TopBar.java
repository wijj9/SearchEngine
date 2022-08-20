package pgdp.searchengine.gui.view;

import pgdp.searchengine.gui.controller.AdminController;
import pgdp.searchengine.gui.controller.SearchEngineController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/** Stellt die Leiste mit Überschrift und Buttons ganz oben im Frame dar.
 */
public class TopBar extends JPanel{
    private JLabel title;
    private JPanel cards;

    private JButton crawlButton;
    private JButton toAdminViewButton;
    private JButton toSearchViewButton;
    private JButton exitButton;

    private JPanel jPanel3 ;
    private JButton toSearchViewButton2;
    private JButton exitButton2 ;
    private JLabel labelAdmin;
    private JButton exitButton3;

    private JPanel jPanel1;
    private JButton toAdminViewButton2;
    private JLabel resultsLabel;

    private JLabel searchLabel;
    private JPanel jPanel2;


    public JButton getToAdminViewButton() {
        return toAdminViewButton;
    }

    public JButton getExitButton() {
        return exitButton;
    }

    public JLabel getSearchLabel() {
        return searchLabel;
    }

    /**
     * Setzt die fünf Attribute dieser Klasse auf neue Objekte des entsprechenden Typs
     * und fügt den Buttons geeignete ActionListener (Lambdas genügen hier völlig) hinzu.
     * Zwischen dem Titel und den Buttons ist Platz, d.h. der Titel befindet sich ganz links,
     * die Buttons ganz rechts in der Top-Bar.
     *
     * @param controller Ein Search Engine Controller (für die Events)
     */
    public TopBar(SearchEngineController controller) {
        // TODO: Implementieren
        jPanel1 = new JPanel();
        exitButton = new JButton("Exit");
        toSearchViewButton = new JButton("Back to Search");
        toAdminViewButton = new JButton("Admin View");
        resultsLabel = new JLabel("");

        jPanel3 = new JPanel();
        toSearchViewButton2 = new JButton("Back to Search");
        exitButton2 = new JButton("Exit");
        labelAdmin = new JLabel();
        crawlButton = new JButton("Crawl");

        jPanel2 = new JPanel();
        toAdminViewButton2 = new JButton("Admin View");
        exitButton3 = new JButton("Exit");
        searchLabel = new JLabel();


        this.setLayout(new CardLayout());
        toAdminViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //adminActionPerformed(evt);
                controller.changeToAdminView();
            }
        });

        exitButton.setText("Exit");
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButton2ActionPerformed(evt);
                //controller.exitButtonPressed();
            }
        });

        toSearchViewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                controller.changeToSearchView();
                searchbuttonActionPerformed(evt);
            }
        });

        exitButton3.setText("Exit");
        exitButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                exitButtonActionPerformed(evt);
                //controller.exitButtonPressed();
            }
        });

        exitButton2.setText("Exit");
        exitButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //controller.exitButtonPressed();
                exitButton3ActionPerformed(evt);
            }
        });

        toSearchViewButton.setText("Back to Search");
        toSearchViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchButton3ActionPerformed(evt);
                controller.changeToSearchView();
            }
        });

        toAdminViewButton2.setText("Admin View");
        toAdminViewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //adminviewActionPerformed(evt);
                controller.changeToAdminView();
            }
        });

        crawlButton.setText("Crawl");
        crawlButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //crawlActionPerformed(evt);
                //controller.changeToResultView();
                controller.crawlButtonPressed();
            }
        });

    }

    public void search(){
        toAdminViewButton.setText("Admin View");

        searchLabel.setText("Search");
        searchLabel.setFont(new Font("Serif",Font.PLAIN,25));

        GroupLayout searchbarLayout = new GroupLayout(jPanel2);
        jPanel2.setLayout(searchbarLayout);
        searchbarLayout.setHorizontalGroup(
                searchbarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, searchbarLayout.createSequentialGroup()
                                .addComponent(searchLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 0, Short.MAX_VALUE)
                                .addComponent(toAdminViewButton)
                                .addGap(0, 0, 0)
                                .addComponent(exitButton)
                                //.addContainerGap())
        ));
        searchbarLayout.setVerticalGroup(
                searchbarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(searchbarLayout.createSequentialGroup()
                                .addGroup(searchbarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(toAdminViewButton)
                                        .addComponent(exitButton)
                                        .addComponent(searchLabel))
                                        .addGap(0,0,0)
                                //.addContainerGap(10, Short.MAX_VALUE))
                        ));
        this.add(jPanel2, "card3");
    }

    public void adminV(){
        toSearchViewButton2.setText("Back to Search");

        labelAdmin.setText("Admin View");
        labelAdmin.setFont(new Font("Serif",Font.PLAIN,25));




        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(labelAdmin)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                                .addComponent(crawlButton)
                                .addGap(0, 0, 0)
                                .addComponent(toSearchViewButton2)
                                .addGap(0, 0, 0)
                                .addComponent(exitButton3))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(toSearchViewButton2)
                                        .addComponent(exitButton3)
                                        .addComponent(labelAdmin)
                                        .addComponent(crawlButton))
                                //.addGap(0, 250, Short.MAX_VALUE))
        ));

        this.add(jPanel3, "card2");

    }
    public void resultat(){

        resultsLabel.setText("Search Results");
        resultsLabel.setFont(new Font("Serif",Font.PLAIN,25));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(resultsLabel)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 360, Short.MAX_VALUE)
                                .addComponent(toAdminViewButton2)
                                .addGap(0, 0, 0)
                                .addComponent(toSearchViewButton)
                                .addGap(0, 0, 0)
                                .addComponent(exitButton2)
                                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(exitButton2)
                                        .addComponent(toSearchViewButton)
                                        .addComponent(toAdminViewButton2)
                                        .addComponent(resultsLabel))
                                //.addGap(0, 0, Short.MAX_VALUE))
        ));

        this.add(jPanel1, "card4");
    }

    private void adminActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();
        JPanel buttonPanel = (JPanel)button.getParent();
        JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
        CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
        layout.show(cardLayoutPanel, "card2");
    }

    private void searchbuttonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();
        JPanel buttonPanel = (JPanel)button.getParent();
        JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
        CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
        layout.show(cardLayoutPanel, "card3");
    }

    private void searchButton3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();
        JPanel buttonPanel = (JPanel)button.getParent();
        JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
        CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
        layout.show(cardLayoutPanel, "card3");
    }

    private void adminviewActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();
        JPanel buttonPanel = (JPanel)button.getParent();
        JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
        CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
        layout.show(cardLayoutPanel, "card2");
    }

    private void crawlActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        JButton button = (JButton) evt.getSource();
        JPanel buttonPanel = (JPanel)button.getParent();
        JPanel cardLayoutPanel = (JPanel)buttonPanel.getParent();
        CardLayout layout = (CardLayout)cardLayoutPanel.getLayout();
        layout.show(cardLayoutPanel, "card4");
    }

    private void exitButton3ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void exitButtonActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }

    private void exitButton2ActionPerformed(ActionEvent evt) {
        // TODO add your handling code here:
        System.exit(0);
    }


    /** Setzt den Text im title-Feld auf den übergebenen Text.
     *
     * @param titleText Neuer Titel-Text
     */
    public void setTitle(String titleText) {
        title.setText(titleText);
    }

    /** Setzt den dem Methodennamen entsprechenden Button unsichtbar.
     */
    public void hideCrawlButton() {
        crawlButton.setVisible(false);
    }

    public void hideToAdminViewButton() {
        toAdminViewButton.setVisible(false);
    }

    public void hideToSearchViewButton() {
        toSearchViewButton.setVisible(false);

    }

    /** Setzt alle Buttons auf sichtbar.
     */
    public void setAllButtonsVisible() {
        crawlButton.setVisible(true);
        toAdminViewButton.setVisible(true);
        toSearchViewButton.setVisible(true);
        exitButton.setVisible(true);
    }
}
