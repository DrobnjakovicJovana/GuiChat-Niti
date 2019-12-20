/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import gui.FormaServer;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontorlor.Kontroler;

import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Drobnjakovic
 */
public class ObradaZahteva extends Thread {

    Socket s;
    FormaServer fs;

    public ObradaZahteva(Socket s, FormaServer fs) {
        this.s = s;
        this.fs = fs;
    }
    
   

    @Override
    public void run() {
        while (true) {
            KlijentskiZahtev kz = primiZahtev();
            ServerskiOdgovor so = new ServerskiOdgovor();
            switch (kz.getOperacija()) {
                case 1:
                    String username = kz.getUsername();
                    so.setUsername(username);
                    so.setPovezano(true);
                    Kontroler.getInstance().addKorisnik(username);
                      fs.addUser(kz);
                    break;
                case 2:
                    String us = kz.getUsername();
                    String poruka = us+": "+ kz.getPoruka();
                    so.setUsername(us);
                    so.setPoruka(poruka);
                    so.setPovezano(true);
                    so.setSignal(1);
                    break;
            }
            ArrayList<Socket> soketi = Kontroler.getInstance().getSoketi();
            for (Socket socket : soketi) {
                posaljiOdgovor(so,socket);
            }
        }
    }

    private KlijentskiZahtev primiZahtev() {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());

            kz = (KlijentskiZahtev) ois.readObject();
        } catch (IOException ex) {
            System.out.println("Primanje zahteva nije uspelo");
        } catch (ClassNotFoundException ex) {
           System.out.println("Primanje zahteva nije uspelo");
        }
        return kz;
    }

    private void posaljiOdgovor(ServerskiOdgovor so, Socket s) {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(s.getOutputStream());
            ous.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
