/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import gui.KlijentForma;
import java.util.ArrayList;
import kontorlor.Kontroler;

/**
 *
 * @author Drobnjakovic
 */
public class OnlineKorisnici extends Thread {

    KlijentForma kf;

    public OnlineKorisnici(KlijentForma kf) {
        this.kf = kf;
    }

    @Override
    public void run() {
        while (true) {
  ArrayList<String> online = Kontroler.getInstance().getKorisnici();
            kf.Namesti(online);
        }
    }

}
