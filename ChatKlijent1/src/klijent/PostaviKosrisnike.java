/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import gui.KlijentForma;
import java.util.ArrayList;

/**
 *
 * @author Drobnjakovic
 */
public class PostaviKosrisnike extends Thread {

    KlijentForma kf;

    public PostaviKosrisnike(KlijentForma kf) {
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
