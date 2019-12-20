/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nit;

import gui.FormaServer;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import kontorlor.Kontroler;


/**
 *
 * @author Drobnjakovic
 */
public class PokreniServer extends Thread {

    FormaServer fs;

    public PokreniServer(FormaServer fs) {
        this.fs = fs;
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(9000);
            fs.postaviTekst();
            while (true) {
                Socket s = ss.accept();
                ObradaZahteva obrada = new ObradaZahteva(s,fs);
                obrada.start();
                Kontroler.getInstance().addSoket(s);
            }
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
