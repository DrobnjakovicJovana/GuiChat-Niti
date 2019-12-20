/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Drobnjakovic
 */
public class ServerskiOdgovor implements Serializable{
   String poruka;
String username;
boolean povezano;
int signal;
    ArrayList<String> korisnici;

    public ArrayList<String> getKorisnici() {
        return korisnici;
    }

    public void setKorisnici(ArrayList<String> korisnici) {
        this.korisnici = korisnici;
    }
    
    public void setSignal(int signal) {
        this.signal = signal;
    }

    public int getSignal() {
        return signal;
    }


    public void setPovezano(boolean povezano) {
        this.povezano = povezano;
    }

    public ServerskiOdgovor(String poruka, String username) {
        this.poruka = poruka;
        this.username = username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

 

    public String getUsername() {
        return username;
    }

  

    public ServerskiOdgovor() {
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }

    public boolean isPovezano() {
        return povezano;
    }

    
    
}
