/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Drobnjakovic
 */
public class Kontroler {

    private static Kontroler kon;
    ArrayList<Socket> soketi = new ArrayList<>();
    ArrayList<String> korisnici = new ArrayList<>();

    public ArrayList<String> getKorisnici() {
        return korisnici;
    }

    public ArrayList<Socket> getSoketi() {
        return soketi;
    }
    public void addKorisnik(String korisnik){
    korisnici.add(korisnik);
    }
    public void addSoket(Socket s){
    soketi.add(s);
    }
    public static Kontroler getInstance() {
        if (kon == null) {
            kon = new Kontroler();
        }
        return kon;
    }
}
