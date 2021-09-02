package model.Tipologia;


import model.Dolci.Dolci;

import java.util.ArrayList;

public class Tipologia {

    private int id;
    private String tipologia; //o prodotto forno o prodotto frigo



    public Tipologia() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

}
