/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Drobnjakovic
 */
public class PovezivanjeServer {

    private static PovezivanjeServer pov;
    private Socket s;

    public static PovezivanjeServer getInstance() {
        if (pov == null) {
            pov = new PovezivanjeServer();
        }
        return pov;
    }

    public boolean poveziSe(String username) {
        try {
            s = new Socket("localhost", 9000);
            return true;
        } catch (IOException ex) {

            Logger.getLogger(PovezivanjeServer.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public ServerskiOdgovor primiOdgovor() {
        ServerskiOdgovor so = new ServerskiOdgovor();
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            so = (ServerskiOdgovor) ois.readObject();
        } catch (IOException ex) {
            Logger.getLogger(PovezivanjeServer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PovezivanjeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return so;
    }

    public void posaljiZahtev(KlijentskiZahtev kz) {
        try {
            ObjectOutputStream ous = new ObjectOutputStream(s.getOutputStream());
            ous.writeObject(kz);
        } catch (IOException ex) {
            Logger.getLogger(PovezivanjeServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
