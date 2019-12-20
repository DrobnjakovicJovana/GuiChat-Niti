/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import gui.KlijentForma;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Drobnjakovic
 */
public class Osluskivanje extends Thread {

    JTextArea area;

    ArrayList<String> online;
    KlijentForma kf;
    String pomocna = "";

    public Osluskivanje(JTextArea area, KlijentForma kf) {
        this.area = area;
        this.kf = kf;
    }

    @Override
    public void run() {
        while (true) {
            ServerskiOdgovor so = PovezivanjeServer.getInstance().primiOdgovor();
            if (so.getSignal() != 0) {
                String kon = area.getText() + "\n" + so.getPoruka();
                area.setText(kon);
            }

        }
    }

}
