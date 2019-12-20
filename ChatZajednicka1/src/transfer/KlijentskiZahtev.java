/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transfer;

import java.io.Serializable;

/**
 *
 * @author Drobnjakovic
 */
public class KlijentskiZahtev implements Serializable{
    private int operacija;
    private String poruka;
    private String username;

    public KlijentskiZahtev() {
    }

    public KlijentskiZahtev(int operacija, String poruka, String username) {
        this.operacija = operacija;
        this.poruka = poruka;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getOperacija() {
        return operacija;
    }

    public void setOperacija(int operacija) {
        this.operacija = operacija;
    }

    public String getPoruka() {
        return poruka;
    }

    public void setPoruka(String poruka) {
        this.poruka = poruka;
    }
    
}
